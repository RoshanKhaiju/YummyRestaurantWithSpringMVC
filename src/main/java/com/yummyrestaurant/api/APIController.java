package com.yummyrestaurant.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class APIController {
	
	@GetMapping("/restapi")
	public String getApi() {
		return "restAPIForm";
	}

}
