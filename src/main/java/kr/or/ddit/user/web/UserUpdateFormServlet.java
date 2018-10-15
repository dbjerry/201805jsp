package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtil;

/**
 * Servlet implementation class UserUpdateFormServlet
 */
@WebServlet("/userUpdateForm")
public class UserUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserServiceInf service = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet UserId : " + request.getParameter("userId"));
		UserVo userVo = service.selectUser(request.getParameter("userId"));
		System.out.println("Servlet userVo : " + userVo);
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/user/userUpdateForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		
		// profile part
		Part profilePart = request.getPart("profile");

		//if(profilePart.getSize() > 0){
			
			// 파일명 구하기
			String contentDisposition = profilePart.getHeader("Content-disposition");
			
			String fileName = StringUtil.getFileName(contentDisposition);
			
			// 파일 쓰기
			/* url정보를 실제 파일경로로 변경 */
			String path = getServletContext().getRealPath("/profile");
			
			profilePart.write(path + File.separator + fileName);
			profilePart.delete();	//	파일업로드 과정에서 사용한 디스크 임시 영역을 정리

		//}
		
		
		// 파라미터 받아오기
		// pass, addr1, addr2, birth, zipcd, email, tel
		
		// String userId = request.getParameter("userId");
		// String name = request.getParameter("name");
		// String pass = request.getParameter("pass");
		// String addr1 = request.getParameter("addr1");
		// String addr2 = request.getParameter("addr2");
		// String birth = request.getParameter("birth");
		// String zipcd = request.getParameter("zipcd");
		// String email = request.getParameter("email");
		// String tel = request.getParameter("tel");
		String profile = "/profile/" + fileName;
		
		UserVo uservo = new UserVo();
		uservo.setUserId(request.getParameter("userId"));
		uservo.setName(request.getParameter("name"));
		uservo.setPass(request.getParameter("pass"));
		uservo.setAddr1(request.getParameter("addr1"));
		uservo.setAddr2(request.getParameter("addr2"));
		uservo.setBirth(request.getParameter("birth"));
		uservo.setZipcd(request.getParameter("zipcd"));
		uservo.setEmail(request.getParameter("email"));
		uservo.setTel(request.getParameter("tel"));
		uservo.setProfile(profile);
		
		service.updateUser(uservo);
		
	}

}

