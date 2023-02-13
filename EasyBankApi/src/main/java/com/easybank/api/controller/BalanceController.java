package com.easybank.api.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/get/{balanceId}")
	public ResponseEntity<BigDecimal>getBalanace(@PathVariable Long balanceId){
		return new ResponseEntity<>(service.getBalance(balanceId),HttpStatus.OK);
	}
	@PutMapping("/{balanceId}")
	public ResponseEntity<String> addBalance(@PathVariable Long balanceId,@RequestBody Balance balance){
		return new ResponseEntity<>(service.addBalance(balanceId, balance),HttpStatus.OK);
	}
}
