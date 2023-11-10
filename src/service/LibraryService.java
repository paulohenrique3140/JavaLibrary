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
	
	// Method to return a book searched by name
	public Book findByName(List<Book> bookList, String name) {
		List<Book> list =  bookList.stream().filter(x -> x.getTitle().equals(name)).collect(Collectors.toList());
		Book book = list.get(0);
		return book;
	}
	
	// Method to check if a author exists in collection
	public boolean isThereAAuthor(List<Book> bookList, String author) {
		Book list = bookList.stream().filter(x -> x.getAuthor().equals(author)).findFirst().orElse(null);
		return list != null;
	}
	
	// Method to return a list book list by the author
	public List<Book> findByAuthor(List<Book> bookList, List<Book> borrowedBookList, String author) {
		List<Book> list = bookList.stream().filter(x -> x.getAuthor().equals(author)).collect(Collectors.toList());
		List<Book> list2 = borrowedBookList.stream().filter(x -> x.getAuthor().equals(author)).collect(Collectors.toList());
		for (Book x : list2) {
			list.add(x);
		}
		return list;
	}
	
	// Method to validate if a book is in borrowed book list
	public boolean isThereInBorrowedList(List<Book> borrowedBookList, String name) {
		Book list = borrowedBookList.stream().filter(x -> x.getTitle().equals(name)).findFirst().orElse(null);
		return list != null;
	}
}
