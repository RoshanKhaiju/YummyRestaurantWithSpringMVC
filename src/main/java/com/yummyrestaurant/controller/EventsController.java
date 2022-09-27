package com.yummyrestaurant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventsController {

	@GetMapping("/events")
	public String eventsPage(HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		return "events";
	}

}
