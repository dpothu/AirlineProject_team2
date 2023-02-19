package com.bookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.dto.PassengersReq;
import com.bookingservice.service.PassengersService;


@RestController
@RequestMapping("/PassengerEnquiry")
public class PassengerEnquiry {

	@Autowired(required = true)
	PassengersService passengersService;
	
	
	@RequestMapping(value = "/allPassengers",method = RequestMethod.GET)
	public List<PassengersReq> viewAllPassengers() {
		return passengersService.viewAllPassengers();
	}

	@RequestMapping(value = "/PassengersWithBookId/{id}", method = RequestMethod.GET)
	public List<PassengersReq> passengersWithBookId(@PathVariable("id") long id) {
		return passengersService.viewpassengersWithBookId(id);
	}
}
