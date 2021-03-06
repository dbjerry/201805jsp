package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* SERVLET
		 * 
		 * page			:	존재하지 않음
		 * request		:	메서드 인자로 제공
		 * session		:	request 객체에서 획득 가능
		 * application	:	getServletContext()로 획득 가능
		 */
		
		/* JSP
		 * 
		 * page			:	pageContext(내장객체)
		 * request		:	request(내장객체)
		 * session		:	session(내장객체)
		 * application	:	application(내장객체)
		 */
		
		
		// 1.session 무효화
		// 2.session 객체를 확보
		// 3.session invalidate 메소드를 통한 무효화
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("/");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

