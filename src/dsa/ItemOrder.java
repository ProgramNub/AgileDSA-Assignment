/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Customer;
import Entities.Product;
import Entities.Item;
import Entities.LinkedList;
import Entities.Order;
import Interfaces.ListInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ItemOrder {

    public static ListInterface<Item> Ordering(ListInterface<Product> products, ListInterface<Item> items, String bp, Customer customer, ListInterface<Corporate> corporates, ListInterface<Order> orders, ListInterface<Consumer> consumers, Boolean paid, Boolean checked) {

        Scanner scan = new Scanner(System.in);
        Item item = new Item();
        Order order = new Order();

        String ans, n, qty, credExceed, sp = bp.toLowerCase();
        double productTtlPrice;
        char t;

        if (bp.equals("Flower")) {
            t = 'F';
        } else {
            t = 'B';
        }

        ListInterface<String> itemID = new LinkedList<>();
        ListInterface<Product> tempList = new LinkedList<>();

        //Choose what flower and how much
        do {
            do {

                tempList = DisplayList.displayProductList(products, bp, t);
                System.out.print("Please choose the " + sp + " that you wish to buy [1-" + tempList.size() + "]:");
                n = scan.nextLine();
                if (!n.matches("^[1-" + tempList.size() + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                } else if (tempList.get(Integer.parseInt(n) - 1).getProductQuantity() == 0) {
                    System.out.println("Please choose a " + sp + " that is not sold out.");
                }
            } while (!n.matches("^[1-" + tempList.size() + "]$") || tempList.get(Integer.parseInt(n) - 1).getProductQuantity() == 0);

            do {
                System.out.print("Please number of " + sp + " you wish to buy:");
                qty = scan.nextLine();
                if (!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < tempList.get(Integer.parseInt(n) - 1).getProductQuantity()) {
                    System.out.println("Please enter a valid quantity.");
                }
            } while (!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < tempList.get(Integer.parseInt(n) - 1).getProductQuantity());

            //Add in total price
            
            LocalDate today = LocalDate.now();
            int month = today.getMonthValue();
            if (month == tempList.get(Integer.parseInt(n) - 1).getDiscountMonth()) {
                double newPrice = (tempList.get(Integer.parseInt(n) - 1).getProductPrice() * (100 - tempList.get(Integer.parseInt(n) - 1).getDiscount()) / 100);
                productTtlPrice = item.calculateBill(newPrice, Integer.parseInt(qty));
            } else {
                productTtlPrice = item.calculateBill(tempList.get(Integer.parseInt(n) - 1).getProductPrice(), Integer.parseInt(qty));
            }

            //for corporates
            if (customer.getCustType() == 'C') {

                Corporate corp = new Corporate();
                corp = corp.searchCorp(customer, corporates, corp);

                if (productTtlPrice > corp.getCreditLimit()) {
                    if (checked == false) {
                        do {
                            System.out.println("This item has exceeded the credit limit.");
                            System.out.print("Do you want to continue Order(payment by cash), Set order or Cancel order(O/S/C):");
                            credExceed = scan.nextLine();
                            if (!credExceed.matches("^[OoSsCc]$")) {
                                System.out.println("Incorrect input, please enter input as listed.");
                            } else if (credExceed.matches("^[Oo]$")) {
                                checked = true;
                                break;
                            } else if (credExceed.matches("^[Ss]$")) {
                                ItemOrder.salesOrder(products, corporates, consumers, items, orders, false, customer);
                            } else if (credExceed.matches("^[Cc]$")) {
                                MainMenu.main(products, corporates, consumers, items, orders);
                            }
                        } while (!credExceed.matches("^[IiCc" + t + Character.toLowerCase(t) + "]$"));
                    }
                } else {
                    item.corpCredit(paid, corp, productTtlPrice);
                    order.setStatus('P');
                }
            }

            //Add ordered item
            item = new Item(tempList.get(Integer.parseInt(n) - 1).getProductID(), tempList.get(Integer.parseInt(n) - 1).getProductName(), t, productTtlPrice, Integer.parseInt(qty));

            items = item.sortItemList(products, itemID, items, item, qty, productTtlPrice);

            //checking
            do {
                System.out.print("Do you want to buy another " + sp + "(Y/N):");
                ans = scan.nextLine();
                if (!ans.matches("^[YyNn]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!ans.matches("^[YyNn]$"));

        } while (ans.matches("^[Yy]$"));

        return items;
    }

    public static void salesOrder(ListInterface<Product> products, ListInterface<Corporate> corporates, ListInterface<Consumer> consumers, ListInterface<Item> items, ListInterface<Order> orders, boolean paid, Customer customer) {
        Scanner scan = new Scanner(System.in);
        //Display order
        String dateString, delPick, hour;
        double orderFlwPrice = 0, orderBqtPrice = 0, orderTtlPrice = 0;

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
        orderTtlPrice = orderFlwPrice + orderBqtPrice;
        System.out.println("Bouquet total price: RM" + orderBqtPrice);
        System.out.println("");
        System.out.println("Total price : RM" + orderTtlPrice);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a ");
        System.out.println("Date: " + ft.format(dNow));

        do {
            System.out.print("Would you like to have your order delivered or picked up(D/P)?");
            delPick = scan.nextLine();
            if (!delPick.matches("^[DdPp]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!delPick.matches("^[DdPp]$"));
        System.out.println("");

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

        do {
            System.out.print("Please enter time for receive (hh):");
            hour = scan.nextLine();
            if (!hour.matches("^([1-9]|1[0-9]|2[0-4])$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!hour.matches("^([1-9]|1[0-9]|2[0-4])$"));

        Order order = new Order();
        boolean add = order.addOrder(items, orders, customer, order.getDone(), delPick, hour, orderTtlPrice, dNow, receiveDate);
        System.out.print(orders);
        if (add == true) {
            System.out.println("Order Made.");
        } else {
            System.out.println("Order Failed.");
        }

        MainMenu.main(products, corporates, consumers, items, orders);

    }
}
