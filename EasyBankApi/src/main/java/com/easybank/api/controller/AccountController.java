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

import com.easybank.api.model.Account;
import com.easybank.api.service.AccountService;

@RestController
@RequestMapping("/ac")
public class AccountController {
    @Autowired
	private AccountService service;
    
    @PostMapping("/new")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		return new ResponseEntity<>(service.addAccount(account),HttpStatus.OK);
	}
    
    @GetMapping("/all")
    public ResponseEntity<List<Account>>getAllAccount(){
    	return new ResponseEntity<>(service.getAllAccounts(),HttpStatus.OK);
    }
}
