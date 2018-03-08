package com.example.demo.exception;

/**
 * Customizing Return Status for a Specific Exception
 * 
 * @author
 *
 */
//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}

	protected EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
