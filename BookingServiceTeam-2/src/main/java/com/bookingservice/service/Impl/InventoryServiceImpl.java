package com.bookingservice.service.Impl;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.FlightEntity;
import com.bookingservice.entities.InventoryEntity;
import com.bookingservice.exception.SeatsNotAvailable;
import com.bookingservice.repository.FlightRepository;
import com.bookingservice.repository.InventoryRepository;
import com.bookingservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	FlightRepository flightRepo;

	@Autowired
	InventoryEntity inven;
	@Override
	public InventoryEntity validateSeats(FlightEntity flightDetails, BookingEntity bookingDetails) {
		if(flightDetails.getEmptyseats()>=bookingDetails.getNoOfPassengers()){
			flightDetails.setEmptyseats(flightDetails.getEmptyseats()-bookingDetails.getNoOfPassengers());
			flightDetails.setFilledseats(flightDetails.getFilledseats()+bookingDetails.getNoOfPassengers());
			flightRepo.saveAndFlush(flightDetails);
		}
		else{
			throw new SeatsNotAvailable(bookingDetails.getNoOfPassengers(),flightDetails.getEmptyseats());
		}
		
		return this.setDataToInven(flightDetails, bookingDetails);
	}

	public InventoryEntity setDataToInven(FlightEntity flightDetails, BookingEntity bookingDetails) {
		Random random = new Random();
		long pnrLong = random.nextInt(9999999,99999999);
		String pnrString = Long.toString(pnrLong);
		inven.setFlightId(flightDetails.getId());
		inven.setFlightName(flightDetails.getName());
		inven.setInvoice(bookingDetails.getFareAmount());
		inven.setJourneyToGo(this.setToGoDays(inven,bookingDetails));
		if(bookingDetails.getFareAmount() != 0.0) {
			bookingDetails.setStatus("Booking is successful");
			inven.setPnr(pnrString);
			inven.setStatus(bookingDetails.getStatus());
			
		}
		else {
			bookingDetails.setStatus("Booking is on hold, Pending with fare");
			inven.setStatus(bookingDetails.getStatus());
			inven.setPnr("Not Yet Generated");
		}
		return inven;
	}
	
	public String setToGoDays(InventoryEntity inven, BookingEntity bookingEntity) {
		Date todaydate = new Date();
		Calendar myNextCalender = Calendar.getInstance();
		int day = bookingEntity.getDepartDate().getDate();
		int month = bookingEntity.getDepartDate().getMonth();
		Instant yearInstant = bookingEntity.getDepartDate().toInstant();
		int year = Integer.parseInt(yearInstant.toString().substring(0, 4));
		myNextCalender.set(year, month, day);
		Date nyd = myNextCalender.getTime();
		long days = daysBetween(todaydate,nyd);
		return days+" days - to go for departure";
	}
	
	public long daysBetween(Date today, Date nyd) {
		long difference = (today.getTime()-nyd.getTime())/86400000; //86400000 millisec per day
		return Math.abs(difference);
	}
	
}
