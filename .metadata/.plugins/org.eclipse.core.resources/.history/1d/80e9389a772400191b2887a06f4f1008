package com.cg.bankapp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.entity.Account;
import com.cg.bankapp.entity.SavingsAccount;
import com.cg.bankapp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	AccountService savingsAccountservice;

	@PostMapping
	public void addSavingsAccount(@RequestBody Account account) {

		savingsAccountservice.addSavingsAccount(account);

	}

	@GetMapping
	public List<Account> getAllSavingsAccount(Account account) {

		return savingsAccountservice.getAllSavingsAccount();

	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountByid(@PathVariable Integer accountNumber) {
		
		return savingsAccountservice.getAccountById(accountNumber);
		 
	}
	
	@GetMapping("/{accountNumber}/balance")
	public Double getAccountBalance(@PathVariable Integer accountNumber) {
		
		Account account = savingsAccountservice.getAccountById(accountNumber);
		return account.getCurrentBalance();
		 
	}
	
	@PutMapping("/{accountNumber}")
	public void updateAccount(@PathVariable Integer accountNumber, @RequestParam Double currentBalance)
	{
		Account account = savingsAccountservice.getAccountById(accountNumber);
		account.setCurrentBalance(currentBalance);
		savingsAccountservice.updateBalance(account);
		 
	}



}
