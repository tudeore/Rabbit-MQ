package com.capgemini.CartService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.Product;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>  {
	
}
