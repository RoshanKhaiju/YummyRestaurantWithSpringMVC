package com.yummyrestaurant.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yummyrestaurant.model.Chef;
import com.yummyrestaurant.service.ChefService;

@RestController
@RequestMapping("/chef/api")
public class ChefRestAPI {

	@Autowired
	private ChefService service;

	@GetMapping("/list")
	public List<Chef> getAll() {
		return service.getAllChefs();
	}

	@PostMapping("/add")
	public String add(@RequestBody Chef chef) {
		service.addChef(chef);
		return "added success";
	}

	@PutMapping("/update")
	public String update(@RequestBody Chef chef) {
		service.updateChef(chef);
		return "update success";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteChef(id);
		return "delete success";
	}

	@GetMapping("/{id}")
	public Chef getOne(@PathVariable Long id) {
		return service.getChefById(id);
	}

	@GetMapping("/json2obj")
	public String jsonToObject() {
		RestTemplate tmp = new RestTemplate();
		Chef chef = tmp.getForObject("http://localhost:8080/chef/api/8", Chef.class);
		return chef.getFirstName() + " " + chef.getLastName();
	}
	
	@GetMapping("/json2Array")
	public String jsonArratToObject() {
		RestTemplate tmp = new RestTemplate();
		Chef[] chef = tmp.getForObject("http://localhost:8080/chef/api/list", Chef[].class);
		return "first name : " + chef[0].getFirstName();
	}

}
