package com.bookingservice.service;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookingResponse;
import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.InventoryEntity;

public interface BookingService {

	
	public BookingResponse newBooking(BookMainReq bookData);
	public BookingResponse bookingResponse(BookingEntity bookDataForResponse, InventoryEntity inven);
	
	
}