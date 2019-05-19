package com.local.ysf.BookService.service.Stub;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.service.BookService;


/**
 * @author Youssef ROSSAMY
 *
 */
public class BookserviceStubTest {

	private BookService bookserviceStub;
	@Test
	public void testRetreiveAllbookdata_usingStub() {
		bookserviceStub = new BookServiceStub();
		assertEquals(11 ,bookserviceStub.findAllBook().size());
	}
	
	@Test
	public void getBook_usingStub() {
		bookserviceStub = new BookServiceStub();
		Book book = bookserviceStub.getBook(UUID.randomUUID());
		assertNotEquals(book, null);
		assertEquals(book.getAuthor(),"Youssef ROSSAMY");
	}

}
