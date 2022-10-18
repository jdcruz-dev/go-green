package com.prj.green.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FlightNotFoundServiceException extends HandledServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1968918263161834660L;

	public FlightNotFoundServiceException() {
		super();
	}

	public FlightNotFoundServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	public FlightNotFoundServiceException(String message) {
		super(message);
		
	}
	
	public FlightNotFoundServiceException(Throwable cause) {
		super(cause);
		
	}
}
