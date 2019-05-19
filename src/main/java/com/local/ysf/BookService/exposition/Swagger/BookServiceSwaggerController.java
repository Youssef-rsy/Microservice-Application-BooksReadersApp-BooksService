package com.local.ysf.BookService.exposition.Swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Youssef ROSSAMY
 *
 */
@Controller
public class BookServiceSwaggerController {
	
	 	@RequestMapping ("/swagger")
	    public String home() {
		return "redirect:/swagger-ui.html";
	    }

}
