package com.bookingservice.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.entities.BookingEntity;

@Service
public class FareValidateService {
	
	public int validatingFare(BookMainReq bookingData) {
		BookingEntity bookData = bookingData.getBookingData();
		double getFare = bookData.getFareAmount();
		if(getFare == 0.0) {
			return 0;
		}
		return 1;
	}
}
