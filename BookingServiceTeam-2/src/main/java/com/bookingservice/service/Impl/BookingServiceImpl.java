package com.bookingservice.service.Impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookingservice.repository.BookingRepository;
import com.bookingservice.repository.FlightRepository;
import com.bookingservice.repository.InventoryRepository;
import com.bookingservice.repository.PassengersRepo;
import com.bookingservice.service.BookingService;
import com.bookingservice.service.InventoryService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookMainResponse;
import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.FlightEntity;
import com.bookingservice.entities.InventoryEntity;
import com.bookingservice.entities.PassengersEntity;
import com.bookingservice.exception.FareNotPresent;
import com.bookingservice.exception.FlightDoesNotExits;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	FlightRepository flightRepo;

	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	InventoryRepository invenRepo;
	
	@Autowired
	BookMainResponse bookResponse;
	
	@Autowired
	InventoryEntity invenData;
	
	@Autowired
	InventoryEntity inven;
	
	@Override
	public BookMainResponse newBooking(BookMainReq bookData) {
		
		BookingEntity booking = bookData.getBookingData();
		BookingEntity bookDataForResponse;
		List<FlightEntity> allFlight = flightRepo.findAll();
		for(FlightEntity singleFlight : allFlight) {
			if(booking.getFlightName().equalsIgnoreCase(singleFlight.getName())) {
				
				inven = inventoryService.validateSeats(singleFlight, booking);
				Date date = new Date();
				booking.setCreatedDt(date);
				booking.setUpdated_By("Teja");
				booking.setBookingFlight(singleFlight);
			}
		}
		if(booking.getBookingFlight() != null) {
			invenData = invenRepo.save(inven);
			booking.setBookingInventory(invenData);
			bookDataForResponse = bookingRepository.save(booking);
		}else {
			throw new FlightDoesNotExits(booking.getFlightName());
		}
		
		return this.bookingResponse(bookDataForResponse,invenData);
	}
	
	public BookMainResponse bookingResponse(BookingEntity bookDataForResponse,InventoryEntity invenData) {
		bookResponse.setBookingId(bookDataForResponse.getId());
		bookResponse.setFlightId(bookDataForResponse.getBookingFlight().getId());
		bookResponse.setInventoryId(invenData.getInventoryId());
		bookResponse.setNumberOfPassengers(bookDataForResponse.getNoOfPassengers());
		bookResponse.setPnrNumber(invenData.getPnr());
		bookResponse.setFlightName(bookDataForResponse.getFlightName());
		bookResponse.setBookingStatus("***Booking is successful for this request***");
		return bookResponse;
	}

}