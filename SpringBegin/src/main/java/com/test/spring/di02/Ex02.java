package com.test.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02 {
	
	public static void main(String[] args) {
		
		//Ex02.java
		
		//직접 DI 구현 > Spring DI 구현
		
		//직접 DI 구현
//		Pen pen = new Pen();
//		Hong hong = new Hong(pen); //의존 주입(DI)
//		hong.run();
		
		//Spring DI 구현
		
		//XML 설정을 읽기
		//ApplicationContext context = new ClassPathXmlApplicationContext("di02.xml");
		
		//스프링 프레임워크를 사용해서 객체 생성하기!!!
		//<bean id="pen" name="dd ee" class="com.test.spring.di02.Pen"></bean>
		//Pen pen2 = (Pen)context.getBean("pen"); //new Pen() 실행 후 객체 반환
		//pen2.draw();
		
		//<bean id="hong" name="aa bb cc" class="com.test.spring.di02.Hong"></bean>
		//Hong hong2 = (Hong)context.getBean("hong"); //new Hong()
		//hong2.setPen(pen2); //의존 주입
		//hong2.run();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di02.xml");
		
		Hong hong3 = (Hong)context.getBean("hong");
		hong3.run();
		
		
	}

}













