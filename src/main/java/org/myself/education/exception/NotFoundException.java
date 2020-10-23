package org.myself.education.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 962108098786021758L;

	public NotFoundException(String message) {
		super(message);
	}

}
