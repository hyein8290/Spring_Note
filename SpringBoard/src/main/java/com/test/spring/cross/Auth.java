package com.test.spring.cross;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Auth {

	@Pointcut("execution(public String com.test.spring.BoardController.m*(..))")
	public void pc1() {}
	
	@Before("pc1()")
	public void auth(JoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		
		HttpSession session = (HttpSession)args[1];
		HttpServletResponse resp = (HttpServletResponse)args[2];
		
		try {
			
			if(session.getAttribute("id") == null) {
				resp.sendRedirect("/list");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
