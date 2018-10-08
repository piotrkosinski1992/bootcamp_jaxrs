package com.coreservices.bootcamp.utils;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.coreservices.bootcamp.model.Order;

public class CSVFileReaderTest {
	
	// correct orders
	private File csvFile1;
	// wrong orders
	private File csvFile2;
	// no orders inside
	private File csvFile3;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private CSVFileReader cvsFileReader;

	@Before
	public void setUp() {
		cvsFileReader = new CSVFileReader();
		
		csvFile1 = new File("src/test/resources/testOrders/ValidOrder.csv");
		csvFile2 = new File("src/test/resources/testOrders/InvalidOrder.csv");
		csvFile3 = new File("src/test/resources/testOrders/EmptyOrder.csv");
	}

	@Test
	public void getOrderListFromFileTest() {
		
		List<Order> orders = cvsFileReader.getOrderListFromFile(csvFile1);
		Order order = orders.get(0);
		
		Assert.assertTrue(order.getClientId() != null);
		Assert.assertTrue(order.getName() != null);
		Assert.assertTrue(order.getPrice() != 0.0);
		Assert.assertTrue(order.getQuantity() != 0);
		Assert.assertTrue(order.getRequestId() != null);
		
		Assert.assertTrue(orders.size() == 4);
		
		orders.addAll(cvsFileReader.getOrderListFromFile(csvFile2));
		Assert.assertTrue(orders.size() == 4);
		
		orders.addAll(cvsFileReader.getOrderListFromFile(csvFile3));
		Assert.assertTrue(orders.size() == 4);
	}
}
