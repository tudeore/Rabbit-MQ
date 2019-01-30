package com.cg.messaging.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.messaging.service.HelloService;

@RestController
public class Resource {

	@Autowired
	private HelloService helloService;
	
	
	@RequestMapping("/hello")
	public void hello() {
		
		helloService.messageWrite("hello World!!");
	}
}
