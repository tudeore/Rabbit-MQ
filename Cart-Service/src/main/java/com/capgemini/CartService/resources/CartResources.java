package com.capgemini.CartService.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CartService.entity.Product;
import com.capgemini.CartService.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartResources {

	
	@Autowired
	CartService cartService;
	
	@PostMapping
	public void addToCart(@RequestBody Product product ) {
		
		cartService.addToCart(product);
	}
	
	
	@GetMapping("/{userId}")
	public void getProductById(@PathVariable Integer userId) {
		
		cartService.getCartById(userId);
	}
}
