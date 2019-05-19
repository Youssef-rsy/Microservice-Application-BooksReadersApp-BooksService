package com.local.ysf.BookService.exposition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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


/**
 * @author Youssef ROSSAMY
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class bookControllerTestMock {//testing exposition layer : controllers

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	BookService bookservice;
	
	private Faker faker = new Faker();
	private final Book book =new Book(RANDOM_UUID, faker.book().title(), faker.book().author(), faker.book().publisher(), faker.number().randomDigitNotZero());
	
	private static final UUID RANDOM_UUID = UUID.randomUUID();
	
	protected Book getRandomBook() {
		return book;
	}
	
	@Before
	public void test() {
		// TODO Auto-generated method stub
		when(bookservice.getBook(RANDOM_UUID)).thenReturn(getRandomBook());
		
	}
	
	
	@Test
	public void getBook_Nominal() throws Exception {//call /book/{bookId}
		
		//book = getRandomBook();
		RequestBuilder request = MockMvcRequestBuilders
												.get("/book/{bookId}",RANDOM_UUID)
												.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc
								.perform(request)
								.andExpect(status().isOk())//.andExpect(status().is(200))
								.andExpect(content()
										.json( 
												"{bookId:\""+RANDOM_UUID+"\","+ 
												"title: \""+getRandomBook().getTitle()+"\" , " + 
												"author:\""+getRandomBook().getAuthor()+"\" , " + 
												"description:\""+getRandomBook().getDescription()+"\"" + 
												//"numberOfPage:" +getRandomBook().getNumberOfPage() +
												"}"))///it use JSONAssert.assertEquals 
								.andExpect(content()
										.json( 
												"{bookId:\""+RANDOM_UUID+"\","+ 
												"title: \""+getRandomBook().getTitle()+"\" , " + 
												"author:\""+getRandomBook().getAuthor()+"\" , " + 
												"description:\""+getRandomBook().getDescription()+"\"," + 
												"numberOfPage:" +getRandomBook().getNumberOfPage() +
												"}" ,true))///it use JSONAssert.assertEquals 
								.andReturn();
		ArgumentCaptor<UUID> uuidArgCaptor = ArgumentCaptor.forClass(UUID.class);
		verify(bookservice ,times(1)).getBook(uuidArgCaptor.capture());
		
		  /*String actualResponseBody = result.getResponse().getContentAsString();
		  assertThat(ObjectMapper.writeValueAsString(book)) .isEqualToIgnoringWhitespace(actualResponseBody);*/
		
		
	}
	
	
	
	@Test
	public void getBook_post() throws Exception {//call /book/{bookId}
		
		//book = getRandomBook();
		RequestBuilder request = MockMvcRequestBuilders
												.post("/book")
												.contentType(MediaType.APPLICATION_JSON)
												.content("{\"title\" : \" "+getRandomBook().getTitle()+"\" ," + 
														"  \"author\" :\" "+getRandomBook().getAuthor()+"\" , " + 
														"  \"description\" :\" "+getRandomBook().getDescription()+"\" ," + 
														"  \"numberOfPage\" :" +getRandomBook().getNumberOfPage() +
														"}")
												.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc
								.perform(request)
								.andExpect(status().isOk())//.andExpect(status().is(200))
								.andReturn();
		
		ArgumentCaptor<Book> uuidArgCaptor = ArgumentCaptor.forClass(Book.class);
		verify(bookservice ,times(1)).saveBook(uuidArgCaptor.capture());
	
	}
	
	

}
