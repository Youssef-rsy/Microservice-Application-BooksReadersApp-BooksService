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
import com.local.ysf.BookService.Util.BookServiceConstants;
import com.local.ysf.BookService.exposition.exception.InvalidData;
import com.local.ysf.BookService.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Youssef ROSSAMY
 *
 */
@RestController
@RequestMapping("/book")
//@CrossOrigin(origins="*")
public class BookController {
	
	private static final Logger LOG = Logger.getLogger(BookController.class.getName());  
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(value="")
	@ApiOperation(value = "Add New Book")
	@ApiResponses( value= {
			@ApiResponse(code=201, message = ""),
			@ApiResponse(code=400,message="Invalid data:"),
	})

	public void saveBook(@RequestBody Book book ) throws InvalidData{
		if(book.getNumberOfPage()<0)
			throw new InvalidData(BookServiceConstants.INVALID_MSG , "NumberOfPage");
		bookService.saveBook(book);
	}
	
	@GetMapping(value="/{bookId}")
	@ApiOperation(value = "Search a Book With an Id")
	public Book getBook(@PathVariable UUID bookId){
		Book book = bookService.getBook(bookId);
		return book;
	}
	@GetMapping(value="")
	@ApiOperation(value = "View a list of available Book")
	public List<Book> getAll(){
		List<Book> listOfBook = bookService.findAllBook();
		return listOfBook;
	}
	
	@DeleteMapping(value="/{bookId}")
	@ApiOperation(value = "Delete a specefic Book by Id")
	public void deleteBook(@PathVariable UUID bookId){
		bookService.deleteBook(bookId);
	}

	@PutMapping(value="/{bookId}")
	@ApiOperation(value = "Update a  Book ")
	public Book updateBook(@PathVariable UUID bookId , @RequestBody Book book){
		Book mybook = bookService.updateBook(bookId, book);
		return mybook;
	}
	
	@GetMapping(value="/title/{title}")
	@ApiOperation(value = "View a List of Books Based on The Book Title ")
	public Book getBookByTitle(@PathVariable String title){
		Book book = bookService.findBookByTitle(title);
		return book;
	}
	
	@GetMapping(value="/author/{author}")
	@ApiOperation(value = "View a List of Books Based on The Book Author ")
	public List<Book> findAllBooksByAuthor(@PathVariable String author){
		List<Book> listOfBook = bookService.findBookByAuthor(author);
		return listOfBook;
	}
	
}
