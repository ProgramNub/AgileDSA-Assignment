/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Item;
import Entities.LinkedList;
import Interfaces.ListInterface;
import java.util.Scanner;
import Interfaces.Product;
import Entities.Order;
import Interfaces.Product;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Enjiun Tan
 */
public class CatalogueOrder {

    //public static void orderMain(ListInterface<Product> flowers, ListInterface<Item> realItems,ListInterface<Product> bouquets, ListInterface<Corporate> corporates,ListInterface<Consumer> consumers,ListInterface<Product> arangements, ListInterface<Item> items,  ListInterface<Order> orders) {
    public static void orderMain(ListInterface<Product> products, ListInterface<Corporate> corporates,ListInterface<Consumer> consumers, ListInterface<Item> items,  ListInterface<Order> orders) {
        Scanner scan = new Scanner(System.in);

 
        //Check whether is individual or corporate customer
        String cust;

        do {

            System.out.print("Individual or corporate customer? (I/C): ");
            cust = scan.nextLine();
            if (!cust.matches("^[IiCc]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!cust.matches("^[IiCc]$"));

        System.out.println("");
        String cons;
        if (cust.matches("^[Ii]$")) {   
        //Choose customer for order
            do {
                DisplayList.displayConsumerList(consumers);
            
                System.out.print("Choose customer number: ");
                cons = scan.nextLine();
                if (!cons.matches("^[1-" + (consumers.size() + 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!cons.matches("^[1-" + (consumers.size() + 1) + "]$"));
        } else {
                
            do {
                DisplayList.displayCorporateList(corporates);
                System.out.print("Choose corporate number: ");
                cons = scan.nextLine();
                if (!cons.matches("^[1-" + (corporates.size() + 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!cons.matches("^[1-" + (corporates.size() + 1) + "]$"));
        }

        //Let user choose what they want to order
        String type;
        
        String ans;
        do {
            do {
                String p = "Flower";
                System.out.println("1. Fresh Flowers");
                System.out.println("2. Bouquets");
                System.out.println("3. Floral Arrangements");
                System.out.print("Please choose the product type: ");
                type = scan.nextLine();

                if (type.equals("1")) {
                    ItemOrder.Ordering(items, products, p);
                } else if (type.equals("2")) {
                    p = "Bouquet";
                    ItemOrder.Ordering(items, products, p);
                } else if (type.equals("3")) {
                    Arrangements();
                } else if (!type.matches("^[1-3]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!type.matches("^[1-3]$"));

            do {
                System.out.print("Would you like to add something else(Y/N)?");
                ans = scan.nextLine();
                if (!ans.matches("^[YyNn]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!ans.matches("^[YyNn]$"));
        } while (ans.matches("^[Yy]$"));

        
        
        
        
        
        //Display order
        double orderFlwPrice = 0;
        double orderBqtPrice = 0;

        

        System.out.println("Name  Quantity Ordered Unit Price");
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType() == 'F') {
                System.out.println(items.get(i).getItemName() + " " + items.get(i).getQuantityBought() + " " + items.get(i).getUnitPrice());
                orderFlwPrice += items.get(i).getUnitPrice();
            }
        }
        System.out.println("Flower total price: RM" + orderFlwPrice);

        System.out.println("");

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType() == 'B') {
                System.out.println(items.get(i).getItemName() + " " + items.get(i).getQuantityBought() + " " + items.get(i).getUnitPrice());
                orderBqtPrice += items.get(i).getUnitPrice();
            }
        }

        System.out.println("Bouquet total price: RM" + orderBqtPrice);
        System.out.println("");
        System.out.println("Total price : RM" + (orderFlwPrice + orderBqtPrice));

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a ");
        System.out.println("Date: " + ft.format(dNow));
        //Date orderDate =  ft.parse(dNow); 

        String delPick;
        do {
            System.out.print("Would you like to have your order delivered or picked up(D/P)?");
            delPick = scan.nextLine();
            if (!delPick.matches("^[DdPp]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!delPick.matches("^[DdPp]$"));
        System.out.println("");

        String dateString;
        Date receiveDate = new Date();
        do {
            System.out.print("Please enter date for receive (dd-mm-yy):");
            dateString = scan.nextLine();
            if (!dateString.matches("^\\d{2}-\\d{2}-\\d{2}$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!dateString.matches("^\\d{2}-\\d{2}-\\d{2}$"));
        try {

            DateFormat df = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH);
            receiveDate = df.parse(dateString);
        } catch (ParseException e) {

        }

        String hour;
        do {
            System.out.print("Please enter time for receive (hh):");
            hour = scan.nextLine();
            if (!hour.matches("^([1-9]|1[0-9]|2[0-4])$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!hour.matches("^([1-9]|1[0-9]|2[0-4])$"));

        String orderID = String.format("O%03d", orders.size() + 1);
        String orderRef = consumers.get(Integer.parseInt(cons) - 1).getCustID();;

//        if (delPick.matches("^[Pp]$")) {
//            if (cust.matches("^[Ii]$")) {
//                orderID = String.format("O%03d", orders.size() + 1);
//                orderRef = Consumer.get(Integer.parseInt(cons) - 1).getCustID();
//            } else {
//                int orderNum = 0;
//                orderNum++;
//                orderID += "PC" + orderNum;
//                orderRef = Corporate.get(Integer.parseInt(cons) - 1).getCustID();
//            }
//        } else {
//            if (cust.matches("^[Ii]$")) {
//                int orderNum = 0;
//                orderNum++;
//                orderID += "DI" + orderNum;
//                orderRef = Consumer.get(Integer.parseInt(cons) - 1).getCustAddress();
//            } else {
//                int orderNum = 0;
//                orderNum++;
//                orderID += "DC" + orderNum;
//                orderRef = Corporate.get(Integer.parseInt(cons) - 1).getCustAddress();
//            }
//        }

        orders.add(new Order(orderID, items, (orderFlwPrice + orderBqtPrice), dNow, receiveDate, Integer.parseInt(hour), 'U', delPick.charAt(0), orderRef));
        //MainMenu.main();

    }

    public static void Arrangements() {
        /*Problems
            sales order cannot mix same item
            date format not correct
            hour receive checking something wrong*/
    }
}
