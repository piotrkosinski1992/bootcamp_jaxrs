package com.coreservices.bootcamp;

import com.coreservices.bootcamp.repository.GenericRepository;

public class Main {

	public static void main(String[] args) {
		GenericRepository repo = GenericRepository.initializeDatabaseConnection();
		
	}

}
