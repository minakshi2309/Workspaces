package com.minakshi.vending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minakshi.vending.model.Product;
import com.minakshi.vending.service.VendingService;

@RestController
public class VendingController {

	@Autowired
	private VendingService vendingService;
	
	@GetMapping(value="/")
	public List<Product> getAllProductsinVendingMaching() {
		return vendingService.retrieveAllProducts();
		
	}

}
