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
import com.yummyrestaurant.model.Menu;
import com.yummyrestaurant.service.MenuService;

@RestController
@RequestMapping("/menu/api")
public class MenuRestAPI {

	@Autowired
	private MenuService service;

	@GetMapping("/list")
	public List<Menu> getAll() {
		return service.getAllMenu();
	}

	@PostMapping("/add")
	public String add(@RequestBody Menu menu) {
		service.addMenu(menu);
		return "added success";
	}

	@PutMapping("/update")
	public String update(@RequestBody Menu menu) {
		service.updateMenu(menu);
		return "update success";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteMenu(id);
		return "delete success";
	}

	@GetMapping("/{id}")
	public Menu getOne(@PathVariable Long id) {
		return service.getMenuById(id);
	}

	@GetMapping("/json2obj")
	public String jsonToObject() {
		RestTemplate tmp = new RestTemplate();
		Menu menu = tmp.getForObject("http://localhost:8080/menu/api/8", Menu.class);
		return menu.getName();
	}

	@GetMapping("/json2Array")
	public String jsonArratToObject() {
		RestTemplate tmp = new RestTemplate();
		Menu[] menu = tmp.getForObject("http://localhost:8080/menu/api/list", Menu[].class);
		return "name : " + menu[0].getName();
	}

}
