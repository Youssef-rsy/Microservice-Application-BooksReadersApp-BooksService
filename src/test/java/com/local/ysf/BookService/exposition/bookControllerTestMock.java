package com.local.ysf.BookService.exposition;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.javafaker.Faker;
import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class bookControllerTestMock {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	BookService bookservice;
	
	private static final UUID uuid = UUID.randomUUID();
	
	private Book getRandomBook() {
		return new Book(uuid, faker.book().title(), faker.book().author(), faker.book().publisher(), faker.number().randomDigitNotZero());
	}
	
	@Test
	public void test() {
		// TODO Auto-generated method stub
		when(bookservice.getBook(uuid)).thenReturn(getRandomBook());
	}
	
	
	private Book book;
	private Faker faker = new Faker();
	@Test
	public void getBook_Nominal() throws Exception {//call /book/{bookId}
		
		//book = getRandomBook();
		RequestBuilder request = MockMvcRequestBuilders
												.get("/book/${bookId}",uuid.toString())
												.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc
								.perform(request)
								//.andExpect(status())
								.andReturn();
		assertNotNull(result.getResponse());
	}

}
