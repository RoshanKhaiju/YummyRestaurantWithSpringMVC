package com.yummyrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyrestaurant.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
