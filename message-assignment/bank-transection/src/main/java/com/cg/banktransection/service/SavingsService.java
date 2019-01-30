package com.cg.banktransection.service;

import java.util.List;

import com.cg.banktransection.transaction.Transaction;

public interface SavingsService {


	Double deposit(double currentBalance, int accountNumber, double amount);

	Double withDraw(double currentBalance, Integer accountNumber, Double amount);

	List<Transaction> getStatement();

	
	
}
