package com.capgemini.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.CartService.repository.CartRepository;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@Autowired
	private CartRepository repository;
	
//	@Bean
//	public CommandLineRunner cartService(CartRepository repository) {
//		Set<FoodProducts> products1 = new HashSet();
//		products1.add(new FoodProducts("Biryani",200.0,2));
//		
//		Address address = new Address("Airoli","Mumbai","Maharashtra","India",402);
//		Address address1 = new Address("Deopur","Dhule","Maharashtra","India",502);
//	
//		return (env) -> {
//		repository.save(new Cart(101, "annaprna", products1, 1000, address));
//		repository.save(new Cart(102,"foodJi", products1, 400.0,address1));
//		};
//	
//	}
}
