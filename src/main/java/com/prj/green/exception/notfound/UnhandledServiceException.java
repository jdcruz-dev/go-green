package com.prj.green.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class UnhandledServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4616527869304225149L;

	public UnhandledServiceException() {
		super();
	}

	public UnhandledServiceException(String message) {
		super(message);
	}

	public UnhandledServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnhandledServiceException(Throwable cause) {
		super(cause);
	}
}
