package com.cg.banktransection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class BankTransectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTransectionApplication.class, args);
	}

	@Bean  //java configuration
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();    //RestTemplate obj = new RestTemplate();
	}
	
}

