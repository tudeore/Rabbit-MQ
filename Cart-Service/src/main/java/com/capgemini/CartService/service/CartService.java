package com.capgemini.CartService.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.CartService.entity.Cart;


public interface CartService {

	public Optional<Cart> getCartById(Integer userId);

	public List<Cart> getAllCarts();

	public Cart addCart(Cart cart);

	public Cart updateCart(Cart cart);

	double cartTotal(Cart cart);

	public void deleteCartById(int cartId);
	
	
	
	
//	public Cart getcartById(int cartid);
//
//	public Cart updateCart(Cart cart);
//
//	public List<Cart> getallcarts();
//
//	public void deleteCart(int cartid);
//	
//	public double cartTotal(Cart cart);
//	
//	public Cart addCart(Cart cart);

}
