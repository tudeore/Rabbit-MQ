package com.capgemini.CartService.service;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.Product;

public interface CartService {

	public Cart getCartById(Integer userId);
	
	public void RemoveFromCart();
	
	public void updateCart();

	void addToCart(Product product);
	
}
