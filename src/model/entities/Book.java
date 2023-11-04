package model.entities;

import model.entities.enums.BookGenre;
import model.entities.enums.BookState;

public class Book {
	private Integer isbn;
	private String title;
	private String author;
	private Integer release;
	private BookGenre genre;
	private BookState state;
	
	public Book() {
		
	}
	
	public Book(Integer isbn, String title, String author, Integer release, BookGenre genre, BookState state) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.release = release;
		this.genre = genre;
		this.state = state;
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
	
	public Integer getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	public Integer getRelease() {
		return release;
	}
	
	public void setRelease(Integer release) {
		this.release = release;
	}
	
	public BookGenre getGenre() {
		return genre;
	}
	
	public BookState getState() {
		return state;
	}
	
	public void setState(BookState state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return String.format("\nISBN: %d | Title: %s | Author: %s | Release: %d | Genre: %s | State: %s\n", 
				isbn, title, author, release, genre, state);
	}
	
	
	
	
	
	
	
}