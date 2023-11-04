package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.enums.UserStatus;
import service.LibraryService;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String phonne;
	private List<Book> userBooks;
	private UserStatus status;
	
	LibraryService service = new LibraryService();
	
	public User() {
		
	}
	
	public User(Integer id, String name, String email, String phonne, UserStatus status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonne = phonne;
		this.status = status;
		userBooks = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhonne() {
		return phonne;
	}
	
	public void setPhonne(String phonne) {
		this.phonne = phonne;
	}
	
	public UserStatus getStatus() {
		return status;
	}
	
	public void addBookUser(List<Book> bookList, String bookName) {
		userBooks.add(service.findByName(bookList, bookName));
	}
	
	public void removeBookUser(List<Book> borrowedBookList, String bookName) {
		userBooks.remove(service.findByName(borrowedBookList, bookName));
	}
	
	public List<Book> getUserBooks() {
		return userBooks;
	}
	
	@Override
	public String toString() {
		return String.format("\nUser id: %d | Name: %s | Email: %s | Phonne: %s | Status: %s\n", 
				id, name, email, phonne, status);
	}
	
}
