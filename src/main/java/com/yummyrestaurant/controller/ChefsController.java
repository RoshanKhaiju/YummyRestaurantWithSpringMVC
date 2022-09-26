package com.yummyrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChefsController {

	@GetMapping("/chefs")
	public String chefsPage() {
		return "chefs";
	}
	
	@GetMapping("/addChef")
	public String addChief() {
		return "addChef";
	}
	
	@GetMapping("/chefList")
	public String chiefList() {
		return "chefList";
	}

}
