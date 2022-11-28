package com.push.service;

import java.util.List;

import com.push.exception.BookException;
import com.push.models.Book;

public interface BookService {
	public List<Book> getAllBookDetails();
	public Book bookByBookId(Integer bookId)throws BookException;
	public Book saveBookDetail(Book book)throws BookException;
	public Book deleteBookDetail(Integer bookId)throws BookException;
	public Book updateBookDetails(Book cBook, Integer bookId)throws BookException;
	

}
