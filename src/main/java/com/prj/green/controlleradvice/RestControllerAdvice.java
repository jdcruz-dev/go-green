package com.prj.green.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prj.green.exception.badreq.FlightBadRequestServiceException;
import com.prj.green.exception.notfound.FlightNotFoundServiceException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

	private final String errorMsg = "Opps something went wrong!";
	
	@ExceptionHandler({FlightNotFoundServiceException.class})
	public ResponseEntity<Object> notFoundException(HttpServletRequest request, Exception ex, WebRequest webRequest) {
		Map<String, Object> errorResp = new HashMap<>();
		errorResp.put("message", ex.getMessage());
		return  ResponseEntity.status(404).body(errorResp);
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
		Map<String, Object> errorResp = new HashMap<>();
		errorResp.put("message", this.errorMsg);
		return ResponseEntity.status(500).body(errorResp);
	}
	
	@ExceptionHandler({com.prj.green.exception.notfound.UnhandledServiceException.class})
	public ResponseEntity<Object> internalServerException(HttpServletRequest request, Exception ex, WebRequest webRequest) {
		Map<String, Object> errorResp = new HashMap<>();
		errorResp.put("message", this.errorMsg);
		return ResponseEntity.status(500).body(errorResp);
	}


	@ExceptionHandler({FlightBadRequestServiceException.class,})
	public ResponseEntity<Object> badRequestException(HttpServletRequest request, Exception ex, WebRequest webRequest) {
		Map<String, Object> errorResp = new HashMap<>();
		errorResp.put("message", ex.getMessage());
		return  ResponseEntity.status(400).body(errorResp);
	}
}