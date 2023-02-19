package com.bookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.dto.BookingResponse;
import com.bookingservice.service.BookingEnquiryService;

@RestController
@RequestMapping("/BookingEnquiry")
public class BookingEnquiry {

	@Autowired(required=true)
	BookingEnquiryService bookingService;
	
	@RequestMapping(value = "/readAllBookings", method = RequestMethod.GET)
	public List<BookingResponse> readAllBookings() {

		return bookingService.displayAllBooking();
	}
	
	@RequestMapping(value = "/searchBooking/{id}", method = RequestMethod.GET)
	public BookingResponse searchBookingByID(@PathVariable("id") long id) {

		return bookingService.findBookingById(id);
	}
}
