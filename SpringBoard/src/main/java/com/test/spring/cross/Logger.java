package com.test.spring.cross;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
	
	@Autowired
	private LogDAO dao;

	//주업무 > 포인트컷
	@Pointcut("execution(public String com.test.spring.BoardController.*(..))")
	public void pc1() {}
	
	//로그 기록
	@After("pc1()")
	public void log(JoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest req = (HttpServletRequest)args[0];
		HttpSession session = (HttpSession)args[1];
		
		LogDTO dto = new LogDTO();
		dto.setUrl(req.getRequestURI());
		dto.setId(session.getAttribute("id") != null 
						? session.getAttribute("id").toString() : "anony");
		
		dao.add(dto);		
		
	}
	
	
}