package com.yummyrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyrestaurant.model.Chef;

public interface ChefRepository extends JpaRepository<Chef, Long> {

}
