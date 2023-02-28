package com.iu.s1.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Controller 진입 전
		// return이 true라면 다음 Controller로 진행
		// return이 false라면 다음 Contrller 로 진행 X
		System.out.println("Controller로 진입 전 체크");
		
		response.sendRedirect("");
		return true;
	}
}
