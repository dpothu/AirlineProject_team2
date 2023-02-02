package com.bookingservice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.exception.BookingIdNotFound;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.service.BookingEnquiryService;

@Service
public class BookingEnquiryServiceImpl implements BookingEnquiryService{

	@Autowired
	BookingRepository bookingRepository;
	
	public Iterable<BookingEntity> displayAllBooking() {
		
			return bookingRepository.findAll();
	}

	@Override
	public BookingEntity findBookingById(long bookingId) {
		 Object findById = bookingRepository.findById(bookingId);
			if (findById != null) {
				return (BookingEntity) findById;
			}
			else {
				throw new BookingIdNotFound(bookingId);
			}	
	}
		
}
