package com.capgemini.CartService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner cartService(CartRepository repository) {
	 * return (env) -> { repository.save(new Cart(101, 1, products));
	 * repository.save(new Cart(102, 1)); repository.save(new Cart(103, 5));
	 * repository.save(new Cart(104, 6)); }; }
	 */

}
