package com.yummyrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yummyrestaurant.model.Chef;
import com.yummyrestaurant.service.ChefService;

@Controller
public class ChefsController {

	@Autowired
	private ChefService service;

	@GetMapping("/chefs")
	public String chefsPage() {
		return "chefs";
	}

	@GetMapping("/addChef")
	public String addChief() {
		return "addChef";
	}

	@PostMapping("/addChef")
	public String saveChefData(@ModelAttribute Chef chef) {

		service.addChef(chef);

		return "addChef";
	}

	@GetMapping("/chefList")
	public String chiefList(Model model) {
		
		model.addAttribute("listChef", service.getAllChefs());
		
		return "chefList";
	}

}
