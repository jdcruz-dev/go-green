package com.prj.green.enums;

public enum MessageEnum {
	
	FLIGHTNOTFOUND("Flight Not Found"),
	INVALIDREQUEST("Request cannot be empty"),
	DEPARTURETIME("Invalid Departure time"),
	ARRIVALTIME("Invalid Arrival time"),
	FLIGHNUMBER("Flight number cannot be blank"),
	DEPARTUREPORT("Departure port cannot be blank"),
	ARRIVALPORT("Arrival port cannot be blank"),
	AIRLINECODE("Airline code cannot be blank"),

	SUCCESS("succes");
	
	private MessageEnum(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
