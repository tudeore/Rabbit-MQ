package com.capgemini.CartService.cartservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.Product;
import com.capgemini.CartService.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CartServiceTest {
		
	@Autowired
	CartService service;

	@Ignore
	@Test
	public void testGetCartByValidId() {
		Optional<Cart> cart = service.getCartById(102);
		assertTrue(cart.isPresent());
	}
	
	@Ignore
	@Test
	public void testGetCartByInavlidId() {
		Optional<Cart> cart = service.getCartById(112);
		assertFalse(cart.isPresent());
	}
	
	@Ignore
	@Test
	public void testGetAllCarts() {
		List<Cart> cart = service.getAllCarts();
		assertEquals(8, cart.size());
	}
	
/*	@Test
	public void testAddCart() {
		Set<Product> set = new HashSet();
		Product pr =new Product
		set.
		
		Cart cart = new Cart(108,4
	}*/
	
	
	
	
}
