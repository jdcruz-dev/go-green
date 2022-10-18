package com.prj.green.dao;

import java.util.List;

import com.prj.green.model.Flight;
import com.prj.green.response.dto.FlightDTO;

public interface FlightDao {

	public List<Flight> getAllFlights();
	public List<Flight> getAllFlightsByAirlineCode(String airlineCode);
	public Flight addFligt(Flight flight);

}
