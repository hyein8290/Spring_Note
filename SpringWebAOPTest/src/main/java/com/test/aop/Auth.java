package com.test.aop;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Auth {

	@Pointcut("execute(public String AOPController.test(..)) || execute(public String AOPController.edit(..))")	
	public void pc1() {}
	
	@Before("pc1()")
	public void check(JoinPoint joinPoint) {
		
		HttpServletResponse resp = (HttpServletResponse)joinPoint.getArgs()[1];
		HttpSession session = (HttpSession)joinPoint.getArgs()[2];
		
		if(session.getAttribute("id") == null) {
			
			try {
				resp.sendRedirect("/aop/login.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
