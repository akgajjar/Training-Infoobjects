package com.demo.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookapi.model.Book;
import com.demo.bookapi.model.HttpResponse;
import com.demo.bookapi.serviceimpl.service.BookService;


@CrossOrigin("*")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	//get all the books
	@GetMapping("/api/books")
	public ResponseEntity<List<Book>> list(){
		List<Book> books = bookService.get();
		return ResponseEntity.ok().body(books); 
	}
	
	
	//save a book
	@PostMapping(value = "/api/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponse> save(@RequestBody Book book){
			long id = bookService.save(book);
			HttpResponse response = new HttpResponse();
			response.setResponseMessage("Book Created with id "+ id);
			return ResponseEntity.ok().body(response);
	}
	
	//get a single record
	@GetMapping("/api/book/{id}")
	public ResponseEntity<Book> get(@PathVariable long id){
		Book book = bookService.get(id);
		return ResponseEntity.ok(book);
	}
	
	//update a record
	@PutMapping(value = "/api/book/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponse> update(@PathVariable long id, @RequestBody Book book){
		book.setId(id);
		bookService.update(book);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("Book Updated with id "+ id);
		return ResponseEntity.ok().body(response);
	}
	
	//delete a record
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<HttpResponse> delete(@PathVariable long id){
		bookService.delete(id);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("Book Deleted with id "+ id);
		return ResponseEntity.ok().body(response);
	}
}
