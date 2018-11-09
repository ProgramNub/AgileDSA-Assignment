/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class AddCustomer {
    public static void main (String[] args){
        //List<Customer> Customer = new ArrayList<>();
        String CustName;
        String CustID;
        int ContactNo;
        
                
        Scanner one = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        CustName = one.next();
        
        Scanner two = new Scanner(System.in);
        System.out.println("Please enter your Customer ID: ");
        CustID = two.next();
        
        Scanner three = new Scanner(System.in);
        System.out.println("Please enter your contact number: ");
        ContactNo = three.nextInt();
        
        System.out.println("Your name is " + CustName + ", Customer ID is " + CustID + ", Contact No is " + ContactNo);
        
        
        
        
        //Customer cust = new Customer(name, CustID, ContactNo);
        
    }
}
