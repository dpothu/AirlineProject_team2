package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entities.PassengersEntity;

@Repository
public interface PassengersRepository extends JpaRepository<PassengersEntity, Integer>{

	//@Query("SELECT ps FROM PassengersEntity ps WHERE ps.passengers=?1")
	//public List<PassengersEntity> getPassengersWithBookId(long id);

}
