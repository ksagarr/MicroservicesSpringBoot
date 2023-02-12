package com.easybank.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.easybank.api.model.Customer;
import com.easybank.api.repo.CustomerRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository repo;
	private final PasswordEncoder encoder;
	
	public String addNewUser(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		customer.setCreateDt(new Date(System.currentTimeMillis()).toString());
		repo.save(customer);
		return "Customer Add Successfuly...........";
	}
	
	public List<Customer> getAllCustomers(){
		return (List<Customer>) repo.findAll();
	}
}
