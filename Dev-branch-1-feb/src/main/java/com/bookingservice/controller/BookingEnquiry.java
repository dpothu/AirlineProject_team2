package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.service.BookingEnquiryService;

@RestController
@RequestMapping("/BookingEnquiry")
public class BookingEnquiry {

	@Autowired(required=true)
	BookingEnquiryService bookingService;
	
	@RequestMapping(value = "/readAllBookings", method = RequestMethod.GET)
	public Iterable<BookingEntity> readAllBookings() {

		return bookingService.displayAllBooking();
	}
	
	@RequestMapping(value = "/searchBooking/{id}", method = RequestMethod.GET)
	public BookingEntity searchBookingByID(@PathVariable("id") long id) {

		return bookingService.findBookingById(id);
	}
}
