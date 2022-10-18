package com.prj.green.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prj.green.dao.FlightDao;
import com.prj.green.model.Flight;
import com.prj.green.repo.FlightRepository;

@Repository
public class FlightDaoImpl implements FlightDao {

	@Autowired
	private FlightRepository flightRepo;
	
	@Override
	public List<Flight> getAllFlights() {
		
		return flightRepo.findAllFlights();
		
	}

	@Override
	public Flight addFligt(Flight flight) {
		
		return flightRepo.save(flight);
		
	}

	@Override
	public List<Flight> getAllFlightsByAirlineCode(String airlineCode) {	
		return flightRepo.findAllFlightsByAirlineCode(airlineCode);
	}
}
