package com.coreservices.bootcamp.bootcamp.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.coreservices.bootcamp.bootcamp.entity.Order;
import com.coreservices.bootcamp.bootcamp.tools.BasicOrderFileReader;
import com.coreservices.bootcamp.bootcamp.tools.CSVFileReader;



/**
 * 
 * @author Lenovo
 *	Klasa odpowiedzialna za przygotowanie "bazy" w postaci listy zam�wie�. Jest singletonem �eby by�a jedna instancja i �eby tylko raz zbiera� zam�wienia z plik�w
 */
public class GenericRepository {


    private final String ORDERS_DIRECTORY = "orders";
    private BasicOrderFileReader fileReader;

    private List<Order> orders;


    public GenericRepository(){
        orders = new ArrayList<Order>();
        getOrderObjectList();
    };

    private List<Order> getOrderObjectList(){

        File[] listOfOrderFiles = getOrderFiles();

        for(File file : listOfOrderFiles) {
            String fileName = file.getName();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            if(extension.equals(".csv")) {
                fileReader = new CSVFileReader();
                orders.addAll(fileReader.getOrdersFromFile(file));
            } else if(extension.equals(".xml")) {
//                getOrdersFromXMLFile(file);
            }
        }

        return orders;
    }

    private File[] getOrderFiles() {
        File folder = new File(getClass().getClassLoader().getResource("orders").getPath());
        return folder.listFiles();
    }

    public List<Order> getOrders() {
        return orders;
    }


}
