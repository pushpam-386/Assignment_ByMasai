package com.push.service;

import java.util.List;

import com.push.exception.BookException;
import com.push.models.Book;

public interface BookService {
	public List<Book> getAllBooks()throws BookException;
	public Book getBookById(int bookId)throws BookException;
	public Book createNewBook(Book book)throws BookException;
	public Book deleteBookById(int bookId)throws BookException;
	public Book updateBookById(int id, Book book)throws BookException;
}
