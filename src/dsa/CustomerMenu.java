
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Corporate;
import Entities.Consumer;
import Entities.Invoice;
import Entities.Item;
import Entities.LinkedList;
import Entities.Order;
import Entities.Product;
import Interfaces.ListInterface;
import InvoicePayment.InvoiceUtility;
import dsa.Dummies;


/**
 *
 * @author Desmond Chooi
 */
public class CustomerMenu {

    /**
     * @param args the command line arguments
     */
    
    public static void CustomerMenu(ListInterface<Consumer> Consumer , ListInterface<Corporate> Corporate, ListInterface<Item> itemList, ListInterface<Order> orderList, ListInterface<Invoice> Invoice ) {
        // TODO code application logic here
        
        
        
        while(true){
            int choice = CustomerUtility.mainMenu();
            
            if(choice == 1){
                CustomerUtility.registerNewCustomer(Consumer, Corporate);
            }else if(choice ==  2){
                CustomerUtility.displayCustomer(Consumer, Corporate);
            }else if(choice == 3){
                CustomerUtility.updateCustomer(Consumer, Corporate);
            }else if(choice == 4){
                InvoiceUtility.generateInvoice(Invoice, itemList, Corporate, orderList);
            }else if(choice == 5){
                System.out.println("Bye Bye");
                break;
            }
        }
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Corporate;
import Entities.Consumer;
import Interfaces.ListInterface;
import java.util.Scanner;


/**
 *
 * @author Desmond Chooi
 */
public class CustomerMenu {
    
    public static void customerMain(ListInterface<Consumer> Consumer, ListInterface<Corporate> Corporate) {
           
        while(true){
            int choice = CustomerMaintenanceMenu();
            
            if(choice == 1){
                CustomerUtility.registerNewCustomer(Consumer, Corporate);
            }else if(choice ==  2){
                CustomerUtility.displayCustomer(Consumer, Corporate);
            }else if(choice == 3){
                CustomerUtility.updateCustomer(Consumer, Corporate);
            }else if(choice == 4){
                //MainMenu.main();
            }
        }
    }
    
    //Method for Customer Maintenance Menu
    public static int CustomerMaintenanceMenu() {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        while (true) {
            System.out.println("=======Customer Maintenance============\n"
                    + "1. Customer Registration\n"
                    + "2. Display List of Customers\n"
                    + "3. Update Customer Details\n"
                    + "4. Back\n");
            System.out.print("Please enter 1-4 only:");
            choice = scan.nextLine();
            if (choice.matches("^[1-4]$")) {
                break;
            }
            System.out.println("Invalid choice! Please select only 1 to 4!");

        }
        return Integer.parseInt(choice);
    }
    
    public static void displayCategoryMenu(ListInterface<Consumer> consumers, ListInterface<Corporate> corporates) {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        while (true) {
            System.out.println("======Display Customer Category======\n"
                    + "1. View Consumer List\n"
                    + "2. View Corporate List\n"
                    + "3. Exit");
            System.out.print("Please enter 1-3 only:");
            choice = scan.nextLine();
            if (choice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("Invalid choice! Please select only from 1-3!");
        }

        //Method for menu of displaying Consumer/Corporate
        if (choice.equals("1")) {
            DisplayList.displayConsumerList(consumers);
        } else if (choice.equals("2")) {
            DisplayList.displayCorporateList(corporates);
        }
    }
    
}

