package com.yummyrestaurant.service;

import java.util.List;

import com.yummyrestaurant.model.Menu;

public interface MenuService {
	
	void addMenu(Menu menu);
	
	void deleteMenu(Long id);
	
	void updateMenu(Menu menu);
	
	Menu getMenuById(Long id);
	
	List<Menu> getAllMenu();

}
