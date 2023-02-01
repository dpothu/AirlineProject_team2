package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entities.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long>{

	public FlightEntity findByName(String flightName);
}
