package com.push.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.push.exception.BookException;
import com.push.models.Book;
import com.push.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController("/bookservice")
public class UserController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookDetails() throws BookException{
		List<Book> lBooks=bookService.getAllBookDetails();
		return new ResponseEntity<List<Book>>(lBooks, HttpStatus.CONFLICT);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getFeedbacks(@PathVariable Integer id) throws BookException{
		Book book = bookService.bookByBookId(id);
		return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> saveBookdetail(@RequestBody Book books) throws BookException{
		Book book2 = bookService.saveBookDetail(books);
		return new ResponseEntity<Book>(book2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBookdetail(@PathVariable Integer id) throws BookException{
		Book book2 = bookService.deleteBookDetail(id);
		return new ResponseEntity<Book>(book2, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBookdetail(@RequestBody Book book, @PathVariable Integer id) throws BookException{
		Book book2 = bookService.saveBookDetail(book);
		return new ResponseEntity<Book>(book2, HttpStatus.NOT_FOUND);
	}
}
