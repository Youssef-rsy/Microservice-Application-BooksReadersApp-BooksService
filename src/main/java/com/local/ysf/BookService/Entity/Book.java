package com.local.ysf.BookService.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Book {

	@Id
	@Type(type="uuid-char")
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "booksId", updatable = false, nullable = false)
	private UUID bookId;
	private String title;
	private String author;
	private String description;
	private int numberOfPage;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(UUID bookId, String title, String author, String description, int numberOfPage) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.numberOfPage = numberOfPage;
	}

	public Book(String title, String author, String description, int numberOfPage) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.numberOfPage = numberOfPage;
	}

	public UUID getBookId() {
		return bookId;
	}

	public void setBookId(UUID bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

}