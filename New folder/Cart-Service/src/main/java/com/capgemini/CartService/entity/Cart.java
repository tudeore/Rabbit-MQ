package com.capgemini.CartService.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {

	@Id
	private int cartId;		
	//private int quantity;
	private Map<RestaurantCart,Map<FoodItems,Integer>> map;

	
	//private Set<Product> products;
//	private String foodName;
//	private double price;
//	private Set<String> foodPhotos;
//	private Address address;
	
	public Cart() {
			
	}
	
	public Cart(int cartId, Map<RestaurantCart, Map<FoodItems, Integer>> map) {
		super();
		this.cartId = cartId;
		this.map = map;
	}
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Map<RestaurantCart, Map<FoodItems, Integer>> getMap() {
		return map;
	}

	public void setMap(Map<RestaurantCart, Map<FoodItems, Integer>> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", map=" + map + "]";
	}
	
}
