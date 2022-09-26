package com.yummyrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyrestaurant.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String username, String password);

}
