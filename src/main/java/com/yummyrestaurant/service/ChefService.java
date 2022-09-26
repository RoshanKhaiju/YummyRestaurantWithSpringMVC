package com.yummyrestaurant.service;

import java.util.List;

import com.yummyrestaurant.model.Chef;

public interface ChefService {
	
	void addChef(Chef chef);
	
	void deleteChef(Long id);
	
	void updateChef(Chef chef);
	
	Chef getChefById(Long id);
	
	List<Chef> getAllChefs();

}
