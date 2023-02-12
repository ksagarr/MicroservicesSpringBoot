package com.easybank.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.easybank.api.model.Account;
import com.easybank.api.repo.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository repo;

	public Account addAccount(Account account) {
		account.setCreateDt(new Date(System.currentTimeMillis()).toString());
		return repo.save(account);
	}

	public List<Account> getAllAccounts() {
		return (List<Account>) repo.findAll();
	}
}
