package application;

import java.util.Scanner;

import model.entities.Book;
import model.entities.Library;
import model.entities.User;
import model.entities.UserManagement;
import model.entities.enums.BookGenre;
import model.entities.enums.BookState;
import model.entities.enums.UserStatus;

public class Program {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Book book = new Book(1, "O Homem", "Roberto", 1991, BookGenre.Adventure, BookState.Good);
		Book book2 = new Book(2, "A Mulher", "Roberto", 1991, BookGenre.Adventure, BookState.Good);
		Book book3 = new Book(3, "O Velho", "Paulo", 1991, BookGenre.Adventure, BookState.Bad);
		Book book4 = new Book(4, "O Moco", "Paulo", 1991, BookGenre.Adventure, BookState.Invalid);
		Book book5 = new Book(5, "O Fone", "Giovana", 1991, BookGenre.Adventure, BookState.Bad);
		Book book6 = new Book(6, "Controle", "Helena", 1991, BookGenre.Adventure, BookState.Bad);
		
		User user = new User(1, "John", "jhon@email.com", "11934069298", UserStatus.Active);
		User user2 = new User(2, "Marie", "marie@email.com", "11965564849", UserStatus.Active);
		User user3 = new User(3, "Herbert", "herbert@email.com", "11946558797", UserStatus.Inactive);
		User user4 = new User(4, "Kayle", "kayle@email.com", "11946665879", UserStatus.Vip);
		User user5 = new User(5, "Julien", "julien@email.com", "11996658797", UserStatus.Active);
		User user6 = new User(6, "Ingrid", "ingrid@email.com", "11935449458", UserStatus.Active);
		
		UserManagement userManagement = new UserManagement();
		Library library = new Library();
		
		// Test to add objects
		library.addBook(book);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);
		library.addBook(book6);
		
		userManagement.addUser(user);
		userManagement.addUser(user2);
		userManagement.addUser(user3);
		userManagement.addUser(user4);
		userManagement.addUser(user5);
		userManagement.addUser(user6);
		
		/*
		 * 
		 *
		// Test to show lists
		System.out.println("\nAvailable books: \n" + library.showCollection());
		System.out.println("\nInavailable books: \n" + library.getInvalidBook());
		System.out.println("\nAll books: \n" + library.getBookList());
		System.out.println();
		System.out.println("\nActive users: \n" + userManagement.showUsers());
		System.out.println("\nVip users: \n" + userManagement.showVip());
		System.out.println("\nInactive users: \n" + userManagement.getInactiveUserList());
		System.out.println("\nAll Users in register: \n" + userManagement.getUserList());
		
		// Test to search a book
		System.out.print("\nSearch a book. Type the title: ");
		String title = input.nextLine();
		System.out.print(library.searchBook(title) != null ? library.searchBook(title) : "Book's not found!");
		
		// Test to search books by author
		System.out.print("\nBooks by author. Type an author: ");
		String author = input.nextLine();
		System.out.println(library.searchAuthor(author) != null ? library.searchAuthor(author) : "Author's not found!");
		
		// Test to search a user
		System.out.print("\nSearch a user. Type the email: ");
		String email = input.nextLine();
		System.out.println(userManagement.searchUser(email) != null ? userManagement.searchUser(email) : "User's not found");
		*
		**
		*/
		
		// Test to loan and devolution
		System.out.print("\nLoan books. Type a book title: ");
		String title = input.nextLine();
		System.out.print("\nType email user to borrow the book: ");
		String email = input.nextLine();
		if (library.searchBook(title) == null || userManagement.searchUser(email) == null) {
			System.out.println("Invalid book or user. Try again.");
		} else {
			library.loan(title, userManagement.searchUser(email));
			
		}
		
		
		
		//library.searchBook(title = input.nextLine() != null ? library.loan(title, user6) : System.out.print("\nBook's not found"));
		
		
		
		input.close();
	}
}