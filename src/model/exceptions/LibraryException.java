package model.exceptions;

public class LibraryException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LibraryException(String msg) {
		super(msg);
	}
}