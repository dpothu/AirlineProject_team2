package com.bookingservice.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.entities.BookingEntity;

@Service
public class FareValidateService {
	
	Logger logger = LoggerFactory.getLogger(FareValidateService.class);
	
	public int validatingFare(BookMainReq bookingData) {
		logger.info("Fare Service Validating fare starts: ");
		BookingEntity bookData = bookingData.setBookingDetails();
		double getFare = bookData.getFareAmount();
		if(getFare == 0.0) {
			logger.error("Fare Service Validating fare ends: occurs fare issues");
			return 0;
		}
		logger.info("Fare Service Validating fare ends: ");
		return 1;
	}
}