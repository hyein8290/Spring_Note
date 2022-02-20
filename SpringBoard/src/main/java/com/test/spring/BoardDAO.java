package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardDAO {

	int add(BoardDTO dto);

	List<BoardDTO> list();

	BoardDTO get(String seq);

	int edit(BoardDTO dto);

	int del(String seq);
	
	

}
