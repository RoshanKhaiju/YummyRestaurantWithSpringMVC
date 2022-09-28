package com.yummyrestaurant.service;

import java.util.List;

import com.yummyrestaurant.model.BookTable;

public interface BookTableService {

	void addBookTable(BookTable bookTable);

	void deleteBookedTable(Long id);

	BookTable getBookedTableById(Long id);

	List<BookTable> getAllBookedTable();

}
