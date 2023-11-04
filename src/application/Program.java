package application;

import java.util.Scanner;

import model.entities.Book;
import model.entities.Library;
import model.entities.User;
import model.entities.enums.BookGenre;
import model.entities.enums.BookState;
import model.entities.enums.UserStatus;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Book book = new Book(1, "O Homem", "Roberto", 1991, BookGenre.Adventure, BookState.Good);
		Book book2 = new Book(2, "A Mulher", "Roberto", 1991, BookGenre.Adventure, BookState.Good);
		Book book3 = new Book(3, "O velho", "Paulo", 1991, BookGenre.Adventure, BookState.Bad);
		
		User user = new User(1, "Paulo", "paulohenrique3140@outlook.com", "11934069298", UserStatus.Active);
		
		Library library = new Library();
		library.addBook(book);
		library.addBook(book2);
		library.addBook(book3);
		/*System.out.println("Collection: \n" + library.showCollection());
		System.out.println("Invalid books: \n" + library.getInvalidBook());
		
		System.out.println();
		System.out.print("Loan [Book name]: ");
		String loanName = input.nextLine();
		if (!library.loan(loanName, user)) {
			System.out.println("Not found!");
		} else {
			library.loan(loanName, user);
			System.out.println("Collection: \n" + library.showCollection());
			System.out.println("Borrowed books: \n" + library.getBorrowedBooks());
		}
		System.out.println();
		System.out.print("Devolution [Book name]: ");
		String devolutionName = input.nextLine();
		System.out.print("Book state [0 = Invalid / 1 = Bad / 2 = Good]: ");
		int bookState = input.nextInt();
		if (!library.devolution(devolutionName, user, bookState)) {
			System.out.println("Not found");
		} else {
			library.devolution(devolutionName, user, bookState);
			System.out.println("Collection: \n" + library.showCollection());
			System.out.println("Borrowed books: \n" + library.getBorrowedBooks());
			System.out.println("Invalid books: \n" + library.getInvalidBook());
		}*/
		
		System.out.print("Author: ");
		String author = input.nextLine();
		System.out.println(library.searchAuthor(author));
		input.close();
	}
}