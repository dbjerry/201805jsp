package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mulCalculation
 */
@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_param1 = request.getParameter("param1");
		String str_param2 = request.getParameter("param2");
		
		int param1 = Integer.parseInt(str_param1);
		int param2 = Integer.parseInt(str_param2);
		int mul = 1;
		for(int i = param1; i <= param2; i++){
			mul *= i;
		}
		
		System.out.println("mul : " + mul);
		
		HttpSession session = request.getSession();
		session.setAttribute("param1", param1);
		session.setAttribute("param2", param2);
		session.setAttribute("mul", mul);
		
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
	}

}

