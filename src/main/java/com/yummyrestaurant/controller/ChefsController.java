package com.yummyrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long chefid) {
		service.deleteChef(chefid);
		return "redirect:/chefList";
	}

	@GetMapping("/editChef")
	public String editChef(@RequestParam Long id, Model model) {
		model.addAttribute("editModel", service.getChefById(id));
		return "editChef";
	}

	@PostMapping("/updateChef")
	public String updateChef(@ModelAttribute Chef chef) {
		service.updateChef(chef);
		return "redirect:/chefList";
	}

}
