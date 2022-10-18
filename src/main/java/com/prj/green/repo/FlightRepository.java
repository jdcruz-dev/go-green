package com.prj.green.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prj.green.model.Flight;

public interface FlightRepository extends CrudRepository<Flight, UUID> {

    @Query("select e from #{#entityName} e where e.deletedAt is null")
    List<Flight> findAllFlights();
    
    @Query("select e from #{#entityName} e where e.airlineCode=?1 and e.deletedAt is null")
    List<Flight> findAllFlightsByAirlineCode(String airlineCode);
}
