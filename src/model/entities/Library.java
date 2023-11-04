package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.enums.BookState;
import service.LibraryService;

public class Library {
	protected List<Book> bookList;
	protected List<Book> invalidBookList;
	protected List<Book> borrowedBookList;
	
	// Stanrting the lists
	public Library() {
		bookList = new ArrayList<>();
		invalidBookList = new ArrayList<>();
		borrowedBookList = new ArrayList<>();
	}
	
	// Instantiating an object of the service class to handle the class's utilities
	LibraryService service = new LibraryService();
	
	// Instantiating an object of the User class to handle the class's utilities
	User user = new User();
	
	//Method for adding a book class object to the library collection
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	//Method for displaying the library collection
	public List<Book> showCollection() {
		List<Book> auxList = new ArrayList<>();
		for (Book x : bookList) {
			if (x.getState() != BookState.Invalid) {
				auxList.add(x);
			}
		}
		return auxList;
	}
	
	//Method for displaying borrowed books
	public List<Book> getBorrowedBooks() {
		return borrowedBookList;
	}
	
	// Method to list books in invalid state
	public List<Book> showInvalid() {
		for (Book x : bookList) {
			if (x.getState() == BookState.Invalid) {
				invalidBookList.add(x);
			}
		}
		return invalidBookList;
	}
	
	// Method that invokes the LibraryService class to first check whether the requested book exists and if so, 
	// then returns the book passed in the parameter
	public Book searchBook(String name) {
		if (!service.isThereAbook(bookList, name)) {
			return null;
		}
		return service.findByName(bookList, name);
	}

	public boolean loan(String name, User user) {
		if (!service.isThereAbook(bookList, name)) {
			return false;
		} 
		// Adding the book to the borrowed list
		borrowedBookList.add(service.findByName(bookList, name));
		
		// Removing the book from the collection for loan
		bookList.remove(service.findByName(bookList, name));
		
		// Don't forgot: ADD BOOKUSER
		return true;
	}
	
	public boolean devolution(String name, User user) {
		if (!service.isThereAbook(borrowedBookList, name)) {
			return false;
		}
		
			// Returning the book to collection
		bookList.add(service.findByName(borrowedBookList, name));
		// Removing the book from the borrowed list
		borrowedBookList.remove(service.findByName(borrowedBookList, name));
		
		// Don't forgot: REMOVE BOOK USER
		return true;
	}
}
