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

import Entities.Order;

import Interfaces.ListInterface;
import InvoicePayment.InvoiceUtility;



/**
 *
 * @author Desmond Chooi
 */
public class CustomerMenu {

    /**
     * @param Consumer
     * @param Corporate
     * @param itemList
     * @param orderList
     * @param Invoice
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
