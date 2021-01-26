package org.sb.examples.exceptions;

public class NotPrivilegedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotPrivilegedException() {
		super();
	}

	public NotPrivilegedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotPrivilegedException(String message) {
		super(message);
	}

	public NotPrivilegedException(Throwable cause) {
		super(cause);
	}

}
