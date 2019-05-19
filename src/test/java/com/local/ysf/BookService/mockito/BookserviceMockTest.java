package com.local.ysf.BookService.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.service.BookService;


/**
 * @author Youssef ROSSAMY
 *
 */
public class BookserviceMockTest {

	//mocking is creating  objects that simulate the behavior of real objects 
	//unlike stubs , mocks can be dynamically created from code - at runtime
	//mock offer more fucntionality than stubbing.
	//you can verify method calls and a lot of other things 
	
	private Faker faker = new Faker();
	
	private BookService bookServiceMock;
	
	private Book randomBook(){
		return new Book(UUID.randomUUID(),faker.book().title(), faker.book().author(), faker.book().toString(), faker.number().randomDigit());
	}
	
	@Test
	public void testRetreiveAllbookdataMock() {
		bookServiceMock = mock(BookService.class);
		List<Book> lst = new ArrayList<>();
		for(int i = 0 ; i<11;i++)
			lst.add(randomBook());
		when(bookServiceMock.findAllBook()).thenReturn(lst);
		assertEquals(11 ,bookServiceMock.findAllBook().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void getBook_usingStub() {
		bookServiceMock = mock(BookService.class);
		Book book = new Book(UUID.randomUUID(),faker.book().title(),"Youssef ROSSAMY", faker.book().toString(), faker.number().randomDigit());
		when(bookServiceMock.getBook(UUID.randomUUID())).thenReturn(book).thenThrow(new RuntimeException("Throwing exception"));
		assertEquals(bookServiceMock.getBook(UUID.randomUUID()).getAuthor(),"Youssef ROSSAMY");
		assertNotEquals(bookServiceMock.getBook(UUID.randomUUID()), null);
	}

}
