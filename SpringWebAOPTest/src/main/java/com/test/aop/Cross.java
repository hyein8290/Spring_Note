package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무 객체
@Aspect //자격
@Component //의존 주입 객체 자격
public class Cross {

	//주업무 지정 > 포인트 컷 지정
	@Pointcut("execution(public int com.test.aop.BoardService.add(String, int))")
	public void pc1() {	} //구현x
	
	//보조업무 선언 + 주업무 결합
	//@After("pc1()")
	public void m1(JoinPoint joinPoint) { //프록시 > 주업무 참조 객체
		
		System.out.println("보조 업무를 실행합니다.");
		
		Object[] args = joinPoint.getArgs();
		
		for(Object o : args) {
			System.out.println(o);
		}
	}
	
	
}
