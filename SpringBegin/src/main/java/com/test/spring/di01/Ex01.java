package com.test.spring.di01;

public class Ex01 {

	public static void main(String[] args) {
		
		Hong hong = new Hong();
		hong.run();
		
		
		Pen pen = new Pen();
		//pen.draw(); X
		
		//Lee의 의존 객체인 pen을 Lee에게 사용할 수 있도록 전달!!
		//1. 생성자 사용
		//2. setter 사용
		Lee lee = new Lee(pen); //의존 주입(Dependency Injection)
		lee.run();
		
	}
	
}
