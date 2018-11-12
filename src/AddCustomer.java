/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author asus
 */
public class AddCustomer {
    public static void main (String[] args){
        List<Customer> customer = new ArrayList<>();
        String custName;
        String custAddress;
        String custContact;
        String custType;
        double custCredit = 0;
        
        
        Customer cust = new Customer();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter customer name: ");
        custName = sc.nextLine();   
        while(!custName.matches("[a-zA-Z, ]+")){
          System.out.println("Please do not leave this space blank!");
          System.out.println("Please enter customer name: ");
          custName = sc.nextLine(); 
        }
        
        System.out.println("Please enter customer address: ");
        custAddress = sc.nextLine();
        while(!custAddress.matches("[a-zA-Z,0-9, ]+")){
          System.out.println("Please do not leave this space blank!");
          System.out.println("Please enter customer address: ");
          custAddress = sc.nextLine(); 
        }
        
        System.out.println("Please enter customer contact number: ");
        custContact = sc.nextLine();
        while(!custContact.matches("\\d{3}-\\d{7}")){
          System.out.println("Contact number must be in the form XXX-XXXXXXX");
          System.out.println("Please enter customer contact number: ");
          custContact= sc.nextLine(); 
        }

        
        System.out.println("Please enter customer type (Consumer/Corporate): ");
        custType = sc.nextLine();
        while(!custType.matches("[a-zA-Z, ]+")){
          System.out.println("Please do not leave this space blank!");
          System.out.println("Please enter customer type: ");
          custType = sc.nextLine(); 
        }
        
        customer.add(new Customer(custName, custAddress, custContact, custType, custCredit));

        cust = customer.get(0);
        System.out.println(cust);
        
        System.out.println("Please enter customer name: ");
        custName = sc.nextLine();
        while(!custName.matches("[a-zA-Z, ]+")){
          System.out.println("Please do not leave this space blank!");
          System.out.println("Please enter customer name: ");
          custName = sc.nextLine(); 
        }
        
        for(int i = 0; i < customer.size(); i++){
            if(custName.equals(customer.get(i).getName())&&(customer.get(i).getCustType()).equals("Corporate")){
                
                System.out.println("Please enter the credit limit: ");
                custCredit = sc.nextDouble();
                System.out.println("Customer Type: " + custType + ", Credit Limit: " + String.format("%.2f", custCredit));            
            }
        }
        
        
        
        
    }
}
