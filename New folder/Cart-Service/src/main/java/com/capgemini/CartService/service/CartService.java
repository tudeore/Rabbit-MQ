package com.capgemini.CartService.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.CartService.entity.Cart;


public interface CartService {

	public Optional<Cart> getCartById(Integer userId);

	public List<Cart> getAllCarts();

	public Cart addCart(Cart cart);

	public Cart updateCart(Cart cart);
	
}
