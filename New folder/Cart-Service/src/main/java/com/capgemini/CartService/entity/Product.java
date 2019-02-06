package com.capgemini.CartService.entity;

public class Product {

	private Integer foodId;
	private String foodName;
	private double price;
	
	public Product() {
		super();
	}

	public Product(Integer foodId, String foodName, double price) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;	
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
