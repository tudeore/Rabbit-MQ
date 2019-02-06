package com.capgemini.CartService.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CartService.entity.Cart;
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

	@PostMapping
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		Cart responseEntity = cartService.addCart(cart);

		return new ResponseEntity<Cart>(HttpStatus.OK);
	}

	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer cartId) {
		Optional<Cart> cart = cartService.getCartById(cartId);
		if (!cart.isPresent()) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cart>(cart.get(), HttpStatus.OK);
	}

	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCart(@PathVariable Integer cartId, @RequestParam String operation,
			@RequestParam Integer productId) {
		Cart cart = cartService.getCartById(cartId).get();
		cart = cartService.updateCart(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

}
