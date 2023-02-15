package com.bookingservice.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entities.InventoryEntity;
@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{

	@Query("Select a from T_REL_INVENTORY a where a.flightId=?1")
	List<InventoryEntity> getByFlightId(long id);

//	@Modifying
//	@Transactional
//	@Query("Update a T_REL_INVENTORY set a.emptySeats= :totalEmpty where a.flightId= :flightId")
//	void changeEmptySeats(int totalEmpty, long flightId);
}
