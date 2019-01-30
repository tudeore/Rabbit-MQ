package com.cg.messagingreceiver.receiver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@Bean
	public Queue queue() {

		return new Queue("CustomerQ", false);
	}

	@RabbitListener(queues = "CustomerQ")
	public void processMessage(String email) {

		System.out.println(email);

	}
}
