package com.easybank.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.easybank.api.model.Balance;

public interface BalanceRepository extends CrudRepository<Balance ,Long> {

}
