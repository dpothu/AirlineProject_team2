package com.bookingservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookMainResponse;
import com.bookingservice.exception.FareNotPresent;
import com.bookingservice.service.BookingService;
import com.bookingservice.service.Impl.FareValidateService;

@RestController
@RequestMapping("/bookingservice")
public class BookFlight {

	@Autowired(required = true)
	BookingService bookingService;
	
	@Autowired(required = true)
	FareValidateService fareChecking;
	
	BookMainResponse bookResponse;

	Logger logger = LoggerFactory.getLogger(BookFlight.class);
	
	//Creating new Booking to the flight
	@PostMapping
	@RequestMapping(value = "/newbooking",method = RequestMethod.POST)
	public ResponseEntity<BookMainResponse> newBooking(@RequestBody BookMainReq BookingData) {
		logger.info("calling controller and new booking is start: ");
		int fareResult = fareChecking.validatingFare(BookingData);
		if(fareResult == 1) {
			bookResponse = bookingService.newBooking(BookingData);
			logger.info("new booking is successfull: ");
		}
		else {
			bookResponse = bookingService.newBooking(BookingData);
			logger.error("new booking is on hold because of fare issues: ");
			throw new FareNotPresent("The given data did not have fare amount or it is 0.0, Details are saved in Records as 'Status : Pending with Fare amount'");
		}
		logger.info("In controller new booking is end: ");
		return new ResponseEntity<BookMainResponse>(bookResponse,HttpStatus.OK);
	}
	
}