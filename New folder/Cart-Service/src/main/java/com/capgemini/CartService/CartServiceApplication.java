package com.capgemini.CartService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.Product;
import com.capgemini.CartService.repository.CartRepository;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner cartService(CartRepository repository) {
		Set<Product> set=new HashSet<Product>();
		Product product1=new Product(101,"Tomato Soup",10000);
		set.add(product1);
//		return (env) -> {
//			repository.save(new Cart(101, 1, set));
//			repository.save(new Cart(102, 1,set));
//			repository.save(new Cart(103, 5,set));
//			repository.save(new Cart(104, 6,set));
//		};
		return null;
	}

}
