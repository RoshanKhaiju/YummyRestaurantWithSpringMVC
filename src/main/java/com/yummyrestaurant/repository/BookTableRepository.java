package com.yummyrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyrestaurant.model.BookTable;

public interface BookTableRepository extends JpaRepository<BookTable, Long> {

}
