package com.local.ysf.BookService.service;

import java.util.List;
import java.util.UUID;

import com.local.ysf.BookService.Entity.Book;


/**
 * @author Youssef ROSSAMY
 *
 */
public interface BookService {

	public void saveBook(Book book);
	public Book getBook(UUID bookId);
	public List<Book> findAllBook();
	public Book updateBook(UUID bookId , Book book);
	public void deleteBook(UUID bookId);
	public Book findBookByTitle(String title);
	public List<Book> findBookByAuthor(String author);
	
	
}
