package com.bookingservice.service;

import com.bookingservice.entities.BookingEntity;

public interface BookingEnquiryService {

	public Iterable<BookingEntity> displayAllBooking();
	public BookingEntity findBookingById(long bookingId);
}
