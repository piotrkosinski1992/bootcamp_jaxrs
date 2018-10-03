package com.coreservices.bootcamp.bootcamp.resource;

import java.util.Scanner;

import com.coreservices.bootcamp.bootcamp.service.OrderService;



/**
 * 
 * @author Lenovo
 *	W teorii miejsce do odbierania wartosci od uzytkownika i przekazywanie do jej dalej do serwisu. W praktyce w serwisie tez odpytuje o warto�ci :(
 */
public class OrderController {

    private Scanner sc;

    private OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }


    public void startApplication() {

        sc = new Scanner(System.in);

        while(true) {
            System.out.println("\nWelcome to order management center !\n"
                    + "What whould you like to proceed ?\n"
                    + "(1) - Show print order options\n"
                    + "(2) - Show generate raport options\n"
                    + "(0) - Exit");

            int requestNumber = sc.nextInt();

            if(requestNumber == 1){
                showPrintOptions();
                proceedUserPrintRequest(sc.nextInt());
            } else if(requestNumber == 2) {
                showRaportOptions();
                proceedUserRaportRequest(sc.nextInt());
            } else {
            	System.out.println("\n bye");
            	System.exit(0);
            }
        }
   }

    private void showPrintOptions() {
        System.out.println("Welcome to order management center !\n"
                + "What whould you like to proceed ? (Choose number from 1 - x)\n"
                + "(1) - Print total amount of orders\n"
                + "(2) - Print amount of orders of particular client\n"
                + "(3) - Print total Sum of orders\n"
                + "(4) - Print Sum of orders from particular client\n"
                + "(5) - Print list of all orders\n"
                + "(6) - Print list of orders from particular client\n"
                + "(7) - Print AVG of orders\n"
                + "(8) - Print AVG of orders from particular client\n\n"
                + "__________________________________________________\n" + "(0) - Exit");

    }

    private void showRaportOptions() {
        System.out.println("Welcome to order management center !\n"
                + "What whould you like to proceed ? (Choose number from 1 - x)\n"
                + "(9) - Generate raport: total amount of orders\n"
                + "(10) - Generate raport: amount of orders of particular client\n"
                + "(11) - Generate raport: total Sum of orders\n"
                + "(12) - Generate raport: Sum of orders from particular client\n"
                + "(13) - Generate raport: list of all orders\n"
                + "(14) - Generate raport: list of orders from particular client\n"
                + "(15) - Generate raport: AVG of orders\n"
                + "(16) - Generate raport: AVG of orders from particular client \n"
                + "____________________________________________________________ \n" + "(0) - Exit");

    }

    /**
     * 
     * Metoda uruchamiaj�ca logik� poszczeg�lnych zada� printowych
     * 
     * @param requestNumber  czyli numer operacji jaki chcesz wykona� je�eli chodzi o zadania do wyprintowania
     */
    private void proceedUserPrintRequest(int requestNumber) {
        switch (requestNumber) {

        case 1:
            orderService.printTotalAmountOfOrders();
            break;
        case 2:
            orderService.printAmountOfOrdersByClientId();
            break;
        case 3:
              orderService.printTotalSumOfAllOrders();
            break;
        case 4:
            orderService.printSumOfClientOrders();
            break;
        case 5:
            orderService.printAllOrders();
            break;
        case 6:
            orderService.printListOfOrdersByClientId();
            break;
        case 7:
              orderService.printAVGPriceOfAllOrders();
            break;
        case 8:
            orderService.getAVGPriceOfOrdersByClientId();
            break;
        case 9:
            orderService.printAllOrdersNowy();
            break;
        }

    }

    /**
     * 
     * Metoda uruchamiaj�ca logik� poszczeg�lnych zada� generowania raportu
     * 
     * @param requestNumber  czyli numer operacji jaki chcesz wykona� je�eli chodzi o zadania do generowania raportu
     */
    private void proceedUserRaportRequest(int requestNumber) {
        switch (requestNumber) {
        case 9:
//            doSomething0();
            break;
        case 10:
//            doSomething1();
            break;
        case 11:
//            doSomething2();
            break;
        case 12:
//            doSomething3();
            break;
        case 13:
//            doSomething4();
            break;
        case 14:
//            doSomethinSg0();
            break;
        case 15:
//            doSomething1();
            break;
        case 16:
//            doSomething2();
            break;
        }

    }

}
