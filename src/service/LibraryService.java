package service;

import java.util.List;
import java.util.stream.Collectors;

import model.entities.Book;

public class LibraryService {
	
	// Method to check if a book exists in the collection
	public boolean isThereAbook(List<Book> bookList, String name) {
		Book list = bookList.stream().filter(x -> x.getTitle().equals(name)).findFirst().orElse(null);
		return list != null;
	}
	
	// Method to return the object searched by name
	public Book findByName(List<Book> bookList, String name) {
		List<Book> list =  bookList.stream().filter(x -> x.getTitle().equals(name)).collect(Collectors.toList());
		Book book = list.get(0);
		return book;
	}
}
