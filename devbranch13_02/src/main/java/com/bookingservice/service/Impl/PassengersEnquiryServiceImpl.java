package com.bookingservice.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dto.PassengersReq;
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
	public List<PassengersReq> viewpassengersWithBookId(long id) {
		
		
		 List<PassengersReq> passList=new ArrayList<PassengersReq>();
		 
		 List<BookingEntity> allBookings = bookingRepository.findAll();
		 for(BookingEntity booking : allBookings) {
			 if(booking.getId() == id) {
				 List<PassengersEntity> passengers = booking.getPassengers();
				 for(PassengersEntity p:passengers) {
					 PassengersReq pr=new PassengersReq();
					 pr.setBookingId(booking.getId());
					 pr.setFirstName(p.getFirstName());
					 pr.setMiddleName(p.getMiddleName());
					 pr.setLastName(p.getLastName());
					 pr.setEmail(p.getEmail());
					 pr.setPhoneNo(p.getPhoneNo());
					 pr.setPassengerId(p.getId());
					 passList.add(pr);
				 }
				 return passList;
			 }
		 }
		 throw new BookingIdNotFound(id); 
	}

	@Override
	public List<PassengersReq> viewAllPassengers() {
		
		List<PassengersReq> passList=new ArrayList<PassengersReq>();
		
		List<BookingEntity> allBookings = bookingRepository.findAll();
		for(BookingEntity b:allBookings) {
			List<PassengersEntity> passengers = b.getPassengers();
			 for(PassengersEntity p:passengers) {
				 PassengersReq pr=new PassengersReq();
				 pr.setBookingId(b.getId());
				 pr.setFirstName(p.getFirstName());
				 pr.setMiddleName(p.getMiddleName());
				 pr.setLastName(p.getLastName());
				 pr.setEmail(p.getEmail());
				 pr.setPhoneNo(p.getPhoneNo());
				 pr.setPassengerId(p.getId());
				 passList.add(pr);
			 }
		}
		
		return passList;
	}

}
