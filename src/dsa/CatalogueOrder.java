/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.ItemEnjiun;
import Entities.LinkedList;
import Interfaces.ListInterface;
import java.util.Scanner;
import Entities.ProductEnjiun;
import Entities.Order;
import static dsa.SalesOrder.findDuplicates;
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

    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);

        //Create Lists
        ListInterface<ItemEnjiun> items = new LinkedList<>();
        ListInterface<ProductEnjiun> flowers = new LinkedList<>();
        ListInterface<ProductEnjiun> bouquets = new LinkedList<>();
        ListInterface<Order> orders = new LinkedList<>();
        ListInterface<Consumer> Consumer = new LinkedList<>();
        ListInterface<Corporate> Corporate = new LinkedList<>();
        ListInterface<ItemEnjiun> realItems = new LinkedList<>();

        //Add dummies into lists
        flowers.add(new ProductEnjiun("F001", "Rose", 'F', 6.00, 0));
        flowers.add(new ProductEnjiun("F002", "Sunflower", 'F', 7.00, 50));
        flowers.add(new ProductEnjiun("F003", "Lavender", 'F', 8.00, 50));

        bouquets.add(new ProductEnjiun("B001", "Oval shaped", 'B', 6.00, 0));
        bouquets.add(new ProductEnjiun("B002", "Cresent shaped", 'B', 7.00, 50));
        bouquets.add(new ProductEnjiun("B003", "Square shaped", 'B', 8.00, 50));

        Consumer.add(new Consumer("I001", "Eden Hazard", "Block 20-2, Cardinal Apartment, Oklahama", "012-1286421", 'I'));
        Consumer.add(new Consumer("I002", "Alvaro Morata", "Block 90-1-4, Taman Apartment, Rawang, Selangor", "011-2134143", 'I'));
        Consumer.add(new Consumer("I003", "Alan", "No.32, Taman Alma, Butterworth, Penang", "019-2483263", 'I'));
        Consumer.add(new Consumer("I004", "Martin", "No.44, Taman Sri Rampai, Wangsa Maju, Kuala Lumpur", "018-2785832", 'I'));

        Corporate.add(new Corporate("C001", "Super Flower Sdn.Bhd.", "129 Jalan Alam Shah, Wangsa Maju, Kuala Lumpur", "08-8421412", 990.00, 'C'));
        Corporate.add(new Corporate("C002", "Goh Marriage Sdn.Bhd.", "13 Jalan Perindustrian 16, Bayan Lepas, Pulau Pinang", "04-3435234", 1990.00, 'C'));
        Corporate.add(new Corporate("C003", "North Face Ltd.", "10 Jalan Sultan Ahmad Shah, Rawang, Selangor", "08-8214532", 1500.00, 'C'));
        Corporate.add(new Corporate("C004", "ChocoPoker Ltd. ", "91 Jalan Perindustrian Ipoh, Ipoh, Perak", "05-5242234", 1690.00, 'C'));

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
            System.out.println("==============Customer List=============");
            for (int i = 0; i < Consumer.size(); i++) {
                System.out.println(String.format("%d. %-20s \t %-50s \t %-12s", i + 1,
                        Consumer.get(i).getConsumerName(), Consumer.get(i).getCustAddress(),
                        Consumer.get(i).getCustContact()));
            }
            //Choose customer for order

            do {
                System.out.print("Choose customer number: ");
                cons = scan.nextLine();
                if (!cons.matches("^[1-" + (Consumer.size() + 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!cons.matches("^[1-" + (Consumer.size() + 1) + "]$"));
        } else {
            System.out.println("=======Corporate List==========");
            for (int i = 0; i < Corporate.size(); i++) {
                System.out.println(String.format("%d. %-20s \t %-50s \t %-12s \t %-6.2f", i + 1,
                        Corporate.get(i).getCorporateName(), Corporate.get(i).getCustAddress(),
                        Corporate.get(i).getCustContact(), Corporate.get(i).getCreditLimit()));
            }
            do {
                System.out.print("Choose corporate number: ");
                cons = scan.nextLine();
                if (!cons.matches("^[1-" + (Corporate.size() + 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!cons.matches("^[1-" + (Corporate.size() + 1) + "]$"));
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
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getType() == 'F') {
//                System.out.println(items.get(i).getName() + " " + items.get(i).getQuantity() + " " + items.get(i).getPrice());
//                orderFlwPrice += items.get(i).getPrice();
//            }
//        }
//        System.out.println("Flower total price: RM" + orderFlwPrice);
//
//        System.out.println("");
//
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getType() == 'B') {
//                System.out.println(items.get(i).getName() + " " + items.get(i).getQuantity() + " " + items.get(i).getPrice());
//                orderBqtPrice += items.get(i).getPrice();
//            }
//        }

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
            if (!hour.matches("^[1-24]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!hour.matches("^[1-24]$"));

        String orderID = "";
        String orderRef;
        if (delPick.matches("^[Pp]$")) {
            if (cust.matches("^[Ii]$")) {
                int orderNum = 0;
                orderNum++;
                orderID += "PI" + orderNum;
                orderRef = Consumer.get(Integer.parseInt(cons) - 1).getCustID();
            } else {
                int orderNum = 0;
                orderNum++;
                orderID += "PC" + orderNum;
                orderRef = Corporate.get(Integer.parseInt(cons) - 1).getCustID();
            }
        } else {
            if (cust.matches("^[Ii]$")) {
                int orderNum = 0;
                orderNum++;
                orderID += "DI" + orderNum;
                orderRef = Consumer.get(Integer.parseInt(cons) - 1).getCustAddress();
            } else {
                int orderNum = 0;
                orderNum++;
                orderID += "DC" + orderNum;
                orderRef = Corporate.get(Integer.parseInt(cons) - 1).getCustAddress();
            }
        }

        orders.add(new Order(orderID, realItems, (orderFlwPrice + orderBqtPrice), dNow, receiveDate, Integer.parseInt(hour), 'U', delPick.charAt(0), orderRef));
        System.out.print(orders.get(0));

    }

    public static void Arrangements() {
        /*Problems
            sales order cannot mix same item
            date format not correct
            hour receive checking something wrong*/
    }
}
