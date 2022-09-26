package com.yummyrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {

	@GetMapping("/")
	public String startPage() {
		return "login";
	}
	
	@GetMapping("/home")
	public String indexPage() {
		return "index";
	}

}
