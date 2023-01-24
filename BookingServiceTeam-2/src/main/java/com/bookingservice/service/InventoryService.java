package com.bookingservice.service;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.FlightEntity;
import com.bookingservice.entities.InventoryEntity;

public interface InventoryService{

	public InventoryEntity validateSeats(FlightEntity flightDetails,BookingEntity bookingDetails);

}
