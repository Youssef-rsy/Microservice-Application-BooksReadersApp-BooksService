package com.local.ysf.BookService.Infrastricture;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.Infrastructure.BookRepository;


/**
 * @author Asus Gamer
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.DEFAULT)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookServiceRepositoryMockTest { // testing repository layer with @datajpatest and embded DB (H2)

	
	@Autowired
	private  BookRepository repository;
	
	
	@Before
	public  void dataSeedForTest(){
		
		Faker faker = new Faker();
		for (int i = 0; i < 5; i++) {
			Book book = new Book(faker.book().title(), faker.book().author(), faker.gameOfThrones().quote(),faker.number().randomDigit());
			repository.save(book);
		}
	}
	
	@Test
	public  void a() {
		List<Book> lst = repository.findAll();
		assertEquals(lst.size(), 5);
	}
	
	@Test
	public void addBookTestAnd(){
		Book book = new Book("@datajpatest", "Youssef ROSSAMY", "Testing the repository layer with @datajpatest and H2 embded DB ",126);
		Book savedBook = repository.save(book);
		assertNotNull(savedBook );
		assertEquals(savedBook.getAuthor(),"Youssef ROSSAMY" );
		Optional<Book> returnedBook = repository.findByTitle("@datajpatest");
		returnedBook.orElse(null);
		book = returnedBook.get();
		assertNotNull(book);
		assertEquals(book.getTitle(),"@datajpatest");
	}
	

}
