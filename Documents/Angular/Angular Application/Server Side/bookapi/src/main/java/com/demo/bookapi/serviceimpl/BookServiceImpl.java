package com.demo.bookapi.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bookapi.daoimpl.dao.BookDao;
import com.demo.bookapi.model.Book;
import com.demo.bookapi.serviceimpl.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDAO;
	
	
	@Transactional
	public long save(Book book) {
		return bookDAO.save(book);
	}


	@Transactional
	public Book get(long id) {
		return bookDAO.get(id);
	}

	
	@Transactional
	public List<Book> get() {
		return bookDAO.get();
	}

	
	@Transactional
	public void update(Book book) {
		bookDAO.update(book);
	}

	
	@Transactional
	public void delete(long id) {
		bookDAO.delete(id);
	}

}
