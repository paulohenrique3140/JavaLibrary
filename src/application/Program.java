package application;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.entities.Book;
import model.entities.Library;
import model.entities.User;
import model.entities.UserManagement;
import model.entities.enums.BookGenre;
import model.entities.enums.BookState;
import model.entities.enums.UserStatus;
import model.exceptions.LibraryException;

public class Program {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		UserManagement userManagement = new UserManagement();
		Library library = new Library();
		Book book;
		User user;
		int option = -1;
		while (option != 0 ) {
			System.out.println("\n##### JAVA LIBRARY ####");
			try {
				System.out.print("\nMenu: \n"
						+ "[1] Library\n[2] User registration\n[0] Exit\n");
				System.out.print("\nChoose an option: ");
				option = input.nextInt();
				option = validateOption(option, 2);
				
				if (option == 1) {
					switch (option) {
					case 1:
						System.out.println("\n### WELCOME TO THE LIBRARY ###");
						System.out.print("\nMenu: \n"
								+ "[1] Add book\n[2] Show collection\n[3] Search book\n[4] Search by author\n"
								+ "[5] Book loan\n[6] Book return\n[0] Return to previous menu\n");
						System.out.print("\nChoose an option: ");
						int optionTwo = input.nextInt();
						optionTwo = validateOption(optionTwo, 6);
						
						switch(optionTwo) {
						case 1:
							System.out.println("\n### BOOK ADD ###");
							System.out.print("\nBook ISBN: ");
							int isbn = input.nextInt();
							while (hasIsbn(library.getBookList(), isbn)) {
								System.out.print("The ID already exists. Please choose another one: ");
								isbn = input.nextInt();
							}
							System.out.print("\nBook title: ");
							input.nextLine();
							String title = input.nextLine();
							System.out.print("\nBook author: ");
							String author = input.nextLine();
							System.out.print("\nPublication Year of the Book: ");
							int release = input.nextInt();
							System.out.print("\nGenre: ");
							BookGenre genre = BookGenre.valueOf(input.next());
							System.out.print("\nBook State: ");
							BookState state = BookState.valueOf(input.next());
							book = new Book(isbn, title, author, release, genre, state);
							library.addBook(book);
							System.out.println("\nDone!");
							break;
						case 2:
							int optionThree = -1;
							do {
								System.out.println("\n### LIBRARY COLLECTION ###");
								System.out.print("\n[1] Show available books\n[2] Show unavailable books\n"
										+ "[3] Show all books\n[0] Main menu\n");
								System.out.print("\nChoose an option: ");
								optionThree = input.nextInt();
								optionThree = validateOption(optionThree, 3);
								if (optionThree == 1) {
									System.out.println("\n### Available books ###\n" + library.showCollection());
								} else if (optionThree == 2) {
									System.out.println("\n### Unavailable books ###\n" + library.getInvalidBook());
									System.out.println("\nInvalid books\n" + library.getInvalidBook());
									System.out.println("\nBorrowed books\n" + library.getBorrowedBooks());
								} else {
									System.out.println("\n### All library books ###\n" + library.getBookList());
								}
							} while(optionThree != 0);
							break;
						case 3:
							System.out.println("\n### SEARCHING A BOOK ###");
							System.out.print("\nPlease, type the title book: ");
							input.nextLine();
							String titleSearch = input.nextLine();
							System.out.println("### Search results ###\n" + library.searchBook(titleSearch));
							break;
						case 4:
							System.out.println("\n### SEARCHING BY AUTHOR ###");
							System.out.print("\nAuthor to search: ");
							input.nextLine();
							String authorSearch = input.nextLine();
							System.out.println("### Search results ###\n" + library.searchAuthor(authorSearch));
							break;
						case 5:
							System.out.println("\n### BOOK LOAN ###");
							System.out.print("\nPlease, type the title book to loan: ");
							input.nextLine();
							String titleLoan = input.nextLine();
							library.searchBook(titleLoan);
							System.out.print("\nEnter the user's email for the loan: ");
							String emailLoan = input.nextLine();
							userManagement.searchUser(emailLoan);
							if (library.loan(titleLoan, userManagement.searchUser(emailLoan))) {
								System.out.println("User books: " + userManagement.searchUser(emailLoan).getUserBooks());
							}
							break;
						default:
							System.out.println("Good Bye");
						}
					}
				} else if (option == 2) {
					System.out.println("\n### USER ADD ###");
					System.out.print("\nUser id: ");
					int id = input.nextInt();
					while (hasId(userManagement.getUserList(), id)) {
						System.out.print("The ID already exists. Please choose another one: ");
						id = input.nextInt();
					} 
					System.out.print("\nUsername: ");
					input.nextLine();
					String name = input.nextLine();
					System.out.print("\nEmail: ");
					String email = input.nextLine();
					System.out.print("\nPhonne number ");
					String phonne = input.nextLine();
					System.out.print("\nUser status: ");
					UserStatus status = UserStatus.valueOf(input.next());
					user = new User(id, name, email, phonne, status);
					userManagement.addUser(user);
				}
			} catch (LibraryException e) {
				System.out.println("\nError! " + e.getMessage());
			}  catch (InputMismatchException e) {
				System.out.println("\nError: Invalid data type! \n");
				input.nextLine();
			} catch (RuntimeException e) {
				System.out.print("\nUnexpected error.");
				input.nextLine();
			}
		}
		
