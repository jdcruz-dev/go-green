package com.prj.green.service;

import com.prj.green.request.dto.FlightRequestDTO;
import com.prj.green.response.dto.FlightDTO;
import com.prj.green.response.dto.FlightsDTO;

public interface FlightService {

	public FlightsDTO getAllFlights(String airlineCodeString);
	public FlightDTO addFlight(FlightRequestDTO reqDTO);
	
}
