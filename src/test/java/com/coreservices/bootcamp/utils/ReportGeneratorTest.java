package com.coreservices.bootcamp.utils;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.coreservices.bootcamp.model.Order;

public class ReportGeneratorTest {

	private File report;

	private List<Order> orders = new ArrayList<>();

	@Before
	public void setUp() {
		orders.add(new Order("1", 1L, "bulka", 22, 20.00));
		orders.add(new Order("1", 1L, "bulka2", 322, 40.00));
		orders.add(new Order("2", 1L, "bulka3", 122, 60.00));
	}

	@Test
	public void generateReportTest() throws FileNotFoundException {
		String message = "abcd: ";
		int value = 12;

		String reportAbsolutePath = ReportGenerator.generateReport(message, value);
		report = new File(reportAbsolutePath);

		Assert.assertTrue(report.exists());
		Assert.assertTrue(report.isFile());

		Scanner scanner = new Scanner(report);
		Assert.assertTrue(scanner.nextLine().equals(message + value));
		Assert.assertTrue(scanner.hasNextLine() == false);
		scanner.close();
	}

	@Test
	public void generateReportForOrderListTest() throws FileNotFoundException {
		String reportAbsolutePath = ReportGenerator.generateReport(orders);
		report = new File(reportAbsolutePath);

		Assert.assertTrue(report.exists());
		Assert.assertTrue(report.isFile());

		Scanner scanner = new Scanner(report);

		int numberOfLines = 0;
		while (scanner.hasNextLine()) {
			numberOfLines++;
			scanner.nextLine();
		}
		// each request contains 7 lines + 2x requests tag and xml declaration
		Assert.assertTrue(numberOfLines == (orders.size() * 7 + 3));
		scanner.close();
	}

	@After
	public void cleanGeneratedReport() {
		Assert.assertTrue(report.delete());
	}
}
