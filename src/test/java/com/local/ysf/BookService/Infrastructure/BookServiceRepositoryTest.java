package com.local.ysf.BookService.Infrastructure;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.local.ysf.BookService.Entity.Book;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookServiceRepositoryTest {
	
	
	@Autowired
	private BookRepository repository;
	@Test
	public void test() {
		List<Book> lstBook =repository.findAll();
		assertNotNull(lstBook);
		
	}

}
