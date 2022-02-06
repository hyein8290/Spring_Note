package com.test.spring.di05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex03 {
	
	public static void main(String[] args) {
		
		//Ex03.java
		//AAA -> (의존) -> BBB -> (의존) -> CCC -> (의존) -> DDD
		
		//Ex03이 필요로 하는 객체는 오직 AAA이다.
		//Ex03에게는 불필요한 나머지 B,C,D까지 같이 생성해서 의존 주입을 구현해야 한다.
		
		//XML에서 설정한 의존 주입 관계를 적용하려면 스프링 DI를 사용해서 객체를 생성해야 한다.
		ApplicationContext context = new ClassPathXmlApplicationContext("di03.xml");
		
		AAA a = (AAA)context.getBean("a");
		a.run();
		
		
	}

}











