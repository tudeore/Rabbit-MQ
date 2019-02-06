package com.capgemini.CartService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.Product;
import com.capgemini.CartService.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository repository;
	
	@Override
	public Cart getCartById(Integer cartId) {
		
		return repository.findById(cartId).get();
	}

	@Override
	public void RemoveFromCart() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addToCart( Product product) {
		
		Cart cart =new Cart();
		cart.getCartId();
		cart.getQuantity();
		cart.addProduct(product);
		repository.save(cart);
	
	}

	@Override
	public void updateCart() {
		// TODO Auto-generated method stub
		
	}
	
}
