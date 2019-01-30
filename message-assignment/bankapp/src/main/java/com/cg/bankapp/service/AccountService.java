package com.cg.bankapp.service;

import java.util.List;

import com.cg.bankapp.entity.Account;
import com.cg.bankapp.entity.SavingsAccount;

public interface AccountService {

	List<Account> getAllSavingsAccount();

	void addSavingsAccount(Account account);

	Account getAccountById(Integer accountNumber);

	Account updateSavingsAccount(Account account);

	void updateBalance(Account account);

	
}
