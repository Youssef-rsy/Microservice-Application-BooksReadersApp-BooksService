package com.local.ysf.BookService.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;


/**
 * @author Youssef ROSSAMY
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BookServiceIntegrationTest {// integrartion test of the BookService  using springBoot 

	
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	private Book book ;
	private Faker faker;
	
	private Book getRandomBook(){
		Faker faker = new Faker();
		return new Book(faker.book().title(), faker.book().author(), faker.book().publisher(), faker.number().randomDigitNotZero());
	}
	@Ignore
	@Test
	public void AddNewBookNominalCase(){
		HttpEntity<Book> entity = new HttpEntity<>(getRandomBook());
		ResponseEntity<String> response = testRestTemplate.postForEntity("/book", entity,null);
		assertEquals(200,response.getStatusCodeValue());
	}
	@Ignore
	@Test
	public void getBookByIdNomibalCase(){
		ResponseEntity<Book> response =   testRestTemplate.getForEntity("/book/e6d564de-0fe1-47ff-9b7b-54828b00f2ad", Book.class);
		Book book = response.getBody();
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(book);
		assertEquals("e6d564de-0fe1-47ff-9b7b-54828b00f2ad",book.getBookId().toString());
	}
	
	
	@Test
	public void getAllBooksNominalCase(){
		ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/book", Book[].class);
		List<Book> lst =Arrays.asList(response.getBody());
		assertThat(response.getStatusCode(), equalTo((HttpStatus.OK)));
		assertThat(lst, notNullValue());
		assertNotEquals(0, lst.size());
	}
	
	@Ignore
	@Test
	public void updateBookNominalCase(){
		testRestTemplate.put("/book/e6d564de-0fe1-47ff-9b7b-54828b00f2ad",getRandomBook());
		ResponseEntity<Book> response =   testRestTemplate.getForEntity("/book/e6d564de-0fe1-47ff-9b7b-54828b00f2ad", Book.class);
		Book book = response.getBody();
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(book);
		assertEquals("e6d564de-0fe1-47ff-9b7b-54828b00f2ad",book.getBookId().toString());
	}
	
	@Ignore
	@Test
	public void deleteBook(){
		testRestTemplate.delete("/book/892406bf-9412-4548-8e5b-97fc1e08d2c9");
		ResponseEntity<Book> response =   testRestTemplate.getForEntity("/book/892406bf-9412-4548-8e5b-97fc1e08d2c9", Book.class);
		Book book = response.getBody();
		assertNull(book);
	}
	
	

	@Test
	public void getAllBooksByAuthorNameNominalCase(){
		ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/book/author/youssef rossamy", Book[].class);
		List<Book> lst =Arrays.asList(response.getBody());
		assertThat(response.getStatusCode(), equalTo((HttpStatus.OK)));
		assertThat(lst, notNullValue());
		assertEquals(3, lst.size());
	}
	

}
