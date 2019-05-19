package com.local.ysf.BookService.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Youssef ROSSAMY
 *
 */
@Entity
public class Book {

	/**
	 * bookId : UUID
	 */
	@Id
	@Type(type="uuid-char")
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "booksId", updatable = false, nullable = false)
	@ApiModelProperty(notes="represent id of the Book mapped as booksId in the database ")
	private UUID bookId;
	/**
	 * titre : String
	 */
	@ApiModelProperty(notes="represent the title of the book")
	private String title;
	/**
	 * author : String
	 */
	@ApiModelProperty(notes="represent the author who write the book")
	private String author;
	/**
	 * description : String
	 */
	@ApiModelProperty(notes="represent the resumer of the book")
	private String description;
	/**
	 * numberOfPage : int
	 */
	@ApiModelProperty(notes="represent the number of pages in the book")
	private int numberOfPage;

	/**
	 * Book
	 */
	public Book() {
		super();
	}

	/**
	 * @param bookId
	 * @param title
	 * @param author
	 * @param description
	 * @param numberOfPage
	 */
	public Book(UUID bookId, String title, String author, String description, int numberOfPage) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.numberOfPage = numberOfPage;
	}

	/**
	 * @param title
	 * @param author
	 * @param description
	 * @param numberOfPage
	 */
	public Book(String title, String author, String description, int numberOfPage) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.numberOfPage = numberOfPage;
	}

	/**
	 * @return
	 */
	public UUID getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 */
	public void setBookId(UUID bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return
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

	/**
	 * @return
	 */
	public int getNumberOfPage() {
		return numberOfPage;
	}

	/**
	 * @param numberOfPage
	 */
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

}