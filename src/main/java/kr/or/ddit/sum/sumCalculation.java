package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 기존 view 요청 get : localhost:8081/sumCalculation
		// 변경 view 요청 get : sumInput.jsp forward
		// sumInput.jsp forward
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumInput.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_start = request.getParameter("start");
		String str_end = request.getParameter("end");
		
		int start = Integer.parseInt(str_start);
		int end = Integer.parseInt(str_end);
		
		CalculationLogic logic = new CalculationLogic();
		int sum = logic.sumBetweenTwoNumbers(start, end);
		
		System.out.println("sum : " + sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		session.setAttribute("sum", sum);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

}
