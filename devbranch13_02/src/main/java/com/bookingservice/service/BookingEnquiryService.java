package com.bookingservice.service;

import java.util.List;

import com.bookingservice.dto.BookingResponse;

public interface BookingEnquiryService {

	public List<BookingResponse> displayAllBooking();
	public BookingResponse findBookingById(long bookingId);
}
