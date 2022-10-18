package com.prj.green.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.green.dao.FlightDao;
import com.prj.green.enums.MessageEnum;
import com.prj.green.exception.badreq.FlightBadRequestServiceException;
import com.prj.green.exception.notfound.FlightNotFoundServiceException;
import com.prj.green.factory.FlightFactory;
import com.prj.green.model.Flight;
import com.prj.green.request.dto.FlightRequestDTO;
import com.prj.green.response.dto.FlightDTO;
import com.prj.green.response.dto.FlightsDTO;
import com.prj.green.service.FlightService;
import com.prj.green.util.DateUtil;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDao flightDao;

	@Autowired
	private FlightFactory flightFactory;
	
	@Override
	public FlightsDTO getAllFlights(String airlineCode) {
	
		FlightsDTO flightsRespDto = new FlightsDTO();
		
		List<Flight> flights = new ArrayList<>();
		
		if(!"".equals(airlineCode)) {
			flights = flightDao.getAllFlightsByAirlineCode(airlineCode.toUpperCase());
		} else {
			flights = flightDao.getAllFlights();
		}
		
		if(Objects.isNull(flights)) {
			throw new FlightNotFoundServiceException(MessageEnum.FLIGHTNOTFOUND.getMessage());
		}
		
		flightsRespDto.setFlights(flightFactory.entityToDtoList(flights));
		
		return flightsRespDto; 
	}

	@Override
	public FlightDTO addFlight(FlightRequestDTO reqDto) {
		
		if(Objects.isNull(reqDto)) {
			throw new FlightBadRequestServiceException(MessageEnum.INVALIDREQUEST.getMessage());
		}
		
		//validate request
		validateInput(reqDto);
		
		LocalDateTime convertedDepartureTime = DateUtil.convertStringToLocalDateTime(reqDto.getDepartureTime());
		LocalDateTime convertedArrivalTime = DateUtil.convertStringToLocalDateTime(reqDto.getArrivalTime());
		
		
		if(Objects.isNull(convertedDepartureTime)) {
			throw new FlightBadRequestServiceException(MessageEnum.DEPARTURETIME.getMessage());
		}
		
		if(Objects.isNull(convertedArrivalTime)) {
			throw new FlightBadRequestServiceException(MessageEnum.ARRIVALTIME.getMessage());
		}
		
		
		//validate if flight is exist
		
		//valid request
		
		Flight newFlight = new Flight();
		newFlight.setId(UUID.randomUUID());
		newFlight.setFlightNumber(reqDto.getFlightNumber());
		newFlight.setDeparturePort(reqDto.getDeparturePort());
		newFlight.setArrivalPort(reqDto.getArrivalPort());
		newFlight.setAirlineCode(reqDto.getAirlineCode());
		newFlight.setDepartureTime(convertedDepartureTime);
		newFlight.setArrivalTime(convertedArrivalTime);
//		newFlight.setDepartureTime(LocalDateTime.now());
//		newFlight.setArrivalTime(LocalDateTime.now());
		newFlight.setCreatedAt(LocalDateTime.now());
		newFlight.setUpdatedAt(LocalDateTime.now());
		
		Flight adedFlight = flightDao.addFligt(newFlight);
		
		return flightFactory.entityToDto(adedFlight);
		
	}
	
	private void validateInput(FlightRequestDTO reqDto) {
		if(reqDto.getDepartureTime() == null || "".equals(reqDto.getDepartureTime())) {
			throw new FlightBadRequestServiceException(MessageEnum.DEPARTURETIME.getMessage());
		}
		
		if(reqDto.getArrivalTime() == null || "".equals(reqDto.getArrivalTime())) {
			throw new FlightBadRequestServiceException(MessageEnum.ARRIVALTIME.getMessage());
		}
		if(reqDto.getFlightNumber() == null || "".equals(reqDto.getFlightNumber())) {
			throw new FlightBadRequestServiceException(MessageEnum.FLIGHNUMBER.getMessage());
		}
		
		if(reqDto.getDeparturePort() == null || "".equals(reqDto.getDeparturePort())) {
			throw new FlightBadRequestServiceException(MessageEnum.DEPARTUREPORT.getMessage());
		}
		if(reqDto.getAirlineCode() == null || "".equals(reqDto.getAirlineCode())) {
			throw new FlightBadRequestServiceException(MessageEnum.AIRLINECODE.getMessage());
		}
		
		if(reqDto.getArrivalPort() == null || "".equals(reqDto.getArrivalPort())) {
			throw new FlightBadRequestServiceException(MessageEnum.ARRIVALPORT.getMessage());
		}
	}

}
