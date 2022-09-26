package com.yummyrestaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummyrestaurant.model.Chef;
import com.yummyrestaurant.repository.ChefRepository;
import com.yummyrestaurant.service.ChefService;

@Service
public class ChefServiceImpl implements ChefService {

	@Autowired
	private ChefRepository chefRepo;

	@Override
	public void addChef(Chef chef) {
		// TODO Auto-generated method stub

		chefRepo.save(chef);

	}

	@Override
	public void deleteChef(Long id) {
		// TODO Auto-generated method stub

		chefRepo.deleteById(id);

	}

	@Override
	public void updateChef(Chef chef) {
		// TODO Auto-generated method stub
		
		chefRepo.save(chef);
		
	}

	@Override
	public Chef getChefById(Long id) {
		// TODO Auto-generated method stub
		return chefRepo.getById(id);
	}

	@Override
	public List<Chef> getAllChefs() {
		// TODO Auto-generated method stub
		return chefRepo.findAll();
	}

}
