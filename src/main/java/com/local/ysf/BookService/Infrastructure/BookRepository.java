package com.local.ysf.BookService.Infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.ysf.BookService.Entity.Book;

/**
 * @author Youssef ROSSAMY
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, UUID>{

	public Optional<Book> findByTitle(String title);
	
	public List<Book> findByAuthor(String author);
}
