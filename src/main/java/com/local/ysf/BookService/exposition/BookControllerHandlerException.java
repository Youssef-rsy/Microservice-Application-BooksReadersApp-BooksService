package com.local.ysf.BookService.exposition;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice(basePackageClasses={BookController.class})
public class BookControllerHandlerException  {

	Logger logger = LoggerFactory.getLogger(BookControllerHandlerException.class);
	
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> handelException(Exception exception , HttpServletRequest request){
		logger.error("####################### : "+exception.getMessage());
		ResponseEntity<Object> response = new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		return response;
	}
	
	
}
