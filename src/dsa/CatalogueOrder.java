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

/**
 *
 * @author User
 */
public class CatalogueOrder {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        //Check whether is individual or corporate customer

        char cust;
        do{
            System.out.print("Individual or corporate customer? (I/C): ");
            cust = scan.next().toUpperCase().charAt(0);
            if(cust != 'I' && cust != 'C')
                System.out.println("Incorrect input, please enter input as listed.");
        }while(cust != 'I' && cust != 'C');
        System.out.println("");
        
        //Let user choose what they want to order
        int type;
        double flowerOrderPrice = 0;
        double bouquetOrderPrice = 0;
        do{
            System.out.println("1. Fresh Flowers");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangements");
            System.out.print("Please choose the product type: ");
            type = scan.nextInt();
            
            if(type == 1)
                flowerOrderPrice += FreshFlowers();
            else if(type == 2)
                bouquetOrderPrice += Bouquet();
            else if(type == 3)
                bouquetOrderPrice += Bouquet();
            else
                System.out.println("Incorrect input, please enter input as listed.");
        }while(type > 3 || type < 1);
        
        //Display order
        System.out.print("Your order is RM " + bouquetOrderPrice);
    }
    
    private static double FreshFlowers(){
        
        Scanner scan = new Scanner(System.in);
        //Create flower objects
        Flower flower = new Flower();
        Flower flower1 = new Flower("F001","Rose",6.00,0);
        Flower flower2 = new Flower("F002","Sunflower",7.00,50);
        Flower flower3 = new Flower("F003","Lavender",8.00,50);
            
            //Create list for flowers
            List<Flower> flowers = new ArrayList<>();
            flowers.add(flower1);
            flowers.add(flower2);
            flowers.add(flower3);
            
            //Display list of flowers
            Iterator fl = flowers.listIterator();
            int i = 1;
            System.out.println("/n/n");
            while(fl.hasNext())
                {
                    System.out.println(i + "." + fl.next());
                    i++;
                }
                
            char ans = 'Y';
            double flowerTtlPrice = 0;
            //Choose what flower and how much
            do{
                int n;
                do{
                    System.out.print("Please choose the digit of flower that you wish to buy:");
                    n = scan.nextInt();
                    if(n > flowers.size() && n < 0 && !scan.hasNextInt())
                        System.out.println("Incorrect input, please enter input as listed.");
                }while(n > flowers.size() && n < 0 && !scan.hasNextInt());
                
                int qty;
                do{
                    System.out.print("Please number of flower you wish to buy:");
                    qty = scan.nextInt();
                    if(qty > flowers.get(n - 1).getQuantity() && qty < 0)
                        System.out.println("Please enter a valid quantity.");
                    else if(!scan.hasNextInt())
                        System.out.println("Incorrect input, please enter input as listed.");
                    
                }while(qty > flowers.get(n - 1).getQuantity() && !scan.hasNextInt());
                
                
                flowerTtlPrice += flower.calculateBill(flowers.get(n - 1).getPrice(), qty);

                //checking
                do{
                    
                    System.out.print("Do you want to buy another flower(Y/N):");
                    ans = scan.next().charAt(0);
                    if(ans != 'I' && ans != 'C'){
                        System.out.println("Incorrect input, please enter input as listed.");
                    }
                }while(ans != 'I' && ans != 'C');
            }while(ans == 'Y');
        return flowerTtlPrice;
    }
    
    private static double Bouquet(){
        
        Scanner scan = new Scanner(System.in);
        
        Bouquet bouquet = new Bouquet();
        Bouquet bouquet1 = new Bouquet("B001","Oval shaped",6.00,0);
        Bouquet bouquet2 = new Bouquet("B002","Cresent shaped",7.00,50);
        Bouquet bouquet3 = new Bouquet("B003","Square shaped",8.00,50);
        
            List<Bouquet> bouquets = new ArrayList<>();
            bouquets.add(bouquet1);
            bouquets.add(bouquet2);
            bouquets.add(bouquet3);
            Iterator bl = bouquets.listIterator();
            int i = 1;
            System.out.println("/ln/ln");
            while(bl.hasNext())
                {
                    System.out.println(i + "." + bl.next());
                    i++;
                }
                
            char ans = 'Y';
            double bouquetTtlPrice = 0;
            while(ans == 'Y'){
                System.out.print("Please choose the bouquet that you wish to buy:");
                int n = scan.nextInt();
                
                System.out.print("Please number of bouquet you wish to buy:");
                int qty = scan.nextInt();
                
                bouquetTtlPrice += bouquet.calculateBill(bouquets.get(n - 1).getPrice(), qty);
                
                System.out.print("Do you want to buy another bouquet(Y/N):");
                ans = scan.next().charAt(0);
                //checking
                while(ans != 'I' || ans != 'C'){
                    System.out.println("Incorrect input, please enter input as listed.");
                    System.out.print("Do you want to buy another bouquet(Y/N):");
                    ans = scan.next().charAt(0);
                }
                
            }
        return bouquetTtlPrice;
    }
}

