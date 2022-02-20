package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxController {

	@GetMapping("/")
	public String index() {
		
		return "index";
	}
}
