package com.capgemini.CartService.cartservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.CartService.entity.Address;
import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.FoodProducts;
import com.capgemini.CartService.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CartServiceTest {
		
	@Autowired
	CartService service;

	
	@Test
	public void testGetCartByValidId() {
		Optional<Cart> cart = service.getCartById(102);
		assertTrue(cart.isPresent());
	}
	
	
	@Test
	public void testGetCartByInavlidId() {
		Optional<Cart> cart = service.getCartById(112);
		assertFalse(cart.isPresent());
	}
	
	
	@Test
	public void testGetAllCarts() {
		List<Cart> cart = service.getAllCarts();
		assertEquals(4, cart.size());
	}
	
	@Test
	public void testAddCart() {
		Set<FoodProducts> products =new HashSet<FoodProducts>();
		products.add(new FoodProducts("fries", 102.2, 2));
		Address address = new Address("airoli", "mumbai", "Maharashtra", "India", 4001);
		Cart cart = new Cart(107, "deores cafe", products, 18.97, address);
		service.addCart(cart);
		assertTrue(service.getCartById(107).isPresent());
	}
	
	@Test
	public void testUpdateCart() {
		Set<FoodProducts> products =new HashSet<FoodProducts>();
		products.add(new FoodProducts("momos", 102.2, 2));
		Address address = new Address("airoli", "navi-mumbai", "Maharashtra", "India", 4001);
		Cart cart = new Cart(107, "deores cafe", products, 18.97, address);
		service.updateCart(cart);
		assertTrue(service.getCartById(107).get().getAddress().getCity().equalsIgnoreCase("navi-mumbai"));
		
	}
	
	
}
