package com.test.spring;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String seq;
	private String id;
	private String name; //***
	private String subject;
	private String content;
	private String regdate;
	private String orgfilename;
	private String filename;

}
