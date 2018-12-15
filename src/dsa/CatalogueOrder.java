/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Customer;
import Entities.Item;
import Interfaces.ListInterface;
import java.util.Scanner;
import Entities.Order;
import Entities.Product;

/**
 *
 * @author Enjiun Tan
 */
public class CatalogueOrder {

    public static void custInfo(ListInterface<Product> products, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, ListInterface<Item> items, ListInterface<Order> orders) {
        Scanner scan = new Scanner(System.in);

        //Check whether is individual or corporate customer
        String cust, cons;
        boolean paid = false, checked = false;

        do {

            System.out.print("Individual or corporate customer? (I/C): ");
            cust = scan.nextLine();
            if (!cust.matches("^[IiCc]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!cust.matches("^[IiCc]$"));
        System.out.println("");
        Customer customer = new Customer();
        if (cust.matches("^[Ii]$")) {
            //ConsumerList
            do {
                DisplayList.displayConsumerList(consumers);

                System.out.print("Choose customer number: ");
                cons = scan.nextLine();
                if (!cons.matches("^[1-" + (consumers.size() + 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!cons.matches("^[1-" + (consumers.size() + 1) + "]$"));
            customer = consumers.get(Integer.parseInt(cons) - 1);
        } else {
            //Corporate List
            do {
                DisplayList.displayCorporateList(corporates);
                System.out.print("Choose corporate number: ");
                cons = scan.nextLine();
                if (!cons.matches("^[1-" + (corporates.size() + 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!cons.matches("^[1-" + (corporates.size() + 1) + "]$"));
            customer = corporates.get(Integer.parseInt(cons) - 1);
        }

        //orderMain(products, corporates, consumers, items, orders);
        orderMain(products, customer, items, orders, corporates, consumers, paid, checked);
    }

    //public static void orderMain(ListInterface<Product> products, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, ListInterface<Item> items, ListInterface<Order> orders) {
    public static void orderMain(ListInterface<Product> products, Customer customer, ListInterface<Item> items, ListInterface<Order> orders, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, Boolean paid, Boolean checked) {
        Scanner scan = new Scanner(System.in);
        //Let user choose what they want to order
        Order order = new Order();
        String type, ans;
        do {

            do {

                String p = "Flower";
                System.out.println("1. Fresh Flowers");
                System.out.println("2. Bouquets");
                System.out.println("3. Floral Arrangements");
                System.out.print("Please choose the product type: ");
                type = scan.nextLine();

                if (type.equals("1") || type.equals("2")) {
                    if(type.equals("2"))
                        p = "Bouquet";
                    ItemOrder.Ordering(products, items, p, customer, corporates, orders, consumers, paid, checked);
                } else if (type.equals("3")) {
                    Arrangements();
                } else if (type.equals("4")) {
                    break;
                } else if (!type.matches("^[1-4]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!type.matches("^[1-4]$"));
            checked = order.getChecked();
            do {
                System.out.print("Would you like to add something else(Y/N)?");
                ans = scan.nextLine();
                if (!ans.matches("^[YyNn]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!ans.matches("^[YyNn]$"));
        } while (ans.matches("^[Yy]$"));

        paid = order.getDone();

        ItemOrder.salesOrder(products, corporates, consumers, items, orders, paid, customer);
        
        

    }

    public static void Arrangements() {

    }
}