		/*
		// Test to show users
		System.out.println("\nActive users: \n" + userManagement.showUsers());
		System.out.println("\nVip users: \n" + userManagement.showVip());
		System.out.println("\nInactive users: \n" + userManagement.getInactiveUserList());
		System.out.println("\nAll Users in register: \n" + userManagement.getUserList());
		
		
		// Test to search a book
		System.out.print("\nSearch a book. Type the title: ");
		String title5 = input.nextLine();
		System.out.print(library.searchBook(title5) != null ? library.searchBook(title5) : "Book's invalid state or not found!");
		
		// Test to search books by author
		System.out.print("\nBooks by author. Type an author: ");
		String author = input.nextLine();
		System.out.println(library.searchAuthor(author) != null ? library.searchAuthor(author) : "Author's not found!");
		
		// Test to search a user
		System.out.print("\nSearch a user. Type the email: ");
		String email5 = input.nextLine();
		System.out.println(userManagement.searchUser(email5) != null ? userManagement.searchUser(email5) : "User's not found or inactive");
			
				
		// Test to loan books
		System.out.print("\nLoan books. Type 1th book title: ");
		String title = input.nextLine();
		System.out.print("\nLoan books. Type 2nd book title: ");
		String title2 = input.nextLine();
		System.out.print("\nLoan books. Type 3rd book title: ");
		String title3 = input.nextLine();
		
		System.out.print("\nType email user to borrow the book: ");
		String email = input.nextLine();
		if (library.searchBook(title) == null || library.searchBook(title2) == null || library.searchBook(title3) == null ||
				userManagement.searchUser(email) == null || userManagement.searchUser(email).getStatus() == UserStatus.Inactive) {
			System.out.println("Book or user not found. Try again with book valid and user active.");
		} else {
			library.loan(title, userManagement.searchUser(email));
			library.loan(title2, userManagement.searchUser(email));
			library.loan(title3, userManagement.searchUser(email));
			System.out.println(userManagement.searchUser(email));
			System.out.println("\nUser borrowed books: \n" + userManagement.searchUser(email).getUserBooks());
			System.out.println("\nLibrary book collection: \n" + library.showCollection());
			System.out.println("\nLibrary borrowed books: \n" + library.getBorrowedBooks());
			System.out.println("\nLibrary invalid books: \n" + library.getInvalidBook());
		}
		
		// Test to change a User status
		System.out.println();
		System.out.print("Change a user status. Type email: ");
		String email6 = input.nextLine();
		if (userManagement.searchUser(email6) == null) {
			System.out.println("User's not found!");
		} else {
			System.out.print("Type the new user status: [0 = Inactive / 1 = Active / 2 = Vip]: ");
			int userStatus = input.nextInt();
			userManagement.changeStatus(email6, userStatus);
			System.out.println("\nUpdated data: \n\n" + userManagement.searchUser(email6));
			System.out.println("\nActive users: \n" + userManagement.showUsers());
			System.out.println("\nVip users: \n" + userManagement.showVip());
			System.out.println("\nInactive users: \n" + userManagement.getInactiveUserList());
			System.out.println("\nAll Users in register: \n" + userManagement.getUserList());
		}
		
		// Test to devolution
		input.nextLine();
		System.out.print("\nBook devolution. Type 1th book title: ");
		String titleDev = input.nextLine();
		System.out.print("\nBook devolution. Type 2nd book title: ");
		String title2Dev = input.nextLine();
		System.out.print("\nBook devolution. Type 3rd book title: ");
		String title3Dev = input.nextLine();
		
		System.out.print("\nType email user to give back the book: ");
		String email2 = input.nextLine();
		
		if (!library.devolution(titleDev, userManagement.searchUser(email), 0) ||
				!library.devolution(title2Dev, userManagement.searchUser(email), 1) ||
				!library.devolution(title3Dev, userManagement.searchUser(email), 2) ||
				userManagement.searchUser(email2) == null) {
			System.out.println("Book or user not found. Try again with book valid and user active.");
		} else {
			library.devolution(titleDev, userManagement.searchUser(email), 0);
			library.devolution(title2Dev, userManagement.searchUser(email), 1);
			library.devolution(title3Dev, userManagement.searchUser(email), 2);
			System.out.println(userManagement.searchUser(email2));
			System.out.println("\nUser borrowed books: \n" + userManagement.searchUser(email2).getUserBooks());
			System.out.println("\nLibrary book collection: \n" + library.showCollection());
			System.out.println("\nLibrary borrowed books: \n" + library.getBorrowedBooks());
			System.out.println("\nLibrary invalid books: \n" + library.getInvalidBook());
		}
		
		//exceptions test
		int option = 0;
		while (option == 0) {
			try {
				System.out.print("\nSearch a book. Type the title: ");
				String title5 = input.nextLine();
				System.out.print(library.searchBook(title5));
				
				// Test to search books by author
				System.out.print("\nBooks by author. Type an author: ");
				String author = input.nextLine();
				System.out.println(library.searchAuthor(author));
				
				// Test to search a user
				System.out.print("\nSearch a user. Type the email: ");
				String email5 = input.nextLine();
				System.out.println(userManagement.searchUser(email5));
				
				option = 1;
			} catch (LibraryException e) {
				System.out.println("Search error: " + e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Unexpected error");
			}
		}
		*/
		
		input.close();
	}
	
	public static int validateOption(int option, int limit) {
		while (option < 0 || option > limit) {
			System.out.print("Invalid option. Try again: "); 
			option = input.nextInt();
		}
		return option;
	}
	
	public static boolean hasId(List<User> user, int id) {
		User list = user.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return list != null;
	}
	
	public static boolean hasIsbn(List<Book> book, int isbn) {
		Book list = book.stream().filter(x -> x.getIsbn() == isbn).findFirst().orElse(null);
		return list != null;
	}
}