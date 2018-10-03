package com.coreservices.bootcamp.bootcamp;

import com.coreservices.bootcamp.bootcamp.resource.OrderController;

/**
 * 
 * @author Lenovo
 * 	Klasa mainowa, zero logiki, same uruchomienie aplikacji
 */
public class MainApp {

    public static void main(String[] args) {

        OrderController controller = new OrderController();

        
        
        controller.startApplication();
    }

}
