/**
 * 
 */
package com.capgemini.CartService.entity;
import java.util.Set;

/**
 * @author tudeore
 *
 */
public class FoodItems {
	
	private String foodName;		//foodName
	private boolean veg;			
	private Double price;			//price
	private String description;
	private Set<String> foodPhotos;		//foodPhotos	
	
	public FoodItems() {
		
	}

	public String getFoodName() {
		return foodName;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public boolean isVeg() {
		return veg;
	}
	
	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<String> getFoodPhotos() {
		return foodPhotos;
	}
	
	public void setFoodPhotos(Set<String> foodPhotos) {
		this.foodPhotos = foodPhotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + (veg ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItems other = (FoodItems) obj;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (veg != other.veg)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodItems [foodName=" + foodName + ", veg=" + veg + ", price=" + price + ", description=" + description
				+ ", foodPhotos=" + foodPhotos + "]";
	}
}
