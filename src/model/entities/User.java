package model.entities;

import java.util.List;

import model.entities.enums.UserStatus;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String phonne;
	private List<Book> userBooks;
	private UserStatus status;
	
	public User() {
		
	}
	
	public User(Integer id, String name, String email, String phonne, UserStatus status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonne = phonne;
		this.status = status;
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
	
	@Override
	public String toString() {
		return String.format("User id: %d | Name: %s | Email: %s | Phonne: %s | Status: %s", 
				id, name, email, phonne, status);
	}
	
}
