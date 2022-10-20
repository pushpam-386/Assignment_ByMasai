package com.push.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.push.exception.BookException;
import com.push.models.Book;
import com.push.service.BookService;

@RestController
@RequestMapping("/bookservice")
public class UserController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookDetails() throws BookException{
		List<Book> allBooks= bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
	}
	
	@GetMapping("books/{id}")
	public ResponseEntity<Book> getBookByid(@PathVariable Integer id) throws BookException{
		Book book = bookService.getBookById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PostMapping("books")
	public ResponseEntity<Book> createNewBook(@RequestBody Book book) throws BookException{
		Book book2 = bookService.createNewBook(book);
		return new ResponseEntity<Book>(book2, HttpStatus.CREATED);	
	}

	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable int id) throws BookException{
		Book book = bookService.deleteBookById(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateCustomerById(@PathVariable int id, @RequestBody Book book) throws BookException {
		Book book2 = bookService.updateBookById(id,book);
		return new ResponseEntity<Book>(book2,HttpStatus.OK);
	
	}


}
