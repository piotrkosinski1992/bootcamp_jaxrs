package com.coreservices.bootcamp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.coreservices.bootcamp.model.Order;

public class ReportOrderServiceTest {

private List<Order> orders = new ArrayList<>();
		
	private File report;
	
	@InjectMocks
	ReportOrderService orderService;	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		orders.add(new Order("1",1L, "bulka", 22, 20.00));
		orders.add(new Order("1",1L, "bulka2", 322, 40.00));
		orders.add(new Order("2",1L, "bulka3", 122, 60.00));
		
	}
	
	@Test
	public void generateReportTest() throws FileNotFoundException {
		
		String reportAbsolutePath = orderService.generateReport("abcd: ", 12);
		report = new File(reportAbsolutePath);
		
		Assert.assertTrue(report.exists());
		Assert.assertTrue(report.isFile());
	}
	
	@Test
	public void generateReportForOrderListTest() throws FileNotFoundException {
		
		String reportAbsolutePath = orderService.generateReport(orders);
		report = new File(reportAbsolutePath);
		
		Assert.assertTrue(report.exists());
		Assert.assertTrue(report.isFile());
	}
		
	@After
	public void cleanGeneratedReport() {
		Assert.assertTrue(report.delete());
	}
}
