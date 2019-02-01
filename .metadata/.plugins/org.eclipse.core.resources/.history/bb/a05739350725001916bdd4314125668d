package com.cg.banktransection.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cg.banktransection.transaction.Transaction;

@Component
@Lazy
public class Sender {

	@Autowired
	RabbitMessagingTemplate template;
	
	@Bean
	public Queue queue() {
		return new Queue("updateBalance",false);
	}
	
	public void send(Transaction transaction) {
		
		template.convertAndSend("updateBalance",transaction);
	}
	
}
