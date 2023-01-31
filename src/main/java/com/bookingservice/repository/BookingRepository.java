package com.bookingservice.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entities.BookingEntity;
//import com.bookingservice.model.FareDetails;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, BigInteger> {

//	public void save(FareDetails fd);

}
