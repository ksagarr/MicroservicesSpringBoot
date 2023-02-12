package com.easybank.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.easybank.api.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
	Account findByname(String username);
}
