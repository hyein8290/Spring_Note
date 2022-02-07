package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//MVC > Controller 역핳
@Controller // 클라이언트의 요청을 받아 처리할 수 있는 자격을 가진 알바생이 된다.
public class Ex03Controller {

	//클라이언트가 이 컨트롤러에게 요청을 하려면?
	//1. 요청 메소드 > doGet()/doPost()
	//2. 가상 주소 > "/spring/ex03.do"
	
	//클라이언트의 요청을 받아 처리할 수 있는 자격을 가진 알바생의 요청 메소드가 된다.
	@RequestMapping(value="/ex03.do", method={RequestMethod.GET})
	public String call() {
		
		//페이지 처리 > 비즈니스 코드
		
		//뷰 호출 > ViewResolver 사용(JSP 페이지의 경로를 단축)
		return "ex03"; //RequestDispatcher + forward()
	}
	
	//GET or POST
	@RequestMapping(value="/ex03ok.do", method={RequestMethod.POST})
	public String callok(
						 
						 HttpServletRequest req, 
						 //String name,
						 //String age,
						 //String address
						 DTO dto,
						 String color
						 
						 ) {
		
		//데이터 가져오기 
		//1. 기존 방식 > 사용 안 함
//		String name = req.getParameter("name");
//		String age = req.getParameter("age");
//		String address = req.getParameter("address");
//		
//		DTO dto = new DTO();
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
		
		
		//2. 요청 메소드의 매개변수 사용		
//		DTO dto = new DTO();
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
	
		
		//3. 요청 메소드의 매개변수 사용 DTO
		
		//dao.add(dto);
		System.out.println(dto);
		System.out.println(color);
		
		return "ex03ok";
	}
}
