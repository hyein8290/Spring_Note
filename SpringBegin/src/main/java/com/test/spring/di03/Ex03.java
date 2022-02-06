package com.test.spring.di03;

public class Ex03 {
	
	public static void main(String[] args) {
		
		//Ex03.java
		//AAA -> (의존) -> BBB -> (의존) -> CCC -> (의존) -> DDD
		
		AAA a = new AAA();
		a.run();
		
		
		
	}

}
