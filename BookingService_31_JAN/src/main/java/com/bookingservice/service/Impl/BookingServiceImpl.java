package com.bookingservice.service.Impl;

import java.time.LocalTime;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.repository.BookingRepository;
import com.bookingservice.repository.FlightRepository;
import com.bookingservice.repository.InventoryRepository;
import com.bookingservice.service.BookingService;
import com.bookingservice.service.InventoryService;
import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookMainResponse;
import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.FlightEntity;
import com.bookingservice.entities.InventoryEntity;
import com.bookingservice.entities.PassengersEntity;
import com.bookingservice.exception.CheckArrAndDepartDate;
import com.bookingservice.exception.CheckArrAndDepartTime;
import com.bookingservice.exception.CheckDepartDate;
import com.bookingservice.exception.CheckDepartTime;
import com.bookingservice.exception.CheckSourceAndDestination;
import com.bookingservice.exception.FlightDoesNotExits;
import com.bookingservice.exception.PassengerCountDetails;


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
	
	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	int seatCount=1;
	@SuppressWarnings("deprecation")
	@Override
	public BookMainResponse newBooking(BookMainReq bookData) {
		
		logger.info("Booking service implementation new booking starts: ");
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
		if(allFlight.contains(booking.getBookingFlight())) {
			
			if(booking.getNoOfPassengers()!=booking.getPassengers().size()) {
				throw new PassengerCountDetails(booking.getNoOfPassengers(),booking.getPassengers().size());
			}
			if(booking.getSource().equalsIgnoreCase(booking.getDestination())) {
				throw new CheckSourceAndDestination();
			}
			Date currDate = new Date();
			LocalTime currTime= LocalTime.now();
			if(booking.getDepartDate().before(currDate)) {
				if(booking.getDepartDate().getDate()!=currDate.getDate()) {
					throw new CheckDepartDate();
					}
				else {
					if(booking.getDepartTime().isBefore(currTime)) {
						throw new CheckDepartTime();
					}
			 	
			 	}
			}
			if(booking.getArrDate().equals(booking.getDepartDate()) && booking.getArrTime().compareTo(booking.getDepartTime())<0) {
				throw new CheckArrAndDepartTime(booking.getArrTime(),booking.getDepartTime());
			}
			if(booking.getArrDate().before(booking.getDepartDate())) {
				throw new CheckArrAndDepartDate(booking.getArrDate(),booking.getDepartDate());
			}
			invenData = invenRepo.save(inven);
			booking.setBookingInventory(invenData);
			
			if(booking.getPassengers() != null) {
				List<PassengersEntity> peList = booking.getPassengers();
				for(PassengersEntity pe : peList) {
					pe.setSeatNo(seatCount);
					seatCount++;
				}
				booking.setPassengers(peList);
			}
			bookDataForResponse = bookingRepository.save(booking);
			logger.info("Booking service implementation new booking saved to database: ");
		}else {
			logger.error("Booking service implementation new booking ends: flightName issues");
			throw new FlightDoesNotExits(booking.getFlightName());
		}
		logger.info("Booking service implementation new booking ends: ");
		return this.bookingResponse(bookDataForResponse,invenData);
	}
	
	public BookMainResponse bookingResponse(BookingEntity bookDataForResponse,InventoryEntity invenData) {
		
		logger.info("Booking service implementation Booking response starts: ");
		bookResponse.setBookingId(bookDataForResponse.getId());
		bookResponse.setFlightId(bookDataForResponse.getBookingFlight().getId());
		bookResponse.setInventoryId(invenData.getInventoryId());
		bookResponse.setNumberOfPassengers(bookDataForResponse.getNoOfPassengers());
		bookResponse.setPnrNumber(invenData.getPnr());
		bookResponse.setFlightName(bookDataForResponse.getFlightName());
		bookResponse.setBookingStatus("***Booking is successful for this request***");
		logger.info("Booking service implementation Booking response ends: ");
		return bookResponse;
	}

}