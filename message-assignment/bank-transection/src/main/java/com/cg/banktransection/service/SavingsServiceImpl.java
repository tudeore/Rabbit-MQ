package com.cg.banktransection.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.banktransection.repository.TransactionRepository;
import com.cg.banktransection.transaction.Transaction;
import com.cg.banktransection.transaction.TransactionType;

@Service
public class SavingsServiceImpl implements SavingsService {

	@Autowired
	private TransactionRepository repository;

	@Override
	public Double deposit(double currentBalance, int accountNumber, double amount) {
		if (amount > 0) {
			Transaction transaction = new Transaction();
			transaction.setAccountNumber(accountNumber);
			transaction.setAmount(amount);
			currentBalance += amount;
			transaction.setCurrentBalance(currentBalance);
			transaction.setTransactionDate(LocalDateTime.now());
			transaction.setTransactionType(TransactionType.DEPOSIT);
			transaction.setTransactionDetails("deposited successfully");
			repository.save(transaction);
		}
		return currentBalance;

	}

	@Override
	public Double withDraw(double currentBalance, Integer accountNumber, Double amount) {
		if (currentBalance >= amount) {
			Transaction transaction = new Transaction();
			transaction.setAccountNumber(accountNumber);
			transaction.setAmount(amount);
			currentBalance -= amount;
			transaction.setCurrentBalance(currentBalance);
			transaction.setTransactionDate(LocalDateTime.now());
			transaction.setTransactionType(TransactionType.WITHDRAW);
			transaction.setTransactionDetails("Withdrawl successfully");
			repository.save(transaction);
		}
		return currentBalance;
	}

	@Override
	public List<Transaction> getStatement() {
		return repository.findAll();
	}

}
