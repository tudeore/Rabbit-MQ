package com.cg.bankapp.receiver;



import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cg.bankapp.resource.AccountResource;
import com.cg.banktransection.transaction.Transaction;

@Component
public class Receiver {

	@Autowired
	AccountResource resource; 
	
	@Bean
	public Queue queue() {
		return new Queue("updateBalance",false);
	}
	
	@RabbitListener(queues="updateBalance")
	public void processMessage(Transaction transaction) {
		System.out.println(transaction);
		resource.updateAccount(transaction.getAccountNumber(), transaction.getCurrentBalance());
		
	}
}
