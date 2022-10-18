package com.prj.green.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prj.green.model.Flight;
import com.prj.green.response.dto.FlightDTO;

@Component
public class FlightFactory {

	public List<FlightDTO> entityToDtoList(List<Flight> flightList) {
		
		List<FlightDTO> dtoList = new ArrayList<>();
		
		flightList.forEach(x -> dtoList.add(this.entityToDto(x)));
		
		return dtoList;
		
	}
	
	public FlightDTO entityToDto(Flight fl) {
		FlightDTO flDto = new FlightDTO();
		
		flDto.setId(fl.getId());
		flDto.setFlightNumber(fl.getFlightNumber());
		flDto.setDeparturePort(fl.getDeparturePort());
		flDto.setArrivalPort(fl.getArrivalPort());
		flDto.setAirlineCode(fl.getAirlineCode());
		flDto.setDepartureTime(fl.getDepartureTime());
		flDto.setArrivalTime(fl.getArrivalTime());
		flDto.setCreatedAt(fl.getCreatedAt());
		flDto.setUpdatedAt(fl.getUpdatedAt());
		
		return flDto;
	}
}
