package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

public class LoginServlet extends HttpServlet{
	
//	private final String USERID = "brown";
//	private final String PASSWORD = "pass1234";
	
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String newParameter = req.getParameter("newParameter");
		
		UserVo userVo = new UserVo();
		//1.사용자 아이디, 비밀번호를 request객체에서 받아온다
		//2.db에서 조회해온 아이디, 비밀번호를 체크를 한다
		//3-1.일치할 경우 main.jsp로 이동
		//3-2.불일치 할경우 login.jsp로 이동
				
		//1
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("remember-me");
		
		// rememberMe == null : 아이디 기억 사용 안함
		if(rememberMe == null){
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies){
				
				// cookie 이름이 remember, userId 일 경우 maxage를
				// -1 설정하여 쿠키를 유효하지 않도록 설정
				if(cookie.getName().equals("remember") || cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					System.out.println(cookie.getMaxAge());
				}
				
			}
			
		// rememberMe != null : 아이디 기억 사용
		} else {
			// response 객체에 쿠키를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			// response 객체에 쿠키를 저장
    		
			resp.addCookie(cookie);
			resp.addCookie(userIdCookie);
		}
		
		//2 --> db대신 상수로 대체
		//UserService 객체를 생성
		UserServiceInf service = new UserService();
		
		// 1. 사용자가 전송한 userId 파라미터로 사용자 정보 조회
		// 2. db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교
		// 3. session에 사용자 정보등록(as-is : 임의의 userVo 등록
		//						   to-be : db에서 조회한 userVo)
		// pom.xml --> scope 삭제하고 기본 컴파일 scope로 전환
		
		UserVo getUser = service.selectUser(userId);
		
		//3-1 : main.jsp로 이동
//		if(getUser != null && getUser.getPass().equals(password)){
		String encryptPass = KISA_SHA256.encrypt(password);
		if(getUser != null && getUser.authPass(encryptPass)){
			//redirect
			//resp.sendRedirect("main.jsp?userId="+userId + "&password="+password);
			
			// 1.session에 사용자 정보 설정
			
//			userVo.setUserId(userId);
//			userVo.setName(userVo.getName());
//			userVo.setAlias(userVo.getAlias());
//			userVo.setBirth(userVo.getBirth());
			
			// 2.main.jsp
			// body 영역에 이름[별명]님 안녕하세요
			req.getSession().setAttribute("S_USER", getUser);
			
			//dispatch
			RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
			rd.forward(req, resp);
		
		//3-2 : login.jsp로 이동
		} else {
			resp.sendRedirect("login/login.jsp");
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		
		//userId : brwon / sally
		String[] userIds = req.getParameterValues("userId");
		for(String userId : userIds)
			pw.println("		userId : " + userId + "<br>");
		pw.println("		password : " + req.getParameter("password") + "<br>");
		pw.println("		</body>");
		pw.println("	</html>");

	}
}

