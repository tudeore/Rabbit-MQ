package com.capgemini.CartService.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.CartService.entity.Cart;
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

		ResponseEntity<CartResources> responseEntity = testRestTemplate.getForEntity("/carts/cartId",
				CartResources.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

	}

	@Test
	public void testGetAllCarts() throws Exception {

		ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("/carts", List.class);

		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());

	}

	/*
	 * @Test public void testAddCart() throws Exception { Cart cart = new Cart(107,
	 * 0, null);
	 * 
	 * ResponseEntity<Cart> responseEntity =
	 * testRestTemplate.postForEntity("/carts", cart, Cart.class);
	 * 
	 * assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); }
	 */

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
}
