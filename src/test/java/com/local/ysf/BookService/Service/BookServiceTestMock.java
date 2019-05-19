package com.local.ysf.BookService.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.Infrastructure.BookRepository;
import com.local.ysf.BookService.service.BookServiceImplementation;
/**
 * @author Youssef ROSSAMY
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTestMock {

	@Mock
	private BookRepository bookService;
	
	@InjectMocks
	private BookServiceImplementation bookServiceImpl;
	
	private Faker faker = new Faker();
	
	public List<Book> listOfBook(){
		List< Book> lst = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lst.add(new Book(UUID.randomUUID(), faker.book().title(), faker.book().author(), faker.book().publisher(), faker.number().randomDigitNotZero()));
		}
		return lst;
	}
	
	@Test
	public void testGetBookMethod() {
		bookServiceImpl =  mock(BookServiceImplementation.class);
		UUID uuid = UUID.randomUUID();
		Book mockedBook = new Book(uuid, faker.book().title(), faker.book().author(), faker.book().publisher(), faker.number().randomDigitNotZero());
		
		when(bookServiceImpl.getBook(uuid)).thenReturn(mockedBook);
		Book book = bookServiceImpl.getBook(uuid);
		
		verify(bookServiceImpl,atLeast(1)).getBook(uuid);
		assertEquals(book, mockedBook);
	}
	
	@Test
	public void testFindAllBookMethod() {
		when(bookService.findAll()).thenReturn(listOfBook());
		List books = bookServiceImpl.findAllBook();
		books.remove(0);
		assertNotNull(books);
		verify(bookService,atLeast(1)).findAll();
		assertEquals(books.size(), 4);
	}
	
	
}
