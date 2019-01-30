package com.cg.messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.messaging.sender.Sender;
@Service
public class HelloServiceImpl implements HelloService {

	@Autowired
	Sender sender;
	
	public void messageWrite(String message) {
		
		sender.send(message);
	}
	
}
