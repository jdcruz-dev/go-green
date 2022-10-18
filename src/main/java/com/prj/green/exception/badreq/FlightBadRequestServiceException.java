package com.prj.green.exception.badreq;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.BAD_REQUEST)
public class FlightBadRequestServiceException extends HandledBadRequestServiceException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5234110458813032313L;

	public FlightBadRequestServiceException() {
		super();
	}
	
	public FlightBadRequestServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FlightBadRequestServiceException(String message) {
		super(message);
	}
	
	public FlightBadRequestServiceException(Throwable cause ) {
		super(cause);
	}

}
