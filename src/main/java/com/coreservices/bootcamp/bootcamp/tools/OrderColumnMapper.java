package com.coreservices.bootcamp.bootcamp.tools;
//package bootcamp.tools;
//
//import java.util.Arrays;
//
//import bootcamp.entity.Order;
//

// Tu zacz��em brn�� ale si� wycofa�em. Bo ka�dy plik z zam�wieniami zaczyna si� linijk� z kolumnami jakie s� w zam�wieniu. I chcia�em 
// za�o�y� �� kolejno�� tych kolumn w plikach mo�e si� r�nich i chcia�em jako� sprytnie to mapowa� ale ostatecznie stwierdzi�em
// �e w zadaniu nie ma mowy o takich sytuacjach :D




//public class OrderColumnMapper {
//
//
//
//
//    private static String[] orderColumns = new String[5];
//
//
//    public static void storeColumnMapping(String[] orderLine) {
//        orderColumns[0] = orderLine[0];
//        orderColumns[1] = orderLine[1];
//        orderColumns[2] = orderLine[2];
//        orderColumns[3] = orderLine[3];
//        orderColumns[4] = orderLine[4];
//    }
//
//    public static Order mapColumnsToOrderObject(String[] orderLine) {
//        Order order = new Order();
//
//        order.setClientId(orderLine[getClientIdColumnNumber()]);
//
//
//        return null;
//    }
//
//    private static int getClientIdColumnNumber() {
//    	int idColumnNumber = -1;
//
//        for(int i = 0 ; i < orderColumns.length ; i++) {
//            if(orderColumns[i].equals("Client_Id")) {
//                return i;
//            }
//        }
//
//    }
//}
