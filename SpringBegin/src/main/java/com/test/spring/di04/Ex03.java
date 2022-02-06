package com.test.spring.di04;

public class Ex03 {
	
	public static void main(String[] args) {
		
		//Ex03.java
		//AAA -> (의존) -> BBB -> (의존) -> CCC -> (의존) -> DDD
		
		//DI 구현
		DDD d = new DDD();
		CCC c = new CCC(d);
		BBB b = new BBB(c);
		
		//Ex03이 필요로 하는 객체는 오직 AAA이다.
		//Ex03에게는 불필요한 나머지 B,C,D까지 같이 생성해서 의존 주입을 구현해야 한다.
		AAA a = new AAA(b);
		a.run();
		
	}

}
