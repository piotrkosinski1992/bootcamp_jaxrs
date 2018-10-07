package com.coreservices.bootcamp.utils;

import org.junit.Assert;
import org.junit.Test;

public class OrderValidatorTest {

	private String[] validOrder = {"1","1","bulka","22","22.22"};
	private String[] invalidClientIdOrder = {"1 @","1","bulka","22","22.22"};
	private String[] invalidClientIdOrder2 = {"1234567","1","bulka","22","22.22"};
	private String[] invalidRequestIdOrder = {"1","@$$S","bulka","22","22.22"};
	private String[] invalidNameOrder = {"1","1","bulkaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaa aaaaa    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssaaaaaaaaaaaaaaaaaaa","22","22.22"};
	private String[] invalidQuantityOrder = {"1","1","bulka","2@2","22.22"};
	private String[] invalidPriceOrder = {"1","1","bulka","22","W@2"};
	private String[] invalidPriceOrder2 = {"1","1","bulka","22","22.1234"};
		
	@Test
	public void isOrderValidTest() {
		Assert.assertTrue(OrderValidator.isOrderValid(validOrder));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidClientIdOrder));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidClientIdOrder2));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidRequestIdOrder));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidNameOrder));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidQuantityOrder));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidPriceOrder));
		Assert.assertFalse(OrderValidator.isOrderValid(invalidPriceOrder2));
	}
}
