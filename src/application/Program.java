package application;

import java.util.Scanner;

import model.entities.Book;
import model.entities.Library;
import model.entities.enums.BookGenre;
import model.entities.enums.BookState;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Book book = new Book(1, "O Homem", "Paulo", 1991, BookGenre.Adventure, BookState.Good);
		Book book2 = new Book(2, "A Mulher", "Paulo", 1991, BookGenre.Adventure, BookState.Invalid);
		Book book3 = new Book(3, "O velho", "Paulo", 1991, BookGenre.Adventure, BookState.Bad);
		Library library = new Library();
		library.addBook(book);
		library.addBook(book2);
		library.addBook(book3);
		System.out.println("Collection: \n" + library.showCollection());
		System.out.println("Invalid books: \n" + library.showInvalid());
		System.out.println();
		System.out.println("Search [Book name]: ");
		String searchName = input.nextLine();
		if (library.searchBook(searchName) == null) {
			System.out.println("Not found!");
		} else {
			System.out.println(library.searchBook(searchName));
		}
		
		input.close();
	}
}