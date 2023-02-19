package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.entities.InventoryEntity;
import com.bookingservice.service.InventoryService;

@RestController
@RequestMapping("/InventoryEnquiry")
public class InventoryEnquiry {

	@Autowired(required = true)
	InventoryService inventoryService;
	
	
	@RequestMapping(value = "/allDetailsInInventory",method = RequestMethod.GET)
	public Iterable<InventoryEntity> viewAllDetailsInInventory() {
		return inventoryService.viewAllInven();
	}

}
