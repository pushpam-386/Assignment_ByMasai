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
	public List<Book> getAllBookDetails() {
		List<Book> list=bookDao.findAll();
		return list;
	}

	@Override
	public Book bookByBookId(Integer bookId) throws BookException {
		Optional<Book> bOptional=bookDao.findById(bookId);
		if (bOptional.isEmpty()) {
			throw new BookException("No such book found");
		}
		
		  return bOptional.get();
	}

	@Override
	public Book saveBookDetail(Book book) throws BookException {
		Optional<Book> bOptional=bookDao.findById(book.getBookId());
		if (bOptional.isPresent()) {
			throw new BookException("This book is already there");
		}
		return bookDao.save(book);
	}
	
	@Override
	public Book deleteBookDetail(Integer bookId) throws BookException {
		Optional<Book> bOptional=bookDao.findById(bookId);
		if (bOptional.isEmpty()) {
			throw new BookException("No such book found to delete");
		}
		
		  bookDao.delete(bOptional.get());
		  return bOptional.get();
	}

	@Override
	public Book updateBookDetails(Book cBook, Integer bookId) throws BookException {
		Optional<Book> bOptional=bookDao.findById(bookId);
		if (bOptional.isEmpty()) {
			throw new BookException("No such book is there to update the details");
		}
		else {
			bOptional.get().setCategory(cBook.getCategory());
			bOptional.get().setPublication(cBook.getPublication());
		}
		return bOptional.get();
	}

}
