package com.test.spring.aop;

public interface IMemo {
	
	//1. 주업무 > 메모쓰기
	void auth_add(String memo); 
	
	//3. 주업무 > 메모수정
	void auth_edit(int seq, String memo);
	
	//4. 주업무 > 메모삭제
	void auth_del(int seq);

	//2. 주업무 > 메모읽기
	void read(int seq) throws Exception;
	
	//5. 주업무 > 메모검색
	int search(String word);
	
}







