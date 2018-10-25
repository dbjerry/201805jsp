package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

@WebServlet(urlPatterns={"/userAllList", "/userPageList", "/userDetail"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 요청 URI로 로직 분기 */
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet \n" + uri + "\n");
		
		// 사용자 전체조회
		if(uri.equals("/userAllList")){
			userAllList(request, response);
		
		// 사용자 페이징 조회
		} else if (uri.equals("/userPageList")){
			userPageList(request, response);
		
		// 사용자 상세조회
		} else if (uri.equals("/userDetail")) {
			userDetail(request, response);
		}
		
	}

	
	/**
	 * Method : userDetail
	 * 작성자 : pc
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 :
	 */
	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		UserServiceInf service = new UserService();
		
		// 사용자 아이디가 파라미터로 넘어옴
		String userId = request.getParameter("userId");
		
		// 사용자 아이디에 해당하는 사용자 정보 조회
		UserVo userVo = service.selectUser(userId);
		
		// jsp로 위임하기 위해 사용자 정보를 request에 저장
		request.setAttribute("userVo", userVo);
		
		// 사용자 상세 화면으로 위임
		RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
		rd.forward(request, response);
		
	}


	/**
	 * Method : userPageList
	 * 작성자 : 김지태
	 * 변경이력 :
	 * @param request
	 * @param response
	 * Method 설명 : 사용자 페이지 리스트 조회
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userPageList");
		
		// userService 생성
		UserServiceInf userService = new UserService();
		
		// userPageList 호출 : 메서드 인자 - pageVo(page, pageSize)
		PageVo pageVo = new PageVo();
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		
		// 페이지 리스트
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		
		// 페이지 건수
		int pageCnt = (int) resultMap.get("pageCnt");
		
		
		// request 객체에 저장
		request.setAttribute("userList", userList);
		request.setAttribute("pageCnt", pageCnt);
		
		// forward(userAllList.jsp --> userPageingList.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/user/userPageList.jsp");
		rd.forward(request, response);
		
	}

	
	/**
	 * Method : userAllList
	 * 작성자 : pc
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 :
	 */
	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userAllList");

		// 전체 사용자 정보 조회
		UserServiceInf userService = new UserService();
		List<UserVo> userList = userService.userAllList();
		
		// 조회된 사용자 정보를 userAllList.jsp를 통해 화면처리
		// userAllList.jsp에서 userList를 참조혀려면? attribute
		
		/* 
		 * session : 해당 사용자만 접근이 가능(사용자 전용 공간
		 * 	자주 참조하는 데이터                       
		 * 	너무 많은 데이터를 저장할 경우? OOM 유발 가능성(과부하)
		 * 
		 * application : 모든 사용자가 접근 가능(서버당 하나만 생성)
		 * 	--> 일반적으로 설정과 관련된 값을 저장
		 * 
		 * request : 해당 요청의 응답이 끝날 때까지
		 */
		request.setAttribute("userList", userList);
		
		
		/*
		 * 화면으로 위임 : 2가지
		 * 1. dispatch : 보통/일반적으로 사용
		 * 2. sendRedirect : 서버에 데이터가 변경되었을 때
		 */
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

