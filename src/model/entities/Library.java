package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.enums.BookState;
import model.entities.enums.UserStatus;
import model.exceptions.LibraryException;
import service.LibraryService;

public class Library {
	private List<Book> bookList;
	private List<Book> invalidBookList;
	private List<Book> borrowedBookList;
		
	// Instantiating an object of the service class to handle the class's utilities
	LibraryService service = new LibraryService();
	
	// Instantiating an object of the User class to handle the class's utilities
	User user = new User();
	
	// Starting the lists
	public Library() {
		bookList = new ArrayList<>();
		invalidBookList = new ArrayList<>();
		borrowedBookList = new ArrayList<>();
	}
	
	public List<Book> getBookList(){
		return bookList;
	}
	
	public List<Book> getBorrowedBooks() {
		return borrowedBookList;
	}
	
	public List<Book> getInvalidBook() {
		return invalidBookList;
	}
		
	//Method for adding a book class object to the library collection
	public void addBook(Book book) {
		if (book.getState() == BookState.Invalid) {
			invalidBookList.add(book);
		}
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
		if (auxList.size() == 0) {
			throw new LibraryException("There're no books available");
		}
		return auxList;
	}
	
	// Method that invokes the LibraryService class to first check whether the requested book exists and if so, 
	// then returns the book passed in the parameter
	public Book searchBook(String name) {
		if (!service.isThereAbook(bookList, name) || service.findByName(bookList, name).getState() == BookState.Invalid) {
			throw new LibraryException("Book not found or unavailable");
		}
		return service.findByName(bookList, name);
	}
	
	// Method to validate if a book is in borrowed book list
	public boolean searchBorrowedBook(String name) {
		if (!service.isThereInBorrowedList(borrowedBookList, name)) {
			throw new LibraryException("Book not found in Borrowed Book List");
		}
		return true;
	}
	
	// Method to search book list by author
	public List<Book> searchAuthor(String author) {
		if (!service.isThereAAuthor(bookList, author)) {
			throw new LibraryException("There's no results for this search");
		}
		return service.findByAuthor(bookList, author);
	}

	// Method to loan books
	public boolean loan(String name, User user) {
		if (!service.isThereAbook(bookList, name)) {
			throw new LibraryException("Book not found or unavailable");
		} else if (user.getStatus() == UserStatus.Inactive) {
			throw new LibraryException("User inactive!");
		}
		
		// Adding the book to the book user's list
		user.addBookUser(bookList, name);
		
		// Adding the book to the borrowed list
		borrowedBookList.add(service.findByName(bookList, name));
		
		// Removing the book from the collection for loan
		bookList.remove(service.findByName(bookList, name));
		return true;
	}
	
	// Method to return books
	public boolean devolution(String name, User user, int state) {
		if (!service.isThereAbook(user.getUserBooks(), name)) {
			throw new LibraryException("Book not found on user book list");
		}
		
		// Changing book state
		if (state == 0) {
			invalidBookList.add(service.findByName(borrowedBookList, name));
			service.findByName(user.getUserBooks(), name).setState(BookState.Invalid);
		} else if (state == 1) {
			service.findByName(user.getUserBooks(), name).setState(BookState.Bad);
		} else {
			service.findByName(user.getUserBooks(), name).setState(BookState.Good);
		}
		
		// Returning the book to collection
		bookList.add(service.findByName(borrowedBookList, name));
		
		// Removing the book from the book user's list
		user.removeBookUser(borrowedBookList, name);
		
		// Removing the book from the borrowed list
		borrowedBookList.remove(service.findByName(borrowedBookList, name));
		
		return true;
	}
}
