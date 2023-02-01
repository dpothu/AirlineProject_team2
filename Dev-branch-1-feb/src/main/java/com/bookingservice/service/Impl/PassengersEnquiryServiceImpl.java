package com.bookingservice.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.PassengersEntity;
import com.bookingservice.exception.BookingIdNotFound;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.repository.PassengersRepository;
import com.bookingservice.service.PassengersService;

@Service
public class PassengersEnquiryServiceImpl implements PassengersService{

	@Autowired
	PassengersRepository passengersRepo;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public List<PassengersEntity> viewpassengersWithBookId(long id) {
		 List<BookingEntity> allBookings = bookingRepository.findAll();
		 for(BookingEntity booking : allBookings) {
			 if(booking.getId() == id) {
				 List<PassengersEntity> passengers = booking.getPassengers();
				 return passengers;
			 }
		 }
		 throw new BookingIdNotFound(id); 
	}

	@Override
	public Iterable<PassengersEntity> viewAllPassengers() {
		return passengersRepo.findAll();
	}

}
