package com.local.ysf.BookService.exposition;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.invoke.MissingParametersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.local.ysf.BookService.Util.BookServiceConstants;
import com.local.ysf.BookService.Util.BookServiceExceptionFormat;
import com.local.ysf.BookService.exposition.exception.InvalidData;


@ControllerAdvice(basePackageClasses={BookController.class})
public class BookControllerHandlerException  {

	Logger logger = LoggerFactory.getLogger(BookControllerHandlerException.class);
	
	
	
	@ExceptionHandler(InvalidData.class)
	public ResponseEntity<BookServiceExceptionFormat> handelInvalidData(InvalidData invalidData){
		logger.info("Custom Exception : "+invalidData.getMessage());
		BookServiceExceptionFormat bookServiceExceptionFormat  = new BookServiceExceptionFormat( BookServiceConstants.INVALID_ERROR,
				invalidData.getMessage().replace("?", invalidData.getField()));
		return new ResponseEntity<BookServiceExceptionFormat>(bookServiceExceptionFormat, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler({MissingPathVariableException.class,
					MissingRequestHeaderException.class,
					MissingParametersException.class,
					ServletRequestBindingException.class
					})
	public ResponseEntity<BookServiceExceptionFormat> handelMissingrequest(ServletRequestBindingException exception){
		logger.info("Servlet Exception : "+exception.getMessage());
		return new ResponseEntity<BookServiceExceptionFormat>(messageBuillder(BookServiceConstants.SERVLET_ERROR,exception.getMessage()), HttpStatus.BAD_REQUEST);
	}


	private BookServiceExceptionFormat messageBuillder(String error , String messageDescription) {
		BookServiceExceptionFormat bookServiceExceptionFormat  = new BookServiceExceptionFormat( error, messageDescription);
		return bookServiceExceptionFormat;
	}
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> handelException(Exception exception , HttpServletRequest request){
		logger.info("General Exception : "+exception.getMessage());
		return new ResponseEntity<Object>(messageBuillder(BookServiceConstants.EXCEPTION_ERROR,exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
