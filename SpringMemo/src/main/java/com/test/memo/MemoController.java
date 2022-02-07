package com.test.memo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {

	@RequestMapping(value="/list.do", method= {RequestMethod.GET})
	public String list(HttpServletRequest req) {
		
		IMemoService service = new MemoService();
		
		List<MemoDTO> list = service.list();
		
		req.setAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping(value="/add.do", method= {RequestMethod.GET})
	public String add() {
		
		return "add";
	}
	
	@RequestMapping(value="/addok.do", method= {RequestMethod.POST})
	public void addok() {
		
	}
	
	@RequestMapping(value="/edit.do", method= {RequestMethod.GET})
	public String edit() {
		
		return "edit";
	}
	
	@RequestMapping(value="/editok.do", method= {RequestMethod.POST})
	public void editok() {
		
	}
	
	@RequestMapping(value="/delok.do", method= {RequestMethod.POST})
	public void delok() {
		
	}
}
