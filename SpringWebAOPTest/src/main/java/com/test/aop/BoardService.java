package com.test.aop;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

	
	//주업무 - 글쓰기
	public int add(String id, int count) {

		//dao.add()
		
		System.out.println("게시판 글쓰기");
		
		return 0;
	}

}
