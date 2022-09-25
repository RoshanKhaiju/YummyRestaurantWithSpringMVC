package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddChiefController {

	@GetMapping("/addChief")
	public String addChief() {
		return "addChief";
	}

}
