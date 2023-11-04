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
		Book book = new Book(1, "O Homem", "Paulo", 1991, BookGenre.Adventure, BookState.Good);
		Book book2 = new Book(2, "A Mulher", "Paulo", 1991, BookGenre.Adventure, BookState.Invalid);
		Book book3 = new Book(3, "O velho", "Paulo", 1991, BookGenre.Adventure, BookState.Bad);
		
		User user = new User(1, "Paulo", "paulohenrique3140@outlook.com", "11934069298", UserStatus.Active);
		
		Library library = new Library();
		library.addBook(book);
		library.addBook(book2);
		library.addBook(book3);
		System.out.println("Collection: \n" + library.showCollection());
		System.out.println("Invalid books: \n" + library.showInvalid());
		
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
		System.out.println("Devolution [Book name]: ");
		String devolutionName = input.nextLine();
		if (!library.devolution(devolutionName, user)) {
			System.out.println("Not found");
		} else {
			library.devolution(devolutionName, user);
			System.out.println("Collection: \n" + library.showCollection());
			System.out.println("Borrowed books: \n" + library.getBorrowedBooks());
		}
		input.close();
	}
}