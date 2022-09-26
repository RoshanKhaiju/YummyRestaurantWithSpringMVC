package com.yummyrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/menu")
	public String menuPage() {
		return "menu";
	}

	@GetMapping("/addMenu")
	public String addMenu() {
		return "addMenu";
	}

}
