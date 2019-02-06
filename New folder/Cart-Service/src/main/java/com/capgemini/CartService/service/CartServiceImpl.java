package com.capgemini.CartService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.CartService.entity.Cart;
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
	public Cart updateCart(Cart cart) {
		return repository.save(cart);
	}
	
}
