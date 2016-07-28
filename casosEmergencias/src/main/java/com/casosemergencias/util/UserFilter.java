package com.casosemergencias.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.casosemergencias.model.User;


public class UserFilter implements Filter{

	final static Logger logger = Logger.getLogger(UserFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("UserFilter -- inicio");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
	    User user = (User) session.getAttribute("user");
	         
	        if (user == null){
	        	logger.debug("UserFilter -- usuario NO esta en sesion");
	            RequestDispatcher rd = req.getRequestDispatcher("/");
	            rd.forward(request, response);
	        }else{
	        	logger.debug("UserFilter -- usuario esta en sesion");
	        	chain.doFilter(request, response);
	        }

		logger.info("UserFilter -- fin");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}
