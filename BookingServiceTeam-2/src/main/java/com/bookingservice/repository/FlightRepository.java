package com.bookingservice.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entities.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long>{

}
