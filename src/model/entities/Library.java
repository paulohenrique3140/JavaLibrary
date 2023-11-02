package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.enums.BookState;
import service.LibraryService;

public class Library {
	protected List<Book> bookList;
	protected List<Book> invalidBookList;
	protected List<Book> borrowedBookList;
	
	public Library() {
		bookList = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public List<Book> showCollection() {
		List<Book> auxList = new ArrayList<>();
		for (Book x : bookList) {
			if (x.getState() != BookState.Invalid) {
				auxList.add(x);
			}
		}
		return auxList;
	}
	
	public List<Book> showInvalid() {
		List<Book> auxList = new ArrayList<>();
		for (Book x : bookList) {
			if (x.getState() == BookState.Invalid) {
				auxList.add(x);
			}
		}
		return auxList;
	}
	
	public Book searchBook(String name) {
		LibraryService service = new LibraryService();
		if (!service.isThereAbook(bookList, name)) {
			return null;
		}
		return service.findByName(bookList, name);
	}
	
}
