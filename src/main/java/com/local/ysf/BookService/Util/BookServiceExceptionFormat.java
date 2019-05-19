package com.local.ysf.BookService.Util;

/**
 * @author Youssef ROSSAMY
 *
 */
public class BookServiceExceptionFormat {

	
	/**
	 * error :String
	 */
	private String error;
	/**
	 * description:String
	 */
	private String description;
	/**
	 * BookServiceExceptionFormat
	 */
	public BookServiceExceptionFormat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param error
	 * @param code
	 * @param description
	 */
	public BookServiceExceptionFormat(String error,  String description) {
		super();
		this.error = error;
		this.description = description;
	}


	/**
	 * @return Error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
