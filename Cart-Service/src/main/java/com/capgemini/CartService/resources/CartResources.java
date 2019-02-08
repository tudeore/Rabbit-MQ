package com.capgemini.CartService.resources;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.FoodItems;
import com.capgemini.CartService.entity.FoodProducts;
import com.capgemini.CartService.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartResources {

	@Autowired
	CartService cartService;

	@GetMapping
	public ResponseEntity<List<Cart>> getAllCarts() {
		List<Cart> list = cartService.getAllCarts();
		return new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
	}

	// ************************************************************

	@PostMapping
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
		/*
		 * @RequestParam int cartId, @RequestParam String restaurantName,
		 * 
		 * @RequestParam String foodName,
		 * 
		 * @RequestParam double foodPrice, @RequestParam int quantity, @RequestBody
		 * Address address Cart cart = new Cart();
		 * 
		 * cart.setCartId(cartId); cart.setRestaurantName(restaurantName);
		 * 
		 * FoodProducts products = new FoodProducts(); products.setFoodName(foodName);
		 * products.setPrice(foodPrice); products.setQuantity(quantity);
		 * 
		 * Set<FoodProducts> items = new HashSet(); items.add(products);
		 * 
		 * cart.setProducts(items); cart.setTotalAmount(10000);
		 * 
		 * Address restAddress = new Address();
		 * 
		 * cart.setAddress(restAddress);
		 */
		cartService.addCart(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	/*
	 * @PostMapping public ResponseEntity<Cart> addToCart(@RequestParam int
	 * cartId,@RequestParam String restaurantName,@RequestParam int totalAmount) {//
	 * System.out.println(cartId+"cartid"+restaurantName+totalAmount);
	 * 
	 * return null; }
	 */

	// *****************************************************************
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer cartId) {
		Optional<Cart> cart = cartService.getCartById(cartId);
		if (!cart.isPresent()) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cart>(cart.get(), HttpStatus.OK);
	}

	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
		
		Cart updateCart = cartService.getCartById(cart.getCartId()).get();
		Set<FoodProducts> products = updateCart.getProducts();					//Items present in cart	
		Set<FoodProducts> newFoodsToAdd = cart.getProducts();				//Items to add into cart		
		Iterator<FoodProducts> itr = newFoodsToAdd.iterator();
		while(itr.hasNext())
		{
			products.add(itr.next());
		}
		updateCart.setProducts(products);
		updateCart.setTotalAmount(cartService.cartTotal(updateCart));
		cartService.updateCart(updateCart);
		return new ResponseEntity<>(updateCart, HttpStatus.OK);
	}

//@PutMapping
//public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
//	Cart updateCart = service.getcartById(cart.getCartId());
//	Set<Items> items = updateCart.getItems();					//Items present in cart	
//	Set<Items> newItemsToAdd = cart.getItems();				//Items to add into cart		
//	Iterator<Items> itr = newItemsToAdd.iterator();
//	while(itr.hasNext())
//	{
//		items.add(itr.next());
//	}
//	updateCart.setItems(items);
//	updateCart.setTotalPrice(service.cartTotal(updateCart));
//	service.updateCart(updateCart);
//	return new ResponseEntity<>(updateCart, HttpStatus.OK);
//}


	@DeleteMapping("/{cartId}")
	public void deleteCart(@PathVariable int cartId) {
		cartService.deleteCartById(cartId);
	}

	@DeleteMapping
	public void deleteFromCart(@RequestBody Cart cart) {

		Cart updateCart = cartService.getCartById(cart.getCartId()).get();
		Set<FoodProducts> products = updateCart.getProducts(); // Items already in cart
		Set<FoodProducts> itemsToRemove = cart.getProducts(); // Items to remove from cart
		Iterator<FoodProducts> itr = itemsToRemove.iterator();
		while (itr.hasNext()) {
			products.remove(itr.next());
		}

		updateCart.setProducts(products);
		updateCart.setTotalAmount(cartService.cartTotal(updateCart));
		cartService.updateCart(updateCart);
		cartService.cartTotal(updateCart);
	}
}

