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

        String cust;
  
        do{
                
                System.out.print("Individual or corporate customer? (I/C): ");
                cust = scan.nextLine();
                if(!cust.matches("^[IiCc]$"))
                    System.out.println("Incorrect input, please enter input as listed.");
        }while(!cust.matches("^[IiCc]$"));

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
        String type;
        String ans;
        do{
                    do{
                        
                    System.out.println("1. Fresh Flowers");
                    System.out.println("2. Bouquets");
                    System.out.println("3. Floral Arrangements");
                    System.out.print("Please choose the product type: ");
                    type = scan.nextLine();

                    if(type.equals("1"))
                        FreshFlowers(items , products);
                    else if(type.equals("2"))
                        Bouquet(items, products);
                    else if(type.equals("3"))
                        Arrangements();
                    else if(!type.matches("^[1-3]$"))
                        System.out.println("Incorrect input, please enter input as listed.");
                }while(!type.matches("^[1-3]$"));

            do{
                System.out.print("Would you like to add something else(Y/N)?");
                ans = scan.nextLine();
                if(!ans.matches("^[YyNn]$"))
                    System.out.println("Incorrect input, please enter input as listed.");
            }while(!ans.matches("^[YyNn]$"));    
        }while(ans.matches("^[Yy]$"));
        
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
            
                
            String ans;
            double flowerTtlPrice = 0;
            //Choose what flower and how much
            do{
                String n;
                int k;
                do{
                    k = 1;
                    
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
                    n = scan.nextLine();
                    if(!n.matches("^[1-"+ (k - 1) +"]$") )
                        System.out.println("Incorrect input, please enter input as listed.");
                    else if(products.get(Integer.parseInt(n)  - 1).getQuantity() == 0)
                        System.out.println("Please choose a flower that is not sold out.");
                    
                }while(!n.matches("^[1-"+ (k - 1) +"]$") || products.get(Integer.parseInt(n)  - 1).getQuantity() == 0);
                
                String qty;
                do{
                    System.out.print("Please number of flower you wish to buy:");
                    qty = scan.nextLine();
                    
                    if(!qty.matches("^[1-"+ products.get(Integer.parseInt(n) - 1).getQuantity() +"]$"))
                        System.out.println("Please enter a valid quantity.");
                    
                }while(!qty.matches("^[1-"+ products.get(Integer.parseInt(n) - 1).getQuantity() +"]$"));
                
                
                flowerTtlPrice = flower.calculateBill(products.get(Integer.parseInt(n) - 1).getPrice(), Integer.parseInt(qty));
                products.get(Integer.parseInt(n) - 1).setQuantity(products.get(Integer.parseInt(n) - 1).getQuantity()- Integer.parseInt(qty));
                
                //Add ordered item
                Item item = new Item(products.get(Integer.parseInt(n) - 1).getProductID(),products.get(Integer.parseInt(n) - 1).getName(),'F',flowerTtlPrice,Integer.parseInt(qty));
                items.add(item);
                
                //checking
                do{
                    System.out.print("Do you want to buy another flower(Y/N):");
                    ans = scan.nextLine();
                    if(!ans.matches("^[YyNn]$")){
                        System.out.println("Incorrect input, please enter input as listed.");
                    }
                }while(!ans.matches("^[YyNn]$"));
            }while(ans.matches("^[Yy]$"));
        return items;
    }
    
    private static List<Item> Bouquet(List items, List<Product> products){
        
        Scanner scan = new Scanner(System.in);
        
        Product bouquet = new Product();
        
            System.out.println("");
            
            
            String ans;
            double bouquetTtlPrice = 0;
            //Choose what flower and how much
            do{
                String n;
                int k;
                do{
                    k = 1;
                    
                    System.out.println("Name  Price  Quantity");
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
                    System.out.print("Please choose the digit of bouquet that you wish to buy:");
                    n = scan.nextLine();
                    if(!n.matches("^[1-"+ (k - 1) +"]$") )
                        System.out.println("Incorrect input, please enter input as listed.");
                    else if(products.get(Integer.parseInt(n) + 2).getQuantity() == 0)
                        System.out.println("Please choose a bouquet that is not sold out.");
                    
                }while(!n.matches("^[1-"+ (k - 1) +"]$") || products.get(Integer.parseInt(n) + 2).getQuantity() == 0);
                
                String qty;
                do{
                    System.out.print("Please number of bouquet you wish to buy:");
                    qty = scan.nextLine();
                    
                    if(!qty.matches("^[1-"+ products.get(Integer.parseInt(n) +2).getQuantity() +"]$"))
                        System.out.println("Please enter a valid quantity.");
                    
                }while(!qty.matches("^[1-"+ products.get(Integer.parseInt(n) +2).getQuantity() +"]$"));
                
                
                bouquetTtlPrice = bouquet.calculateBill(products.get(Integer.parseInt(n) +2).getPrice(), Integer.parseInt(qty));
                products.get(Integer.parseInt(n) +2).setQuantity(products.get(Integer.parseInt(n) +2).getQuantity()- Integer.parseInt(qty));
                
                //Add ordered item
                Item item = new Item(products.get(Integer.parseInt(n) +2).getProductID(),products.get(Integer.parseInt(n) +2).getName(),'B',bouquetTtlPrice,Integer.parseInt(qty));
                items.add(item);
                
                //checking
                do{
                    System.out.print("Do you want to buy another bouquet(Y/N):");
                    ans = scan.nextLine();
                    if(!ans.matches("^[YyNn]$")){
                        System.out.println("Incorrect input, please enter input as listed.");
                    }
                }while(!ans.matches("^[YyNn]$"));
            }while(ans.matches("^[Yy]$"));
        return items;
    }
    
    public static void Arrangements(){
        /*Problems
            Cannot accept correct index for list
            sales order cannot mix same item*/
        
    }
}

