package com.bookingservice.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dto.BookingResponse;
import com.bookingservice.dto.PassengersReq;
import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.InventoryEntity;
import com.bookingservice.entities.PassengersEntity;
import com.bookingservice.exception.BookingIdNotFound;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.repository.InventoryRepository;
import com.bookingservice.service.BookingEnquiryService;

@Service
public class BookingEnquiryServiceImpl implements BookingEnquiryService{

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	InventoryRepository invenRepo;
	
	public List<BookingResponse> displayAllBooking() {
			List<BookingResponse> bookResponseList=new ArrayList<BookingResponse>();
			
			List<InventoryEntity> invenList=invenRepo.findAll();
			List<BookingEntity> bookList=bookingRepository.findAll();
			
			for(BookingEntity be: bookList) {
				BookingResponse br=new BookingResponse();
				br.setBookingId(be.getId());
				br.setClassName(be.getClassName());
				br.setSourceCity(be.getSource());
				br.setDestinationCity(be.getDestination());
				br.setFlightNumber(be.getFlightName());
				br.setTravelDate(be.getDepartDate().toString());
				br.setNoOfPassengers(be.getNoOfPassengers());
				br.setBookingDate(be.getCreatedDt().toString());
				for(InventoryEntity in:invenList) {
					if(in.getInventoryId()==be.getBookingInventory().getInventoryId()) {
						br.setPnrNo(in.getPnr());
						break;
					}
				}
				List<PassengersReq> passengerList=new ArrayList<PassengersReq>();
				List<PassengersEntity> pl=be.getPassengers();
				for(PassengersEntity p:pl) {
					 PassengersReq pr=new PassengersReq();
					 pr.setBookingId(be.getId());
					 pr.setFirstName(p.getFirstName());
					 pr.setMiddleName(p.getMiddleName());
					 pr.setLastName(p.getLastName());
					 pr.setEmail(p.getEmail());
					 pr.setPhoneNo(p.getPhoneNo());
					 pr.setPassengerId(p.getId());
					 passengerList.add(pr);
				 }
				br.setPassengers(passengerList);
				bookResponseList.add(br);
			}
			return bookResponseList;
	}

	@Override
	public BookingResponse findBookingById(long bookingId) {
		 Object findById = bookingRepository.findById(bookingId);
			if (findById != null) {
				BookingEntity be= (BookingEntity) findById;
				List<InventoryEntity> invenList=invenRepo.findAll();
				BookingResponse br=new BookingResponse();
				br.setBookingId(be.getId());
				br.setClassName(be.getClassName());
				br.setSourceCity(be.getSource());
				br.setDestinationCity(be.getDestination());
				br.setFlightNumber(be.getFlightName());
				br.setTravelDate(be.getDepartDate().toString());
				br.setNoOfPassengers(be.getNoOfPassengers());
				br.setBookingDate(be.getCreatedDt().toString());
				List<PassengersReq> passengerList=new ArrayList<PassengersReq>();
				List<PassengersEntity> pl=be.getPassengers();
				for(PassengersEntity p:pl) {
					 PassengersReq pr=new PassengersReq();
					 pr.setBookingId(be.getId());
					 pr.setFirstName(p.getFirstName());
					 pr.setMiddleName(p.getMiddleName());
					 pr.setLastName(p.getLastName());
					 pr.setEmail(p.getEmail());
					 pr.setPhoneNo(p.getPhoneNo());
					 pr.setPassengerId(p.getId());
					 passengerList.add(pr);
				 }
				br.setPassengers(passengerList);
				for(InventoryEntity in:invenList) {
					if(in.getInventoryId()==be.getBookingInventory().getInventoryId()) {
						br.setPnrNo(in.getPnr());
						break;
					}
				}
				return br;
			}
			else {
				throw new BookingIdNotFound(bookingId);
			}	
	}
		
}
