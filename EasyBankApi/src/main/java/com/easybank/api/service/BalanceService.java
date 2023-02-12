package com.easybank.api.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.easybank.api.model.Balance;
import com.easybank.api.repo.BalanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceService {

	private final BalanceRepository repo;

	public String deposite(Balance balance) {
		repo.save(balance);
		return "Balance successfuly credited";
	}

	public BigDecimal getBalance() {
		repo.findAll();
		Balance balance = new Balance();
		return balance.getBalance();
	}
}
