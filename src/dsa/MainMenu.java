/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Invoice;
import Entities.Item;
import Entities.LinkedList;
import Entities.Order;
import Entities.Product;

import Interfaces.ListInterface;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class MainMenu {

    public static void main(String[] args) {

        ListInterface<Item> items = new LinkedList<>();
        Dummies.itemList(items);
        ListInterface<Product> products = new LinkedList<>();
        Dummies.ProductList(products);
        ListInterface<Order> orders = new LinkedList<>();
        ListInterface<Consumer> consumers = new LinkedList<>();
        Dummies.ConsumerList(consumers);
        ListInterface<Corporate> corporates = new LinkedList<>();
        Dummies.CorporateList(corporates);
        ListInterface<Invoice> Invoice = new LinkedList<>();
        Dummies.OrderList(products, corporates, orders);

        main(products, corporates, consumers, items, orders, Invoice);

        /*
         See if can combine function such as update or order flower
         Standardize display of lists
         */
    }

    public static void main(ListInterface<Product> products, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, ListInterface<Item> items, ListInterface<Order> orders, ListInterface<Invoice> invoice) {
        // public static void main(){
        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Fiore Flower Shop");
            System.out.println("1.Customer");
            System.out.println("2.Products");
            System.out.println("3.Order");
            System.out.println("4.Exit");
            System.out.print("Please choose what you want to do:");
            choice = scan.nextLine();
            if (choice.equals("1")) {
                CustomerMenu.CustomerMenu(consumers, corporates, items, orders, invoice);
            } else if (choice.equals("2")) {
                
            } else if (choice.equals("3")) {
                CatalogueOrder.custInfo(products, corporates, consumers, items, orders, invoice);
            } else if (choice.equals("4")) {
                System.exit(0);
            } else if (!choice.matches("^[1-4]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!choice.matches("^[1-4]$"));
    }

}
