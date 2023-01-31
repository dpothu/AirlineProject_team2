package com.bookingservice.service;

import com.bookingservice.dto.BookMainReq;
import com.bookingservice.dto.BookMainResponse;
import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.InventoryEntity;

public interface BookingService {

	
	public BookMainResponse newBooking(BookMainReq bookData);
	public BookMainResponse bookingResponse(BookingEntity bookDataForResponse, InventoryEntity inven);
	
}