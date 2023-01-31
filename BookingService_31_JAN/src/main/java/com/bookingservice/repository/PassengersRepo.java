package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entities.PassengersEntity;

@Repository
public interface PassengersRepo extends JpaRepository<PassengersEntity, Integer>{

	//@Query 
	//public void saveAll(List<PassengersChnlRequest> passList);

}
