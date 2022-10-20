package com.push.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.BookException;
import com.push.models.Book;
import com.push.repository.BookDao;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getAllBooks() throws BookException {
		List<Book> books=bookDao.findAll();
		if (books.isEmpty()) {
			throw new BookException("No Book Found to be displayed ");
		}
			return books;
	}

	@Override
	public Book getBookById(int bookId) throws BookException {
		Optional<Book> bOptional=bookDao.findById(bookId);
		if (bOptional.isEmpty()) {
			throw new BookException("No such book by this id is present ");
		}
		return bOptional.get();
	}

	@Override
	public Book createNewBook(Book book) throws BookException {
		if (book==null) {
			throw new BookException("No Data of book is there to save ");
		}
		bookDao.save(book);
		return book;
	}

	@Override
	public Book deleteBookById(int bookId) throws BookException {
		Optional<Book> bOptional=bookDao.findById(bookId);
		if (bOptional.isEmpty()) {
			throw new BookException("No such book by this id is present to delete ");
		}
		bookDao.delete(bOptional.get());
		return bOptional.get();
	}

	@Override
	public Book updateBookById(int bookId, Book book) throws BookException {
		Optional<Book> bOptional=bookDao.findById(bookId);
		if (bOptional.isEmpty()) {
			throw new BookException("No such book by this id is present to update ");
		}
		bOptional.get().setCategory(book.getCategory());
		bOptional.get().setAuthor(book.getAuthor());
		bOptional.get().setName(book.getName());
		bOptional.get().setPages(book.getPages());
		bOptional.get().setPublication(book.getPublication());
		
		bookDao.save(bOptional.get());
		return bOptional.get();
	}
	

}
