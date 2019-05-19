package com.local.ysf.BookService.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.Infrastructure.BookRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author Youssef ROSSAMY
 *
 */
@Transactional
@Service
public class BookServiceImplementation implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@HystrixCommand(fallbackMethod="generalFallback")
	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	
	@Override
	public Book getBook(UUID bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if(optionalBook.isPresent())
			return optionalBook.get();
		return null;
	}

	@Override
	public List<Book> findAllBook() {
		List<Book> listOfBook = bookRepository.findAll();
		return listOfBook;
	}

	@Override
	public Book updateBook(UUID bookId, Book book) {
		Book getbook = getBook(bookId);
		getbook.setAuthor(book.getAuthor());
		getbook.setDescription(book.getDescription());
		getbook.setNumberOfPage(book.getNumberOfPage());
		getbook.setTitle(book.getTitle());
		return getbook;
	}

	@Override
	public void deleteBook(UUID bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book findBookByTitle(String title) {
		Optional<Book> optionalBook = bookRepository.findByTitle(title);
		if(optionalBook.isPresent())
			return optionalBook.get();
		return null;
	}

	@Override
	public List<Book> findBookByAuthor(String author) {
		List<Book> listOfBook = bookRepository.findByAuthor(author);
		return listOfBook;
	}

	public String generalFallback(){
		return "please try again or contact us for additional information  on +212... ";
	}
}
