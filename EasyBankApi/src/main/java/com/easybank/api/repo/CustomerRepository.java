package com.easybank.api.repo;


import org.springframework.data.repository.CrudRepository;
import com.easybank.api.model.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByname(String username);
}
