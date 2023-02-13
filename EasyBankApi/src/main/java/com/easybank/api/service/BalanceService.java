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

	public BigDecimal getBalance(Long balanceId ) {
		Balance balance= repo.findById(balanceId).get();
		return balance.getBalance();
	}
	
	public String addBalance(Long balanceId,Balance balance) {
		Balance newbalance=repo.findById(balanceId).get();
		newbalance.setBalance(newbalance.getBalance().add(balance.getBalance()));
		repo.save(newbalance);
		return "Balance successfuly credit and total balance";
	}
}
