package com.prj.green.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HandledServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 290716482714725303L;

	public HandledServiceException() {
		super();
	}

	public HandledServiceException(String message) {
		super(message);
	}

	public HandledServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public HandledServiceException(Throwable cause) {
		super(cause);
	}
}