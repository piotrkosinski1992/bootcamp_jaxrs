package com.coreservices.bootcamp.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.coreservices.bootcamp.repository.OrderRepository;

/**
 * This class allows to get orders from files before user will start interact with a program
 * 
 * @author Lenovo
 *
 */
public class MyServletContextListener implements ServletContextListener {

	  @Override
	  public void contextDestroyed(ServletContextEvent arg0) {
	  }

	  @Override
	  public void contextInitialized(ServletContextEvent arg0) {
		  OrderRepository.getDatabaseInstance();
	  }

	}