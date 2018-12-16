
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Customer;
import Entities.Invoice;
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

    public static void custInfo(ListInterface<Product> products, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, ListInterface<Item> items, ListInterface<Order> orders, ListInterface<Invoice> invoice) {
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
        orderMain(products, customer, items, orders, corporates, consumers, paid, checked, invoice);
    }

    //public static void orderMain(ListInterface<Product> products, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, ListInterface<Item> items, ListInterface<Order> orders) {
    public static void orderMain(ListInterface<Product> products, Customer customer, ListInterface<Item> items, ListInterface<Order> orders, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, Boolean paid, Boolean checked, ListInterface<Invoice> invoice) {
        Scanner scan = new Scanner(System.in);
        //Let user choose what they want to order
        Order order = new Order();
        String type, ans, orderId = "";
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
                    orderId = String.format("O%03d", orders.size() + 1);
                    paid = ItemOrder.Ordering(products, items, p, customer, corporates, orders, consumers, paid, checked, orderId, invoice);
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

        

        ItemOrder.salesOrder(products, corporates, consumers, items, orders, paid, customer, orderId, invoice);
        
        
        

    }

    public static void Arrangements() {

    }
}
=======
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
//import static dsa.SalesOrder.findDuplicates;
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
    public static void orderMain(ListInterface<Product> flowers, ListInterface<Item> realItems,ListInterface<Product> bouquets, ListInterface<Corporate> corporates,ListInterface<Consumer> consumers, ListInterface<Item> items,  ListInterface<Order> orders) {
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

                System.out.println("1. Fresh Flowers");
                System.out.println("2. Bouquets");
                System.out.println("3. Floral Arrangements");
                System.out.print("Please choose the product type: ");
                type = scan.nextLine();

                if (type.equals("1")) {
                    FlowerOrder.FreshFlowers(items, flowers);
                } else if (type.equals("2")) {
                    BouquetOrder.Bouquet(items, bouquets);
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

        //realItems.addAll(findDuplicates(items));
        realItems = items;

        System.out.println("Name  Quantity Ordered Unit Price");
        for (int i = 0; i < realItems.size(); i++) {
            if (realItems.get(i).getType() == 'F') {
                System.out.println(realItems.get(i).getItemName() + " " + realItems.get(i).getQuantityBought() + " " + realItems.get(i).getUnitPrice());
                orderFlwPrice += realItems.get(i).getUnitPrice();
            }
        }
        System.out.println("Flower total price: RM" + orderFlwPrice);

        System.out.println("");

        for (int i = 0; i < realItems.size(); i++) {
            if (realItems.get(i).getType() == 'B') {
                System.out.println(realItems.get(i).getItemName() + " " + realItems.get(i).getQuantityBought() + " " + realItems.get(i).getUnitPrice());
                orderBqtPrice += realItems.get(i).getUnitPrice();
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

        orders.add(new Order(orderID, realItems, (orderFlwPrice + orderBqtPrice), dNow, receiveDate, Integer.parseInt(hour), 'U', delPick.charAt(0), orderRef));
        //MainMenu.main();

    }

    public static void Arrangements() {
        /*Problems
            sales order cannot mix same item
            date format not correct
            hour receive checking something wrong*/
    }
}

