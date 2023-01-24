package com.bookingservice.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookMainResponse;
import com.bookingservice.entities.BookingEntity;
import com.bookingservice.exception.FareNotPresent;
import com.bookingservice.service.BookingService;
import com.bookingservice.service.Impl.FareValidateService;

@RestController
@RequestMapping("/bookingservice")
public class BookingController {

	@Autowired(required = true)
	BookingService bookingService;
	
	@Autowired(required = true)
	FareValidateService fareChecking;
	
	BookMainResponse bookResponse;

	@PostMapping
	@RequestMapping(value = "/newbooking")
	public ResponseEntity<BookMainResponse> newBooking(@RequestBody BookMainReq BookingData) {
		int fareResult = fareChecking.validatingFare(BookingData);
		if(fareResult == 1) {
			bookResponse = bookingService.newBooking(BookingData);
		}
		else {
			bookResponse = bookingService.newBooking(BookingData);
			throw new FareNotPresent("The given data did not have fare amount or it is 0.0, Details are saved in Records as 'Status : Pending with Fare amount'");
		}
		
		return new ResponseEntity<BookMainResponse>(bookResponse,HttpStatus.OK);
	}
}
