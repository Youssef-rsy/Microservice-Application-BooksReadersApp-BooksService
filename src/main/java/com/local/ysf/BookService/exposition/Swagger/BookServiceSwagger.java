package com.local.ysf.BookService.exposition.Swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Youssef ROSSAMY
 *
 */
@Configuration
@EnableSwagger2
public class BookServiceSwagger {
	
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select() 
	          .apis(RequestHandlerSelectors.basePackage("com.local.ysf.BookService.exposition"))              
	          .paths(PathSelectors.any())                         
	          .build()
	          .apiInfo(apiInfo());                                           
	    }
	 
	 public ApiInfo apiInfo(){
		 return new ApiInfo("Book service",//title
				 "this microservice is used to Manage Books by adding / modify / delete / read / show    ",//description
				 "1.0",//version
				 "Terms of service", //termsOfServiceUrl
				 new Contact("yousef rossamy ", "link to heroku", "youssef.rossamy@gmail.com"), //
				 "License of API", //license
				 "API license URL", //licenseUrl
				 Collections.emptyList()//vendorExtenstion
				 );
	 }

}
