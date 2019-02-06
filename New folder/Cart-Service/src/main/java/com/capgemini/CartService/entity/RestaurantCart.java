package com.capgemini.CartService.entity;

import java.util.Set;


public class RestaurantCart {

	private Integer restaurantId;			
	private String restaurantName; 					
	private Address address;
	private Set<FoodItems> foodItems;
	
	public RestaurantCart() {
		super();
	}

	public RestaurantCart(Integer restaurantId, String restaurantName, Address address, Set<FoodItems> foodItems) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.foodItems = foodItems;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<FoodItems> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(Set<FoodItems> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "RestaurantCart [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", foodItems=" + foodItems + "]";
	}
	
	
}
