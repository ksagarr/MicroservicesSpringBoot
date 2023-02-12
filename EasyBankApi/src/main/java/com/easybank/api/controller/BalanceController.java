package com.easybank.api.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybank.api.model.Balance;
import com.easybank.api.service.BalanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ac")
@RequiredArgsConstructor
public class BalanceController {
   
	private final BalanceService service;
	@PostMapping("/credit")
	public ResponseEntity<String> addBalance(@RequestBody Balance balance){
		return new ResponseEntity<>(service.deposite(balance),HttpStatus.CREATED);
	}
	@GetMapping("/balance")
	public ResponseEntity<BigDecimal>getBalanace(){
		return new ResponseEntity<>(service.getBalance(),HttpStatus.OK);
	}
}
