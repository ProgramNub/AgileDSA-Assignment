/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerMaintenance;

/**
 *
 * @author asus
 */
public class Invoice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Invoice ID: IV0001");
        System.out.println("Issued On: 16-12-2018");
        System.out.println("Due Date: 07-01-2019");
        System.out.println("Corporate Name: Super Flower Sdn.Bhd. (CP0001)");
        System.out.println("Billing Address: 129 Jalan Alam Shah, Wangsa Maju, Kuala Lumpur");
        System.out.println("Order ID: OD0001              Ordered On: 21-11-2018");
        System.out.println("*************************************************************************************************");
        System.out.println("Product ID \t Product Name \t Quantity Ordered \t Price Per Unit \t Total");
        System.out.println("*************************************************************************************************");
        System.out.println("P0001 \t\t Rose \t\t\t 5 \t\t 10.00 \t\t\t 50.00");
        System.out.println("*************************************************************************************************");
        System.out.println("\t \t TOTAL: RM50.00");
        System.out.println("PLEASE PAID BY 07-01-2019");
        System.out.println("Have this invoice paid (Y/N): ");
    }
    
}
