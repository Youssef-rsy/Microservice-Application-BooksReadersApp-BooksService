package com.local.ysf.BookService.service.Stub;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.common.util.impl.LoggerFactory;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.service.BookService;

/**
 * @author Youssef ROSSSAMY
 *
 */
public class BookServiceStub implements BookService {

	Faker faker = new Faker();
	private  static org.jboss.logging.Logger log =  LoggerFactory.logger(BookServiceStub.class);
	
	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		log.info("book save succesfly");
	}

	@Override
	public Book getBook(UUID bookId) {
		return new Book(bookId,faker.book().title(), "Youssef ROSSAMY", faker.book().toString(), faker.number().randomDigit());
	}

	
	@Override
	public List<Book> findAllBook() {
		log.info("begin request ::::::::::: findAllBook ");
		List<Book> lst = new ArrayList<>();
		for(int i = 0 ; i<11;i++)
			lst.add(new Book(UUID.randomUUID(),faker.book().title(), faker.book().author(), faker.book().toString(), faker.number().randomDigit()));
		log.info("end request ::::::::::: findAllBook successfuly ");
		return lst;
	}

	@Override
	public Book updateBook(UUID bookId, Book book) {
		log.info("starting request ::::::::::: findAllBook ");
		return new Book(bookId,faker.book().title(), faker.book().author(), faker.book().toString(), faker.number().randomDigit());
		
	}

	@Override
	public void deleteBook(UUID bookId) {
		log.info(bookId+"deleted succesfly");

	}

	@Override
	public Book findBookByTitle(String title) {
		return new Book(UUID.randomUUID(),title, faker.book().author(), faker.book().toString(), faker.number().randomDigit());
	}

	@Override
	public List<Book> findBookByAuthor(String author) {
		List<Book> lst = new ArrayList<>();
		for(int i = 0 ; i<3;i++)
			lst.add(new Book(UUID.randomUUID(),faker.book().title(),author ,faker.book().toString(), faker.number().randomDigit()));
		return lst;
	}

}
