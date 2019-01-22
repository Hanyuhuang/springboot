package com.hyh.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String user = (String) request.getSession().getAttribute("User");
		if(user!=null) {
			return true;
		}else {
			request.setAttribute("msg", "请重新登录");
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
	}

	
}
