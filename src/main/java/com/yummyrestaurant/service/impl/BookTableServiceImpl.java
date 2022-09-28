package com.yummyrestaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummyrestaurant.model.BookTable;
import com.yummyrestaurant.repository.BookTableRepository;
import com.yummyrestaurant.service.BookTableService;

@Service
public class BookTableServiceImpl implements BookTableService {

	@Autowired
	private BookTableRepository bookTableRepo;

	@Override
	public void addBookTable(BookTable bookTable) {
		// TODO Auto-generated method stub
		bookTableRepo.save(bookTable);

	}

	@Override
	public void deleteBookedTable(Long id) {
		// TODO Auto-generated method stub
		bookTableRepo.deleteById(id);

	}

	@Override
	public BookTable getBookedTableById(Long id) {
		// TODO Auto-generated method stub
		return bookTableRepo.getById(id);
	}

	@Override
	public List<BookTable> getAllBookedTable() {
		// TODO Auto-generated method stub
		return bookTableRepo.findAll();
	}

}
