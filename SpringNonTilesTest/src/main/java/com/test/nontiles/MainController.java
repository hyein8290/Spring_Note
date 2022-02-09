package com.test.nontiles;

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

		return "main";
	}
	
	@RequestMapping(value = "/member/info.do", method = { RequestMethod.GET })
	public String info(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "member/info";
	}
	
	@RequestMapping(value = "/member/log.do", method = { RequestMethod.GET })
	public String log(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "member/log";
	}
	
	@RequestMapping(value = "/admin/chart.do", method = { RequestMethod.GET })
	public String chart(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "admin/chart";
	}
	
	@RequestMapping(value = "/admin/point.do", method = { RequestMethod.GET })
	public String point(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "admin/point";
	}
	
	
}
