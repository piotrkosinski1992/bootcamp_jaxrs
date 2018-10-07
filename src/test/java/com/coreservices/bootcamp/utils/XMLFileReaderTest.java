package com.coreservices.bootcamp.utils;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class XMLFileReaderTest {

	// correct orders
	private File XMLFile1;
	// wrong orders
	private File XMLFile2;
	// no orders inside
	private File XMLFile3;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private XMLFileReader xmlFileReader;

	@Before
	public void setUp() {
		xmlFileReader = new XMLFileReader();
		
		XMLFile1 = new File("src/test/resources/XMLFileReaderTestOrders/ValidOrder.xml");
		XMLFile2 = new File("src/test/resources/XMLFileReaderTestOrders/InvalidOrder.xml");
		XMLFile3 = new File("src/test/resources/XMLFileReaderTestOrders/EmptyOrder.xml");
	}
	
	
	@Test
	public void getOrderListFromFileTest() {
		Assert.assertTrue(xmlFileReader.getOrderListFromFile(XMLFile1).size() == 3);	
		Assert.assertTrue(xmlFileReader.getOrderListFromFile(XMLFile2).size() == 0);
		Assert.assertTrue(xmlFileReader.getOrderListFromFile(XMLFile3).size() == 0);
	}
}
