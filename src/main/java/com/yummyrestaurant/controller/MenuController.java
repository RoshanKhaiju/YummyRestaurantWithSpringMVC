package com.yummyrestaurant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yummyrestaurant.model.Chef;
import com.yummyrestaurant.model.Menu;
import com.yummyrestaurant.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService service;

	@GetMapping("/menu")
	public String menuPage(HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		return "menu";
	}

	@GetMapping("/addMenu")
	public String addMenu(HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		return "addMenu";
	}

	@PostMapping("/addMenu")
	public String saveMenuData(@ModelAttribute Menu menu) {
		service.addMenu(menu);
		return "addMenu";
	}

	@GetMapping("/menuList")
	public String menuList(Model model, HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		model.addAttribute("listMenu", service.getAllMenu());
		return "menuList";
	}

	@GetMapping("/deleteMenu/{id}")
	public String deleteMenu(@PathVariable("id") Long menuid,HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		service.deleteMenu(menuid);
		return "redirect:/menuList";
	}

	@GetMapping("/editMenu")
	public String editMenu(@RequestParam Long id, Model model, HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		model.addAttribute("editModel", service.getMenuById(id));
		return "editMenu";
	}

	@PostMapping("/updateMenu")
	public String updateMenu(@ModelAttribute Menu menu) {
		service.updateMenu(menu);
		return "redirect:/menuList";
	}

}
