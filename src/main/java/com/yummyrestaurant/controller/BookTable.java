package com.yummyrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookTable {

	@GetMapping("/book-a-table")
	public String bookTablePage() {
		return "bookTable";
	}

}
