package com.bookingservice.service.Impl;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.FlightEntity;
import com.bookingservice.entities.InventoryEntity;
import com.bookingservice.exception.SeatsNotAvailable;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.repository.FlightRepository;
import com.bookingservice.repository.InventoryRepository;
import com.bookingservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	FlightRepository flightRepo;

	@Autowired
	InventoryEntity inven;
	
	Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
	
	@Override
	public InventoryEntity validateSeats(FlightEntity flightDetails, BookingEntity bookingDetails) {
		
		logger.info("Inventory Service implementation Validating seats starts: ");
		if(flightDetails.getEmptyseats()>=bookingDetails.getNoOfPassengers()){
			flightDetails.setEmptyseats(flightDetails.getEmptyseats()-bookingDetails.getNoOfPassengers());
			flightDetails.setFilledseats(flightDetails.getFilledseats()+bookingDetails.getNoOfPassengers());
			flightRepo.saveAndFlush(flightDetails);
		}
		else{
			logger.error("Inventory Service implementation Validating seats ends: unsufficient seats issue");
			throw new SeatsNotAvailable(bookingDetails.getNoOfPassengers(),flightDetails.getEmptyseats());
		}
		logger.info("Inventory Service implementation Validating seats ends: ");
		return this.setDataToInven(flightDetails, bookingDetails);
	}

	public InventoryEntity setDataToInven(FlightEntity flightDetails, BookingEntity bookingDetails) {
		
		logger.info("Inventory Service implementation setDataToInventory starts: ");
		Random random = new Random();
		long pnrLong = random.nextInt(999999,9999999);
		String pnrString = Long.toString(pnrLong);
		inven.setFlightId(flightDetails.getId());
		inven.setFlightName(flightDetails.getName());
		inven.setInvoice(bookingDetails.getFareAmount());
		inven.setJourneyToGo(this.setToGoDays(inven,bookingDetails));
		if(bookingDetails.getFareAmount() != 0.0) {
			bookingDetails.setStatus("Booking is successful");
			inven.setPnr(pnrString);
			logger.info("Inventory Service implementation PNR is generated: ");
			inven.setStatus(bookingDetails.getStatus());
			
		}
		else {
			bookingDetails.setStatus("Booking is on hold, Pending with fare");
			inven.setStatus(bookingDetails.getStatus());
			logger.error("Inventory Service implementation PNR is not generated: ");
			inven.setPnr("Not Yet Generated");
		}
		inven.setInventoryId(0);
		logger.info("Inventory Service implementation setDataToInventory ends: ");
		return inven;
	}
	
	@SuppressWarnings("deprecation")
	public String setToGoDays(InventoryEntity inven, BookingEntity bookingEntity) {
		
		logger.info("Inventory Service implementation setToGoDays starts: ");
		Date todaydate = new Date();
		Calendar myNextCalender = Calendar.getInstance();
		int day = bookingEntity.getDepartDate().getDate();
		int month = bookingEntity.getDepartDate().getMonth();
		Instant yearInstant = bookingEntity.getDepartDate().toInstant();
		int year = Integer.parseInt(yearInstant.toString().substring(0, 4));
		myNextCalender.set(year, month, day);
		Date nyd = myNextCalender.getTime();
		long days = daysBetween(todaydate,nyd);
		logger.info("Inventory Service implementation setToGoDays ends: ");
		return days+" days - to go for departure";
	}
	
	public long daysBetween(Date today, Date nyd) {
		long difference = (today.getTime()-nyd.getTime())/86400000; //86400000 millisec per day
		return Math.abs(difference);
	}

	@Override
	public Iterable<InventoryEntity> viewAllInven() {
		return inventoryRepository.findAll();
	}
	
}