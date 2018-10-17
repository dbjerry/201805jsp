package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVo;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet(urlPatterns={"/prodPageList", "/prodDetail"})
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 요청 URI로 로직 분기 */
		String uri = request.getRequestURI();
		
		if(uri.equals("/prodPageList")){
			prodPageList(request, response);
		} else if(uri.equals("/prodDetail")){
			prodDetail(request, response);
		}
	}

	private void prodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ProdServiceInf service = new ProdService();
		
		String prodId = request.getParameter("prod_id");
		
		ProdVo prodVo = service.selectProdDetail(prodId);
		
		request.setAttribute("prodVo", prodVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodDetail.jsp");
		rd.forward(request, response);
		
	}

	private void prodPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProdServiceInf service = new ProdService();
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		Map<String, Object> resultMap = service.selectProdPageList(pageVo);
		
		List<ProdVo> prodList = (List<ProdVo>) resultMap.get("prodList");
		
		int pageCnt = (int) resultMap.get("prodCnt");
		
		request.setAttribute("prodList", prodList);
		request.setAttribute("pageCnt", pageCnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodPageList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

