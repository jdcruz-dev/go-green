package com.prj.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prj.green.annotation.ControllerListener;
import com.prj.green.request.dto.FlightRequestDTO;
import com.prj.green.service.FlightService;

@CrossOrigin
@RestController
public class FlightController {
	
	
	private FlightService flightService;
	
	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@GetMapping(value = "/api/flights")
	public ResponseEntity<Object> getAllFlights(@RequestParam(defaultValue = "") final String airlineCode){
		return ResponseEntity.status(HttpStatus.OK).body(flightService.getAllFlights(airlineCode));

	}
	
	@PostMapping(value = "/api/flight")
	public ResponseEntity<Object> addFlight(@RequestBody FlightRequestDTO reqBody){
		return ResponseEntity.status(HttpStatus.OK).body(flightService.addFlight(reqBody));

	}
}
