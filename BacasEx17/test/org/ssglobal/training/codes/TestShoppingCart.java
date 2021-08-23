package org.ssglobal.training.codes;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestShoppingCart {

	private ShoppingCart cart;
	
	@BeforeEach
	public void setup() {
		cart = new ShoppingCart();
	}
	
	// Sunny day Testing
	@Test
	public void testWhenCartZero() {
		long count = cart.getItemCount();
		Assertions.assertEquals(0, count);
	}
	
	@Test
	public void testWhenCartEmpty() {
		cart.empty();
		long count = cart.getItemCount();
		Assertions.assertEquals(0, count);
	}
	
	@ParameterizedTest
	@MethodSource("productProvider")
	public void testWhenCartAdded(Product item) {
		long oldCount = cart.getItemCount();
		cart.addItem(item);
		long newCount = cart.getItemCount();	
		Assertions.assertEquals(newCount, oldCount + 1);
	}
				
	
	@ParameterizedTest
	@MethodSource("productProvider")
	public void testWhenSumCost(Product item) {
		double oldBalance = cart.getBalance();
		cart.addItem(item);
		double newBalance = cart.getBalance();
		Assertions.assertEquals(newBalance, oldBalance + item.getPrice());	
	}
	
	@ParameterizedTest
	@MethodSource("productProvider")
	public void testWhenCartRemoved(Product item) {
		Assertions.assertDoesNotThrow( () -> {
			long oldCount = cart.getItemCount();
			cart.removeItem(item);
			long newCount = cart.getItemCount();
			Assertions.assertEquals(newCount, oldCount - 1);
		});
	}
	
	@ParameterizedTest
	@MethodSource("productProvider")
	public void testWhenCartRemovedNotFound() {
		Assertions.assertDoesNotThrow( () -> {
			long oldCount = cart.getItemCount();
			cart.removeItem(item);
			long newCount = cart.getItemCount();
			Assertions.assertEquals(newCount, oldCount - 1);
		});
	}
	
	// Rainy day Testing
	
	@AfterEach
	public void teardown() {
		cart = null;
	}
	
	private static Stream<Product> productProvider() {
		return Stream.of(new Product("book", 500.00), 
						 new Product("shoes", 2500.00),
						 new Product("glass", 250.00),
						 new Product("shirt", 800.00),
						 new Product("plate", 100.00),
						 new Product("laptop", 32500.00));
	}	
}
