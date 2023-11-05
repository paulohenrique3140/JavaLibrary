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
		Book book3 = new Book(3, "O velho", "Paulo", 1991, BookGenre.Adventure, BookState.Bad);
		
		User user = new User(1, "John", "jhon@paulo.com", "11934069298", UserStatus.Active);
		User user2 = new User(2, "Marie", "marie@email.com", "11965564849", UserStatus.Inactive);
		User user3 = new User(3, "Herbert", "herbert@email.com", "11946558797", UserStatus.Vip);
		
		UserManagement userManagement = new UserManagement();
		Library library = new Library();
		
		
		/* TESTS WITH LIBRARY
		library.addBook(book);
		library.addBook(book2);
		library.addBook(book3);
		
		// Test to show data
		System.out.println("Collection: \n" + library.showCollection());
		System.out.println("Invalid books: \n" + library.getInvalidBook());
		System.out.println();
		System.out.println("Acvite users: \n" + userManagement.showUsers());
		System.out.println("Inactive users: \n" + userManagement.getInactiveUserList());
		System.out.println("Vip users: \n" + userManagement.showVip());
		System.out.println();
		
		// Test to loan book
		System.out.print("Loan [Book name]: ");
		String loanName = input.nextLine();
		if (!library.loan(loanName, user)) {
			System.out.println("Not found!");
		} else {
			library.loan(loanName, user);
			
			System.out.println("Collection: \n" + library.showCollection());
			System.out.println("Borrowed books: \n" + library.getBorrowedBooks());
			System.out.println("User books: \n" + user.getUserBooks());
		}
		System.out.println();
		
		// Test to devolution book
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
			System.out.println("User books: \n" + user.getUserBooks());
		}
		System.out.println();
		
		// Test to find books by author
		System.out.print("Author: ");
		input.nextLine();
		String author = input.nextLine();
		System.out.println(library.searchAuthor(author));
		System.out.println();
		/*
		
		########################################
		
		/* TESTS WITH USERMANAGEMENT
		userManagement.addUser(user);
		userManagement.addUser(user2);
		userManagement.addUser(user3);
		
		// Test to show data
		System.out.println("Acvite users: \n" + userManagement.showUsers());
		System.out.println("Inactive users: \n" + userManagement.getInactiveUserList());
		System.out.println("Vip users: \n" + userManagement.showVip());
		System.out.println();
		System.out.println();
		System.out.println("TODOS USUARIOS JUNTOS");
		System.out.println(userManagement.getUserList());
		System.out.println();
		
		// Test search user by email
		System.out.println("Find user. Type email: ");
		String email = input.nextLine();
		if (userManagement.searchUser(email) == null) {
			System.out.print("User not found");			
		} else {
			System.out.print("\nResult of your search:" + userManagement.searchUser(email));
		}
		System.out.println();
		System.out.println();
		System.out.print("Change user status. Type email user: ");
		email = input.nextLine();
		if (userManagement.searchUser(email) == null) {
			System.out.println("User not found");
		} else {
			System.out.print("Type the status to update [0 = Inactive / 1 = Active / 2 = Vip");
			int userStatus = input.nextInt();
			userManagement.changeStatus(email, userStatus);
		}
		System.out.print("Updated data: " );
		System.out.println("Acvite users: \n" + userManagement.showUsers());
		System.out.println("Inactive users: \n" + userManagement.getInactiveUserList());
		System.out.println("Vip users: \n" + userManagement.showVip());
		System.out.println();
		System.out.println();
		System.out.println("TODOS USUARIOS JUNTOS");
		System.out.println(userManagement.getUserList());
		System.out.println();
		System.out.println();
		System.out.print("User borrowed books. Type an email: ");
		input.nextLine();
		email = input.nextLine();
		if (userManagement.searchUser(email) == null) {
			System.out.println("User not found");
		} else {
			System.out.printf("\n%s borrowed book list: \n%s", 
					userManagement.searchUser(email).getName(), userManagement.searchUser(email).getUserBooks());
		}*/
		
		input.close();
	}
}