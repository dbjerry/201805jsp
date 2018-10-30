package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String uri = req.getRequestURI();
		
		if(uri.equals("/") || uri.equals("/login/login.jsp") || uri.equals("/dditLogin")){
			chain.doFilter(request, response);
		
		}else{
			if(session.getAttribute("S_USER") == null){
				request.getRequestDispatcher("/").forward(request, response);
			}
			
			chain.doFilter(request, response);
		}
		
	}
	@Override
	public void destroy() {}

}

