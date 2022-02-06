package com.test.spring.di01;

import java.util.Random;

public class Hong {

	public void run() {
		
		
		//Main 객체 -> Hong 객체 -> Pen 객체
		
		//Pen 객체는 Hong 객체의 의존 객체이다.
		//Hong 객체는 Pen 객체를 의존한다.
		
		
		//그림을 그리다.
		Pen pen = new Pen(); //의존 객체, Dependency Object
		pen.draw();
		
//		Random rnd = new Random(); //rnd는 Hong의 의존객체이다.
//		System.out.println(rnd.nextInt());
		
	}
	
}


