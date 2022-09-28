package com.yummyrestaurant.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yummyrestaurant.model.User;
import com.yummyrestaurant.repository.UserRepository;
import com.yummyrestaurant.utils.VerifyRecaptcha;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String loginForm(@ModelAttribute User u, Model model, RedirectAttributes attribute, HttpSession session,
			@RequestParam("g-recaptcha-response") String gCode) throws IOException {

		if (VerifyRecaptcha.verify(gCode)) {

			u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
			User user = userRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());

			if (user != null) {

				log.info("login success");

				session.setAttribute("activeUser", user);
				session.setMaxInactiveInterval(300);

//			attribute.addFlashAttribute("username", u.getUsername());
				return "redirect:/";
			} else {
				log.info("login failed");
				model.addAttribute("message", "user not found!");
				return "login";
			}
		}

		log.info("login failed");
		model.addAttribute("message", "wrong recaptcha code");
		return "login";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		log.info("logout success");
		return "redirect:/";
	}

}
