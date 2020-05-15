package com.demo.bookapi.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.bookapi.daoimpl.dao.BookDao;
import com.demo.bookapi.model.Book;

@Repository("bookDAO")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public long save(Book book) {
	
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	
	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	
	public List<Book> get() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	
	public void update(Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(book.getId());
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		session.flush();
	}

	
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

}
