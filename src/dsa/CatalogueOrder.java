/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import dsa.Product;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class CatalogueOrder {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        //Check whether is individual or corporate customer

        char cust = 'I';
        boolean ok = true;
        do{
                
                System.out.print("Individual or corporate customer? (I/C): ");
                cust = scan.next().toUpperCase().charAt(0);
                if(cust != 'I' && cust != 'C'){
                    System.out.println("Incorrect input, please enter input as listed.");
                    ok = false;
                }
//                else if(cust = null){
//                    System.out.println("Incorrect input, please enter input as listed.");
//                    ok = false;
//                }

        }while(cust != 'I' && cust != 'C');

        System.out.println("");
        
        //Create Lists
        List<Item> items = new ArrayList<>();
        List<Product> products = new ArrayList<>();
     
        
        //Add flowers into product list
        Product flower1 = new Product("F001","Rose",'F',6.00,0);
        Product flower2 = new Product("F002","Sunflower",'F',7.00,50);
        Product flower3 = new Product("F003","Lavender",'F',8.00,50);
            products.add(flower1);
            products.add(flower2);
            products.add(flower3);
            
        Product bouquet1 = new Product("B001","Oval shaped",'B',6.00,0);
        Product bouquet2 = new Product("B002","Cresent shaped",'B',7.00,50);
        Product bouquet3 = new Product("B003","Square shaped",'B',8.00,50);
            products.add(bouquet1);
            products.add(bouquet2);
            products.add(bouquet3);
        
        //Let user choose what they want to order
        int type;
        char ans;
        do{
                    do{
                        
                    System.out.println("1. Fresh Flowers");
                    System.out.println("2. Bouquets");
                    System.out.println("3. Floral Arrangements");
                    System.out.print("Please choose the product type: ");
                    type = scan.nextInt();

                    if(type == 1)
                        FreshFlowers(items , products);
                    else if(type == 2)
                        Bouquet(items, products);
                    else if(type == 3)
                        Arrangements();
                    else
                        System.out.println("Incorrect input, please enter input as listed.");
                }while(type > 3 || type < 1);

            System.out.print("Would you like to add something else(Y/N)?");
            ans = scan.next().toUpperCase().charAt(0);
        }while(ans == 'Y');
        
        //Display order
        double orderTtlPrice = 0;
        System.out.println("Name  Quantity Ordered Unit Price");
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getItemName() + " " + items.get(i).getQuantityBought() + " " + items.get(i).getUnitPrice());
            orderTtlPrice += items.get(i).getUnitPrice();
        }
        System.out.println("Total price : RM" + orderTtlPrice);
        
        Date dNow = new Date( );
        SimpleDateFormat ft = 
        new SimpleDateFormat ("E yyyy.MM.dd hh:mm:ss a ");
        System.out.println("Date: " + ft.format(dNow));

        
    }
    
    
    
    private static List<Item> FreshFlowers(List items, List<Product> products){
        
        Scanner scan = new Scanner(System.in);
        //Create flower object
        Product flower = new Product();
        
            System.out.println("");
            
                
            char ans = 'Y';
            double flowerTtlPrice = 0;
            //Choose what flower and how much
            do{
                int k = 1;
                int n;
                do{
                    System.out.println("Name  Price  Quantity");
                    for(int i = 0; i < products.size(); i++)
                    {
                        if(products.get(i).getType() == 'F'){
                            if(products.get(i).getQuantity() == 0){
                                System.out.println(k + ".Sold out");
                                k++;
                            }
                            else{
                                System.out.println(k + "." + products.get(i).getName() + " " + products.get(i).getPrice() + " " + products.get(i).getQuantity());
                                k++;
                            }
                        }
                    }
                    System.out.print("Please choose the digit of flower that you wish to buy:");
                    n = scan.nextInt();
                    if(n > products.size() && n < 0 )
                        System.out.println("Incorrect input, please enter input as listed.");
                    else if(products.get(n - 1).getQuantity() == 0)
                        System.out.println("Please choose a flower that is not sold out.");
                }while(n > products.size() && n < 0 && products.get(n - 1).getQuantity() == 0);
                
                int qty;
                do{
                    System.out.print("Please number of flower you wish to buy:");
                    qty = scan.nextInt();
                    if(qty > products.get(n - 1).getQuantity() || qty <= 0)
                        System.out.println("Please enter a valid quantity.");
//                    else if(!scan.hasNextInt())
//                        System.out.println("Incorrect input, please enter input as listed.");
                    
                }while(qty > products.get(n - 1).getQuantity());
                
                
                flowerTtlPrice = flower.calculateBill(products.get(n - 1).getPrice(), qty);
                products.get(n - 1).setQuantity(products.get(n - 1).getQuantity()- qty);
                
                //Add ordered item
                Item item = new Item(products.get(n - 1).getProductID(),products.get(n - 1).getName(),'F',flowerTtlPrice,qty);
                items.add(item);
                
                //checking
                do{
                    System.out.print("Do you want to buy another flower(Y/N):");
                    ans = scan.next().toUpperCase().charAt(0);
                    if(ans != 'Y' && ans != 'N'){
                        System.out.println("Incorrect input, please enter input as listed.");
                    }
                }while(ans != 'Y' && ans != 'N');
            }while(ans == 'Y');
        return items;
    }
    
    private static List<Item> Bouquet(List items, List<Product> products){
        
        Scanner scan = new Scanner(System.in);
        
        Product bouquet = new Product();
        
            System.out.println("");
            
            
            char ans = 'Y';
            double bouquetTtlPrice = 0;
            //Choose what flower and how much
            do{
                int k = 1;
                int n;
                
                System.out.println("  Name  Price  Quantity");
                for(int i = 0; i < products.size(); i++)
                    {
                        if(products.get(i).getType() == 'B'){
                            if(products.get(i).getQuantity() == 0){
                                System.out.println(k + ".Sold out");
                                k++;
                            }
                            else{
                                System.out.println(k + "." + products.get(i).getName() + " " + products.get(i).getPrice() + " " + products.get(i).getQuantity());
                                k++;
                            }
                        }  
                        
                    }
                
                do{
                    System.out.print("Please choose the digit of bouquet that you wish to buy:");
                    n = scan.nextInt();
                    if(n + 3 > products.size() && n + 3 < 0 )
                        System.out.println("Incorrect input, please enter input as listed.");
                    else if(products.get(n + 2).getQuantity() == 0)
                        System.out.println("Please choose a bouquet that is not sold out.");
                    
                }while(n > products.size() && n < 0 && products.get(n + 2).getQuantity() == 0);
                
                int qty;
                do{
                    System.out.print("Please number of bouquet you wish to buy:");
                    qty = scan.nextInt();
                    if(qty > products.get(n + 2).getQuantity() || qty <= 0)
                        System.out.println("Please enter a valid quantity.");
//                    else if(!scan.hasNextInt())
//                        System.out.println("Incorrect input, please enter input as listed.");
                    
                }while(qty > products.get(n + 2).getQuantity());
                
                
                bouquetTtlPrice = bouquet.calculateBill(products.get(n + 2).getPrice(), qty);
                products.get(n + 2).setQuantity(products.get(n + 2).getQuantity()- qty);

                //Add ordered item
                Item item = new Item(products.get(n + 2).getProductID(),products.get(n + 2).getName(),'B',bouquetTtlPrice,qty);
                items.add(item);
                
                //checking
                do{
                    System.out.print("Do you want to buy another bouquet(Y/N):");
                    ans = scan.next().toUpperCase().charAt(0);
                    if(ans != 'Y' && ans != 'N'){
                        System.out.println("Incorrect input, please enter input as listed.");
                    }
                }while(ans != 'Y' && ans != 'N');
            }while(ans == 'Y');
            
        return items;
    }
    
    public static void Arrangements(){
        /*Problems
            Cannot accept correct index for list
            cannot check for null input
            cannot check for type input*/
        
    }
}

