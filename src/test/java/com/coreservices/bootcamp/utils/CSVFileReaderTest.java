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
	private File CSVFile1;
	// wrong orders
	private File CSVFile2;
	// no orders inside
	private File CSVFile3;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private CSVFileReader cvsFileReader;

	@Before
	public void setUp() {
		cvsFileReader = new CSVFileReader();
		
		CSVFile1 = new File("src/test/resources/testOrders/ValidOrder.csv");
		CSVFile2 = new File("src/test/resources/testOrders/InvalidOrder.csv");
		CSVFile3 = new File("src/test/resources/testOrders/EmptyOrder.csv");
	}

	@Test
	public void getOrderListFromFileTest() {
		
		List<Order> orders = cvsFileReader.getOrderListFromFile(CSVFile1);
		Order order = orders.get(0);
		
		Assert.assertTrue(order.getClientId() != null);
		Assert.assertTrue(order.getName() != null);
		Assert.assertTrue(order.getPrice() != 0.0);
		Assert.assertTrue(order.getQuantity() != 0);
		Assert.assertTrue(order.getRequestId() != null);
		
		Assert.assertTrue(orders.size() == 4);
		
		orders.addAll(cvsFileReader.getOrderListFromFile(CSVFile2));
		Assert.assertTrue(orders.size() == 4);
		
		orders.addAll(cvsFileReader.getOrderListFromFile(CSVFile3));
		Assert.assertTrue(orders.size() == 4);
	}
}
