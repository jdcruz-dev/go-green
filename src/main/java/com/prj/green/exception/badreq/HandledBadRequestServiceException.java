package com.prj.green.exception.badreq;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class HandledBadRequestServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 290716482714725303L;

	public HandledBadRequestServiceException() {
		super();
	}

	public HandledBadRequestServiceException(String message) {
		super(message);
	}

	public HandledBadRequestServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public HandledBadRequestServiceException(Throwable cause) {
		super(cause);
	}
}