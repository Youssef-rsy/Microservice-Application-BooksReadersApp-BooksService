package com.local.ysf.BookService.service.dataSeed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.Infrastructure.BookRepository;
import com.local.ysf.BookService.service.BookService;

//@Component
/**
 * @author Youssef ROSSAMY
 *
 */
public class dataSeed {

	@Autowired
	private BookService bookService;
	
	
	@PostConstruct
	public void addSomeDataToDB(){
		Faker faker = new Faker();
		for (int i = 0; i < 20; i++) {
			Book book = new Book(faker.book().title(), faker.book().author(), faker.gameOfThrones().quote(),faker.number().randomDigit());
			bookService.saveBook(book);;
		}
	}
}
