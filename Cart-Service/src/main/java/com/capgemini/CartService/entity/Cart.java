package com.capgemini.CartService.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class Cart {

	@Id
	private int cartId;		
	private int quantity;
	private Set<Product> products;
//	private String foodName;
//	private double price;
//	private Set<String> foodPhotos;
	
	public Cart() {
			
	}
	
	public Cart(int cartId, int quantity, Set products) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.products = products;
	}

	
	public int getCartId() {
		return cartId;
	}

	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Set getProducts() {
		return products;
	}


	public void setProducts(Set products) {
		this.products = products;
	}


	public void addProduct(Product product) {
		products.add(product);
		
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", products=" + products + "]";
	}

}
