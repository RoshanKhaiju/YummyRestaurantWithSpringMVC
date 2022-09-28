package com.yummyrestaurant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yummyrestaurant.model.BookTable;
import com.yummyrestaurant.service.BookTableService;

@Controller
public class BookTableController {

	@Autowired
	private BookTableService service;

	@GetMapping("/bookTable")
	public String bookTablePage(HttpSession session) {

		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}

		return "bookTable";
	}

	@PostMapping("/bookTable")
	public String bookTable(@ModelAttribute BookTable bookTable) {
		service.addBookTable(bookTable);
		return "bookTable";
	}

	@GetMapping("/bookedTableList")
	public String bookedTableList(Model model, HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		model.addAttribute("bookedTableList", service.getAllBookedTable());
		return "bookedTableList";
	}

	@GetMapping("/deleteBookedTable/{id}")
	public String deleteBookedTable(@PathVariable("id") Long bookedTableId, HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		service.deleteBookedTable(bookedTableId);
		return "redirect:/bookedTableList";
	}

}
