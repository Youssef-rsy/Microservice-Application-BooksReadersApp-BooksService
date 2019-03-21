package com.local.ysf.BookService.exposition;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.ysf.BookService.Entity.Book;
import com.local.ysf.BookService.service.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins="*")
public class BookController {
	private static final Logger LOG = Logger.getLogger(BookController.class.getName());  
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(value="")
	public void saveBook(@RequestBody Book book){
		bookService.saveBook(book);
	}
	
	@GetMapping(value="/{bookId}")
	public Book getBook(@PathVariable UUID bookId){
		Book book = bookService.getBook(bookId);
		return book;
	}
	@GetMapping(value="")
	public List<Book> getAll(){
		List<Book> listOfBook = bookService.findAllBook();
		return listOfBook;
	}
	
	@DeleteMapping(value="/{bookId}")
	public void deleteBook(@PathVariable UUID bookId){
		bookService.deleteBook(bookId);
	}

	@PutMapping(value="/{bookId}")
	public Book updateBook(@PathVariable UUID bookId , @RequestBody Book book){
		Book mybook = bookService.updateBook(bookId, book);
		return mybook;
	}
	
	@GetMapping(value="/title/{title}")
	public Book getBookByTitle(@PathVariable String title){
		Book book = bookService.findBookByTitle(title);
		return book;
	}
	
	@GetMapping(value="/author/{author}")
	public List<Book> findAllBooksByAuthor(@PathVariable String author){
		List<Book> listOfBook = bookService.findBookByAuthor(author);
		return listOfBook;
	}
	
}
