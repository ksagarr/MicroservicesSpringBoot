package com.easybank.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybank.api.model.Customer;
import com.easybank.api.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerCuntroller {
	@Autowired
	private CustomerService service;

	@PostMapping("/user")
	public String addNewUser(@RequestBody Customer custmoer) {
		return service.addNewUser(custmoer);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<>(service.getAllCustomers(),HttpStatus.OK);
	}

}
