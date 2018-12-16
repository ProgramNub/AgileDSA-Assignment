/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InvoicePayment;

import static dsa.CustomerUtility.displayCorporateList;
import Entities.Corporate;
import Entities.Invoice;
import Entities.Item;
import Entities.ItemEnjiun;
import Entities.LinkedList;
import Entities.Order;
import Interfaces.ListInterface;
import dsa.DisplayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desmond Chooi
 */
public class InvoiceUtility {

    private static Scanner sc = new Scanner(System.in);
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    //Method for getting hardcoded Invoice
//    public static ListInterface<Invoice> displayInvoiceList(ListInterface<Order> orderList, ListInterface<Item> itemList){
//        ListInterface<Invoice> invoiceList = new LinkedList<>();
//        
//        ListInterface<Order> corpOrderList = new LinkedList<>();
//        corpOrderList.add(orderList.get(0));
//        corpOrderList.add(orderList.get(1));
//        
//        try {
//            invoiceList.add(new Invoice("IV001", (Corporate)orderList.get(0).getCustomer(), SIMPLE_DATE_FORMAT.parse("31-10-2018"), SIMPLE_DATE_FORMAT.parse("7-11-2018"), corpOrderList));
//        } catch (ParseException ex) {
//            Logger.getLogger(InvoiceUtility.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return invoiceList;
//    }
    //Method to generate Invoice
    public static void generateInvoice(ListInterface<Invoice> invoiceList, ListInterface<Item> itemList, ListInterface<Corporate> corporate, ListInterface<Order> orders) {

        String choice;
        double totalPrice = 0.00;

//        displayCorporateList(filterCorpInvoiceList(invoiceList));
        DisplayList.displayCorporateList(corporate);

        while (true) {
            System.out.print("Enter corporate number: ");
            choice = sc.nextLine();

            if (choice.matches("^[0-9]+$")) {
                break;
            }
            System.out.println("Invalid choice entered. Please try re-enter with only digits that is within the range.\n");

        }

        int i = Integer.parseInt(choice) - 1;
        String corpID = corporate.get(i).getCustID();
        
        
        System.out.println(String.format("\nInvoice ID: %s\n"
                + "Date Generated: %s\n"
                + "Due Date: %s\n"
                + "Corporate Name: (%s) %s\n"
                + "Corporate Address: %s",
                invoiceList.get(i).getInvoiceID(),
                SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getIssuedDate()),
                SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getDueDate()),
                invoiceList.get(i).getCorporate().getCustID(),
                invoiceList.get(i).getCorporate().getCustAddress()));

        //Looping to display the orders for a specific corporate
        //ListInterface<Order> orderList = invoiceList.get(i).getOrder();
        //invoiceHeader(1);
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        for (int b = 0; b < orders.size(); b++) {
            if(orders.get(b).getMonth() == month){
                if (corpID.equals(orders.get(b).getCustomer().getCustID())) {
                    System.out.print(String.format("\nOrder ID: %s \t Ordered on: %s",
                        orders.get(b).getOrderID(), SIMPLE_DATE_FORMAT.format(orders.get(b).getDateOrdered())));
                    
                    for (int c = 0; c < itemList.size(); c++) {
                    if (itemList.get(i).getOrderID().equals(corpID)) {
                    System.out.println(String.format("%-15s \t %-30s \t %5s \t %-10.2f \t -10d",
                            itemList.get(c).getItemID(),
                            itemList.get(c).getItemName(),
                            itemList.get(c).getType(),
                            itemList.get(c).getUnitPrice(),
                            itemList.get(c).getQuantityBought()));
                    //Sum total price
                    totalPrice += itemList.get(c).getUnitPrice() * itemList.get(c).getQuantityBought();
                }
            }
                }
            }

            //Looping to display individual product for a specific order
            
            invoiceHeader(2);
        }

        //Display the total payment for an invoice
        System.out.println(String.format("TOTAL PRICE: RM%.2f", totalPrice));
        System.out.println(String.format("PLEASE PAID BY %s", SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getDueDate())));

        //Check invoice due date whether passed or not yet
        if (new Date().after(invoiceList.get(i).getDueDate())) {
            System.out.println(String.format("Invoice Due Date: %s\n Today's Date: %s\n Invoice already passed the due date. Please made the payment first before you are allowed to make orders and paid using the credits",
                    SIMPLE_DATE_FORMAT.format(invoiceList.get(i).getDueDate()),
                    SIMPLE_DATE_FORMAT.format(new Date())));
        }

        while (true) {
            System.out.print("Have this invoice paid? (Y/N): ");
            choice = sc.nextLine();
            if (choice.matches("^[YynN]$")) {
                break;
            }
            System.out.println("Invalid choice detected. Please try again with only 'Y' or 'N'.");
        }

        if (choice.matches("^[Yy]$")) {
            Corporate corp = (Corporate) invoiceList.get(i).getCorporate();
            corp.setCreditLimit(corp.getCreditLimit() + totalPrice);
            invoiceList.remove(i);
            System.out.println("Payment successfully made. Thank you and have a nice day!\n");
        }

    }

//    //Method to filter corporate list for invoice list
//    private static ListInterface<Corporate> filterCorpInvoiceList(ListInterface<Invoice> invoiceList){
//        ListInterface<Corporate> corpInvoice = new LinkedList<>();
//        for(int i=0; i<invoiceList.size(); i++){
//            if(!corpInvoice.contains(invoiceList.get(i).getCorporate())) {
//                corpInvoice.add(invoiceList.get(i).getCorporate());
//            }
//        }
//        
//        
//        return corpInvoice;
//        
//    }
    //Method for invoice header and footer
    private static void invoiceHeader(int choice) {

        switch (choice) {
            case 1:
                System.out.println("********************************************************************************************************************************");
                System.out.println(String.format("Product ID \t Product Name \t Product Type \t Product Price(Per Unit) \t Quantity Order \t %-20s Total Price", ""));
                System.out.println("********************************************************************************************************************************");
                break;
            case 2:
                System.out.println("********************************************************************************************************************************");

        }
    }

}
