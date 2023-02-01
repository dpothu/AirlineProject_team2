package com.bookingservice.service;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.FlightEntity;
import com.bookingservice.entities.InventoryEntity;

public interface InventoryService{

	public InventoryEntity validateSeats(FlightEntity flightDetails,BookingEntity bookingDetails);

	public Iterable<InventoryEntity> viewAllInven();

}