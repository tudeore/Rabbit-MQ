package com.capgemini.CartService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.FoodProducts;
import com.capgemini.CartService.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository repository;
	
	
	@Override
	public Optional<Cart> getCartById(Integer cartId) {
		return repository.findById(cartId);
	}

	@Override
	public List<Cart> getAllCarts() {
		return repository.findAll();
	}

	@Override
	public Cart addCart(Cart cart) {
		return repository.save(cart);
	}
	

	@Override
	public double cartTotal(Cart cart) {
		double totalPrice;
		 double cartPrice = 0;

		for (FoodProducts product : cart.getProducts()) {
			System.out.println(product);
			System.out.println("Product total is: " + product.getPrice() * product.getQuantity());
			totalPrice = product.getPrice() * product.getQuantity();
			cartPrice = cartPrice + totalPrice;
		}
		System.out.println("Total Cart Value is: " +cartPrice);
		return cartPrice;
	}
	

	@Override
	public Cart updateCart(Cart cart) {
		return repository.save(cart);
	}

	@Override
	public void deleteCartById(int cartId) {
		
		repository.deleteById(cartId);
		
	}
	
}
