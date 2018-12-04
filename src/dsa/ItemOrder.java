/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Interfaces.Product;
import Entities.Item;
import Entities.LinkedList;
import Interfaces.ListInterface;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ItemOrder {

    public static ListInterface<Item> Ordering(ListInterface<Item> items, ListInterface<Product> bouquets, String bp) {

        Scanner scan = new Scanner(System.in);
        Product bouquet = new Product();
        String sp = bp.toLowerCase();

        char t;
        if (bp.equals("Flower")) {
            t = 'F';
        } else {
            t = 'B';
        }
        ListInterface<Product> tempList = new LinkedList<>();
        for (int i = 0; i < bouquets.size(); i++) {
            if (bouquets.get(i).getProductCat() == t) {
                tempList.add(bouquets.get(i));
            }
        }
        String ans;
        double productTtlPrice = 0;
        //Choose what flower and how much
        do {
            String n;
            int k;
            do {
                k = 1;

                System.out.println(bp + " Name " + bp + " Price " + bp + " Quantity");
                for (int i = 0; i < tempList.size(); i++) {
                    if (tempList.get(i).getProductQuantity() == 0) {
                        System.out.println(k + "." + tempList.get(i).getProductName() + " " + tempList.get(i).getProductPrice() + " Sold out");
                        k++;
                    } else {
                        System.out.println(k + "." + tempList.get(i).getProductName() + " " + tempList.get(i).getProductPrice() + " " + tempList.get(i).getProductQuantity());
                        k++;
                    }
                }
                System.out.print("Please choose the digit of " + sp + " that you wish to buy:");
                n = scan.nextLine();
                if (!n.matches("^[1-" + (k - 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                } else if (tempList.get(Integer.parseInt(n) - 1).getProductQuantity() == 0) {
                    System.out.println("Please choose a " + sp + " that is not sold out.");
                }

            } while (!n.matches("^[1-" + (k - 1) + "]$") || tempList.get(Integer.parseInt(n) - 1).getProductQuantity() == 0);

            String qty;
            do {
                System.out.print("Please number of " + sp + " you wish to buy:");
                qty = scan.nextLine();
                if (!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < tempList.get(Integer.parseInt(n) - 1).getProductQuantity()) {
                    System.out.println("Please enter a valid quantity.");
                }
            } while (!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < tempList.get(Integer.parseInt(n) - 1).getProductQuantity());

            productTtlPrice = bouquet.calculateBill(tempList.get(Integer.parseInt(n) - 1).getProductPrice(), Integer.parseInt(qty));
            
            //Add ordered item
            Item item = new Item();
            int e = 0, f = 0;
            for(int i = 0; i < items.size(); i++){
                if(!items.get(i).getItemID().equals(tempList.get(Integer.parseInt(n) - 1).getProductID())){
                    e++;
                    f = i;
                }
            }
            if(e == 0){
                item = new Item(tempList.get(Integer.parseInt(n) - 1).getProductID(), tempList.get(Integer.parseInt(n) - 1).getProductName(), t, productTtlPrice, Integer.parseInt(qty));
                items.add(item);
            }else
                items.get(f).setQuantityBought(items.get(f).getQuantityBought() + Integer.parseInt(qty));

            //why is tempList affected by bouquets
            for(int w = 0; w < bouquets.size(); w++){
                if(bouquets.get(w).getProductID().equals(item.getItemID())){
                    bouquets.get(w).setProductQuantity(bouquets.get(w).getProductQuantity() - item.getQuantityBought());
                }
            }

            //checking
            do {
                System.out.print("Do you want to buy another " + sp + "(Y/N):");
                ans = scan.nextLine();
                if (!ans.matches("^[YyNn]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!ans.matches("^[YyNn]$"));
        } while (ans.matches("^[Yy]$"));
        
        return items;
    }
}
