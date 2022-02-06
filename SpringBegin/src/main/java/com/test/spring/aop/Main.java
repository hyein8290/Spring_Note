package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//컨트롤러 역할(전체 업무의 흐름 제어)
		//메모 업무 > Memo 클래스 담당
		
		ApplicationContext context = new ClassPathXmlApplicationContext("memo.xml");
		
		//IMemo memo = new Memo(); //객체를 직접 생성하면 스프링의 설정 지원을 받지 못한다.
		
		IMemo memo = (IMemo)context.getBean("memo"); //AOP의 지원을 받는다.
		
		//메모 쓰기
		memo.auth_add("메모 테스트입니다.");
		
		//메모 읽기
		try {
			memo.read(5);
			memo.read(20);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		//메모 수정
		memo.auth_edit(5, "memo testing..");
		
		//메모 삭제
		memo.auth_del(5);
		
		
		//메모 검색
		int seq = memo.search("길동");
		System.out.printf("%d번 메모에서 검색됨\n", seq);
		
		seq = memo.search("메모");
		System.out.printf("%d번 메모에서 검색됨\n", seq);
		
		seq = memo.search("테스트");
		System.out.printf("%d번 메모에서 검색됨\n", seq);
		
		
	}
	
}
















