package com.yummyrestaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummyrestaurant.model.Menu;
import com.yummyrestaurant.repository.MenuRepository;
import com.yummyrestaurant.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepo;

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuRepo.save(menu);
		
	}

	@Override
	public void deleteMenu(Long id) {
		// TODO Auto-generated method stub
		menuRepo.deleteById(id);
		
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuRepo.save(menu);
		
	}

	@Override
	public Menu getMenuById(Long id) {
		// TODO Auto-generated method stub
		return menuRepo.getById(id);
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuRepo.findAll();
	}
	
	

}
