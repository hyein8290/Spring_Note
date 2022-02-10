package com.test.tiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	
	@RequestMapping(value = "/main.do", method = { RequestMethod.GET })
	public String main(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//return "main"; 역할
		// -> JSP 페이지의 경로 + 기존 ViewResolver = 완성

		//return "main"; 역할
		// -> tiles.xml의 <definition>을 검색하는 키워드
		
		//return "admin.template";
		
		//return "main";

		//3단으로 만들어야 해서 의미없는 단어 main을 덧붙여줌
		return "one.main.main";
	}
	
	
	@RequestMapping(value = "/sub.do", method = { RequestMethod.GET })
	public String sub(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		return "sub";
	}
	
	@RequestMapping(value = "/member/info.do", method = { RequestMethod.GET })
	public String info(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "two.member.info";
	}
	
	@RequestMapping(value = "/member/log.do", method = { RequestMethod.GET })
	public String log(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "two.member.log";
	}
	
	@RequestMapping(value = "/admin/chart.do", method = { RequestMethod.GET })
	public String chart(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "two.admin.chart";
	}
	
	@RequestMapping(value = "/admin/point.do", method = { RequestMethod.GET })
	public String point(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "two.admin.point";
	}
	
	
}
