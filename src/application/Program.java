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
					int optionTwo = -1;
					do {
						switch (option) {
						case 1:
							System.out.println("\n### WELCOME TO THE LIBRARY ###");
							System.out.print("\nMenu: \n"
									+ "[1] Add book\n[2] Show collection\n[3] Search book\n[4] Search by author\n"
									+ "[5] Book loan\n[6] Book return\n[0] Return to previous menu\n");
							System.out.print("\nChoose an option: ");
							optionTwo = input.nextInt();
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
											+ "[3] Show all books\n[0] Return to previousl menu\n");
									System.out.print("\nChoose an option: ");
									optionThree = input.nextInt();
									if (optionThree != 0) {	
										optionThree = validateOption(optionThree, 3);
										if (optionThree == 1) {
											System.out.println("\n### Available books ###\n" + library.showCollection());
										} else if (optionThree == 2) {
											System.out.println("\n### Unavailable books ###\n");
											System.out.println("\nInvalid books\n" + library.getInvalidBook());
											System.out.println("\nBorrowed books\n" + library.getBorrowedBooks());
										} else {
											System.out.println("\n### All library books ###\n" + library.getBookList() + library.getBorrowedBooks());
										}
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
							case 6:
								System.out.println("\n### BOOK RETURN ###");
								System.out.print("\nPlease, type the title book to return: ");
								input.nextLine();
								String titleReturn = input.nextLine();
								library.searchBorrowedBook(titleReturn);
								System.out.print("\nEnter the user's email for the loan: ");
								String emailReturn = input.nextLine();
								userManagement.searchUser(emailReturn);
								System.out.print("\nWhat is the book's condition? [0 - Invalid] / [1 - Bad] / [2 - Good]: ");
								int bookState = input.nextInt();
								while (bookState < 0 || bookState > 3) {
									System.out.print("\nInvalid state! Try again [0 - Invalid] / [1 - Bad] / [2 - Good]: ");
									bookState = input.nextInt();
								}
								if (library.devolution(titleReturn, userManagement.searchUser(emailReturn), bookState)) {
									System.out.println("\nUpdated User books: \n" + userManagement.searchUser(emailReturn).getUserBooks());
									System.out.println("\nUpdated Library avaliable books: \n" + library.showCollection());
								}
								break;
							default:
								break;
							}
						}
					}	while (optionTwo != 0);
				} else if (option == 2) {
					int optionFour = -1;
					do {
						System.out.println("\n### WELCOME TO THE USER REGISTRATION ###");
						System.out.print("\nMenu: \n"
								+ "[1] Add user\n[2] Show users\n[3] Search user\n[4] Update users\n[0] Return to previous menu\n");
						System.out.print("\nChoose an option: ");
						optionFour = input.nextInt();
						optionFour = validateOption(optionFour, 4);
						
						switch (optionFour) {
						case 1:
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
							System.out.println("\nDone!");
							break;
						case 2:
							int optionFive = -1;
							do {
								
								System.out.println("\n### USER RECORDS ###");
								System.out.print("\n[1] Show regular users\n[2] Show vip users\n"
										+ "[3] Show inactive users\n[4] Show all users\n[0] Return to previous menu\n");
								System.out.print("\nChoose an option: ");
								optionFive = input.nextInt();
								if (optionFive != 0) {
									optionFive = validateOption(optionFive, 4);
									if (optionFive == 1) {
										System.out.println("\nActive users: \n" + userManagement.showUsers());
									} else if (optionFive == 2) {
										System.out.println("\nJust vip users: \n" + userManagement.showVip());
									} else if (optionFive == 3) {
										System.out.println("\nInactive users: \n" + userManagement.getInactiveUserList());
									} else {
										System.out.println("\nAll users: \n" + userManagement.getUserList());
									}
								}
							} while (optionFive != 0);
							break;
						case 3:
							System.out.println("\n### SEARCHING A USER ###");
							System.out.print("\nPlease, type the user email: ");
							input.nextLine();
							String emailSearch = input.nextLine();
							System.out.println("### Search results ###\n" + userManagement.searchUser(emailSearch));
							System.out.printf("\n%s borrowed books: \n%s", userManagement.searchUser(emailSearch).getName(), 
									userManagement.searchUser(emailSearch).getUserBooks());
							break;
						case 4:
							System.out.println("\n### UPDATING USERS ###");
							System.out.print("\nEnter the user's email: ");
							input.nextLine();
							String updateEmail = input.nextLine();
							userManagement.searchUser(updateEmail);
							User userToUpdate = new User();
							userToUpdate = userManagement.searchUser(updateEmail);
							System.out.print("\n[1] Update email\n[2] Update phonne number\n"
									+ "[3] Change user status\n[0] Return to previous menu\n");
							System.out.print("\nChoose an option: ");
							int optionSix = input.nextInt();
							if (optionSix != 0) {	
								optionSix = validateOption(optionSix, 3);
								if (optionSix == 1) {
									input.nextLine();
									System.out.print("\nType new email: ");
									String newEmail = input.nextLine();
									userToUpdate.setEmail(newEmail);
									System.out.println("\nUpdate data: " + userManagement.searchUser(newEmail));
								} else if (optionSix == 2) {
									input.nextLine();
									System.out.print("\nType new phonne number: ");
									String newPhonne = input.nextLine();
									userToUpdate.setPhonne(newPhonne);
									System.out.println("\nDone!");
									System.out.println("\nUpdate data: " + userManagement.searchUser(updateEmail));
								} else {
									System.out.print("\nType new status [0 - Inactive] / [1 - Active] / [2 - Vip]: ");
									int newStatus = input.nextInt();
									userManagement.changeStatus(updateEmail, newStatus);
									System.out.println("\nDone!");
									System.out.println("\nUpdate data: " + userManagement.searchUser(updateEmail));
								}
							}							
							break;
						default:
							break;
						}
					} while (optionFour != 0);
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