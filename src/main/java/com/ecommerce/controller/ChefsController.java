package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChefsController {

	@GetMapping("/chefs")
	public String chefsPage() {
		return "chefs";
	}

}
