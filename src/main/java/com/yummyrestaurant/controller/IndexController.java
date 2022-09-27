package com.yummyrestaurant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {

	@GetMapping("/")
	public String startPage(HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/login";
		}
		return "index";
	}

}
