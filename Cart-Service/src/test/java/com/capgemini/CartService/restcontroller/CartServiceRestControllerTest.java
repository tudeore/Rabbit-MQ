package com.capgemini.CartService.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.CartService.entity.Address;
import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.FoodProducts;
import com.capgemini.CartService.resources.CartResources;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CartServiceRestControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	
	@Test
	public void testNoMappingPresent() throws Exception {

		ResponseEntity<CartResources> responseEntity = testRestTemplate.getForEntity("/food", CartResources.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	
	@Test
	public void testNoMethodExistToHandleRequest() throws Exception {

		ResponseEntity<CartResources> responseEntity = testRestTemplate.getForEntity("/cart", CartResources.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void testMethodExistToHandle() throws Exception {

		ResponseEntity<CartResources> entity = testRestTemplate.getForEntity("/carts/cartId", CartResources.class);

//		assertEquals(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());

	}

	
	@Test
	public void testGetAllCarts() throws Exception {

		ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("/carts", List.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	public void testAddCart() throws Exception {
		Set<FoodProducts> products =new HashSet<FoodProducts>();
		products.add(new FoodProducts("fries", 102.2, 2));
		Address address = new Address("airoli", "mumbai", "Maharashtra", "India", 4001);
		Cart cart = new Cart(106, "deores cafe", products, 18.97, address);

		ResponseEntity<Cart> responseEntity = testRestTemplate.postForEntity("/carts", cart, Cart.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}


	@Test
	public void testGetCartById() throws Exception {

		ResponseEntity<Cart> responseEntity = testRestTemplate.getForEntity("/carts/101", Cart.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	
	@Test
	public void testGetCartByIdNotFound() throws Exception {

		ResponseEntity<Cart> responseEntity = testRestTemplate.getForEntity("/carts/110", Cart.class);

		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	
	@Test
	public void testGetcartByIdBadRequest() throws Exception {

		ResponseEntity<Cart> responseEntity = testRestTemplate.getForEntity("/carts/food", Cart.class);

		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateCart() throws Exception {

		Set<FoodProducts> products =new HashSet<FoodProducts>();
		products.add(new FoodProducts("momos", 102.2, 2));
		Address address = new Address("airoli", "navi-mumbai", "Maharashtra", "India", 4001);
		Cart cart = new Cart(106, "deores cafe", products, 18.97, address);

		
	 testRestTemplate.put("/carts/106", cart);
	 

	 ResponseEntity<Cart> responseEntity = testRestTemplate.getForEntity("/carts/106", Cart.class);
	 System.out.println(responseEntity.getBody());

		assertTrue(responseEntity.getBody().getAddress().getCity().equalsIgnoreCase("navi-mumbai"));
	}

}
