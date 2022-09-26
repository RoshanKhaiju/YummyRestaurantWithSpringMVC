package com.yummyrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yummyrestaurant.model.User;
import com.yummyrestaurant.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String loginForm(@ModelAttribute User u, Model model, RedirectAttributes attribute) {

		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		User user = userRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());

		if (user != null) {
			attribute.addFlashAttribute("username", u.getUsername());
			return "redirect:/";
		}

		model.addAttribute("message", "user not found!");
		return "login";
	}

}
