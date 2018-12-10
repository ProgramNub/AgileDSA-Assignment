/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Interfaces.Product;
import Entities.Item;
import Interfaces.ListInterface;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class FlowerOrder {
    
    public static ListInterface<Item> FreshFlowers(ListInterface<Item> items, ListInterface<Product> flowers){
        
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
                    for(int i = 0; i < flowers.size() ; i++)
                    {
                        if (flowers.get(i).getProductQuantity() == 0) {
                            System.out.println(k + "." + flowers.get(i).getProductName() + " " + flowers.get(i).getProductPrice() + " Sold out");
                            k++;
                        } else {
                            System.out.println(k + "." + flowers.get(i).getProductName() + " " + flowers.get(i).getProductPrice() + " " + flowers.get(i).getProductQuantity());
                            k++;
                        }
                    }
                    System.out.print("Please choose the digit of flower that you wish to buy:");
                    n = scan.nextLine();
                    if(!n.matches("^[1-"+ (k - 1) +"]$") )
                        System.out.println("Incorrect input, please enter input as listed.");
                    else if(flowers.get(Integer.parseInt(n)  - 1).getProductQuantity() == 0)
                        System.out.println("Please choose a flower that is not sold out.");
                    
                }while(!n.matches("^[1-"+ (k - 1) +"]$") || flowers.get(Integer.parseInt(n)  - 1).getProductQuantity() == 0);
                
                String qty;
                do{
                    System.out.print("Please number of flower you wish to buy:");
                    qty = scan.nextLine();
                    
                    if(!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < flowers.get(Integer.parseInt(n) - 1).getProductQuantity())
                        System.out.println("Please enter a valid quantity.");
                    
                }while(!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < flowers.get(Integer.parseInt(n) - 1).getProductQuantity());
                
                
                flowerTtlPrice = flower.calculateBill(flowers.get(Integer.parseInt(n) - 1).getProductPrice(), Integer.parseInt(qty));
                flowers.get(Integer.parseInt(n) - 1).setProductQuantity(flowers.get(Integer.parseInt(n) - 1).getProductQuantity()- Integer.parseInt(qty));
                
                
                //Add ordered item
                    Item item = new Item(flowers.get(Integer.parseInt(n) - 1).getProductID(),flowers.get(Integer.parseInt(n) - 1).getProductName(),'F',flowerTtlPrice,Integer.parseInt(qty));
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
}
