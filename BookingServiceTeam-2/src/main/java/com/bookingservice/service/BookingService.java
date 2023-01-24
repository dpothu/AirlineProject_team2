package com.bookingservice.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookMainResponse;
import com.bookingservice.entities.BookingEntity;
//import com.bookingservice.model.FareDetails;
import com.bookingservice.entities.InventoryEntity;

public interface BookingService {

	
	public BookMainResponse newBooking(BookMainReq bookData);
	public BookMainResponse bookingResponse(BookingEntity bookDataForResponse, InventoryEntity inven);
	
}
