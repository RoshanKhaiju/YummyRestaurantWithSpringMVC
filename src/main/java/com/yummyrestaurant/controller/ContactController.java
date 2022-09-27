package com.yummyrestaurant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/contact")
	public String contactPage(HttpSession session) {
		if (session.getAttribute("activeUser") == null) {
			return "redirect:/";
		}
		return "contact";
	}

	@PostMapping("/contact")
	public String sendMessage(@RequestParam String name,@RequestParam String email, @RequestParam String subject, @RequestParam String message, Model model) {
		
		sendEmail(name, email, subject, message);
		model.addAttribute("message", "message sent successfully");
		
		return "contact";
	}
	
	private void sendEmail(String name, String fromEmail, String subject, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(fromEmail);
		msg.setSubject(subject);
		msg.setText(message);
		
		javaMailSender.send(msg);
	}

}
