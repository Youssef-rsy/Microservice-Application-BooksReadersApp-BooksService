package com.local.ysf.BookService.exposition.exception;

public class InvalidData extends Exception{

	/**
	 * message :String
	 */
	private String message ;
	/**
	 * field:String
	 */
	private String field;

	/**
	 * @param message
	 * @param field
	 */
	public InvalidData(String message, String field) {
		super();
		this.message = message;
		this.field = field;
	}


	/**
	 * @param message
	 */
	public InvalidData(String message) {
		super(message);
		this.message = message;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	
	
	
}
