package com.demo.bookapi.daoimpl.dao;

import java.util.List;

import com.demo.bookapi.model.Book;

public interface BookDao {

	//save the record
	long save(Book book);
	
	//get a single record
	Book get(long id);
	
	//get all records
	List<Book> get();
	
	// update the record
	void update(Book  book);
	
	//delete the record
	void delete(long id);
	
}
