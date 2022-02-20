package com.test.aop;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	//주업무 지정 > 모든 요청 메소드(모든 페이지 주소)
	@Pointcut("execution(public String AOPController.*(..))")
	public void pc1() {}
	
	
	//보조업무 > 로그 > 어떤 사용자?(IP, id) 언제? 어떤 페이지 접속?
	@After("pc1()")
	public void log(JoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest req = (HttpServletRequest)args[0];
		HttpSession session = (HttpSession)args[2];
		
		Calendar now = Calendar.getInstance();
		System.out.printf("[log %tF %tT] '%s' 유저가 '%s' 페이지를 방문했습니다.\n\n"
								, now, now
								, session.getAttribute("id")
								, req.getRequestURL());
	}
	
}
