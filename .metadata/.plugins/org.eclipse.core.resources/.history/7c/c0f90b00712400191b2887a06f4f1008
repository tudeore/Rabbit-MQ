package com.moneymoney.web.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.moneymoney.web.entity.CurrentDataSet;
import com.moneymoney.web.entity.Transaction;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class BankAppController {

	
	private CurrentDataSet currentDataSet;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String depositForm() {
		return "DepositForm";
	}

	@HystrixCommand(fallbackMethod="serverFallback")  // FALLBACK
	@RequestMapping("/deposit")
	public String deposit(@ModelAttribute Transaction transaction, Model model) {

		restTemplate.postForEntity("http://zuulServer/bankapp/transactions/deposit", transaction, null);
		//							http://localhost:8181/transaction/...
		//							http://localhost:9696/transactions/deposit
		model.addAttribute("message", "Transaction Successful!");
		return "DepositForm";
	}

	
	
	@RequestMapping("/WITHDRAW")
	public String withdrawForm() {
		return "withdrawForm";
	}

	
	@HystrixCommand(fallbackMethod="serverFallback")   //FALLBACK
	@RequestMapping("/withdraw")
	public String withDraw(@ModelAttribute Transaction transaction, Model model) {

		restTemplate.postForEntity("http://zuulServer/bankapp/transactions/withdraw", transaction, null);
		model.addAttribute("message", "Transaction Successful!");
		return "withdrawForm";
	}
	
	
	public String serverFallback(@ModelAttribute Transaction transaction,Model model) { // SERVER FALLBACK
		String message = "Transaction failed... Server under maintenance please try after some time !!!";
		model.addAttribute("message", message);
		return "serverStatus";
	}
	

	@RequestMapping("/FUNDTRANSFER")
	public String fundTransferForm() {

		return "fundTransferForm";
	}

	
	@HystrixCommand(fallbackMethod="fundtransferFallback")		//FALLBACK
	@RequestMapping("/fundTransfer")
	public String fundTransfer(@RequestParam("senderAccountNumber") int senderAccountNumber,
			@RequestParam("receiverAccountNumber") int receiverAccountNumber, @RequestParam("amount") double amount,
			Model model) {

		restTemplate
				.postForEntity(
						"http://zuulServer/bankapp/transactions/fundtransfer?senderAccountNumber=" + senderAccountNumber
								+ "&&receiverAccountNumber=" + receiverAccountNumber + "&&amount=" + amount,
						null, null);

		model.addAttribute("message", "Transaction Successful!");
		return "fundTransferForm";
	}
	
	
	public String fundtransferFallback(@RequestParam("senderAccountNumber") int senderAccountNumber,
			@RequestParam("receiverAccountNumber") int receiverAccountNumber, @RequestParam("amount") double amount,
			Model model) {
		String message = "Transaction failed !!! Server issue please try after some time !!!";
		model.addAttribute("message", message);
		return "serverStatus";
	}
	
	@HystrixCommand(fallbackMethod="statementsFallback")
	@RequestMapping("/statements")
	public ModelAndView getStatements(@RequestParam("offset") int offset, @RequestParam("size") int size) {
		CurrentDataSet storeDataset = restTemplate.getForObject("http://zuulServer/bankapp/transactions/statement",
				CurrentDataSet.class);
		
		currentDataSet = storeDataset;
		int currentSize = size == 0 ? 5 : size;
		int currentOffset = offset == 0 ? 1 : offset;
		Link next = linkTo(methodOn(BankAppController.class).getStatements(currentOffset + currentSize, currentSize)).withRel("next");
		Link previous = linkTo(methodOn(BankAppController.class).getStatements(currentOffset - currentOffset, currentSize)).withRel("previous");
		List<Transaction> currentDataSetList = new ArrayList<Transaction>();
		List<Transaction> transactions = currentDataSet.getTransactions();
		System.out.println(transactions);
		
		for (int i = currentOffset - 1; i < currentSize + currentOffset - 1; i++) {
			if((transactions.size()<=i && i>0) || currentOffset<1) break;
			Transaction transaction = transactions.get(i);
			currentDataSetList.add(transaction);
		}

		CurrentDataSet dataSet = new CurrentDataSet(currentDataSetList, next, previous);
		
		return new ModelAndView("Statements", "currentDataSet", dataSet);
	}
	
	public ModelAndView statementsFallback(@RequestParam("offset") int offset, @RequestParam("size") int size) {
		CurrentDataSet storeDataset = currentDataSet;
		
		int currentSize = size == 0 ? 5 : size;
		int currentOffset = offset == 0 ? 1 : offset;
		Link next = linkTo(methodOn(BankAppController.class).getStatements(currentOffset + currentSize, currentSize)).withRel("next");
		Link previous = linkTo(methodOn(BankAppController.class).getStatements(currentOffset - currentOffset, currentSize)).withRel("previous");
		List<Transaction> currentDataSetList = new ArrayList<Transaction>();
		List<Transaction> transactions = currentDataSet.getTransactions();
		System.out.println(transactions);
		
		for (int i = currentOffset - 1; i < currentSize + currentOffset - 1; i++) {
			if((transactions.size()<=i && i>0) || currentOffset<1) break;
			Transaction transaction = transactions.get(i);
			currentDataSetList.add(transaction);
		}

		CurrentDataSet dataSet = new CurrentDataSet(currentDataSetList, next, previous);
		 
		return new ModelAndView("serverStatus", "currentDataSet",dataSet );
	}
}
