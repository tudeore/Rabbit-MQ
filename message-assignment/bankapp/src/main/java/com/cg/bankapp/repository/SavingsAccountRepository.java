package com.cg.bankapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.bankapp.entity.Account;

@Repository
public interface SavingsAccountRepository extends MongoRepository<Account, Integer> {

	
	
}
