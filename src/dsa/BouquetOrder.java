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
public class BouquetOrder {

    public static ListInterface<Item> Bouquet(ListInterface<Item> items, ListInterface<Product> bouquets) {

        Scanner scan = new Scanner(System.in);

        Product bouquet = new Product();

        System.out.println("");

        String ans;
        double bouquetTtlPrice = 0;
        //Choose what flower and how much
        do {
            String n;
            int k;
            do {
                k = 1;

                System.out.println("Name  Price  Quantity");
                for (int i = 0; i < bouquets.size(); i++) {
                        if (bouquets.get(i).getProductQuantity() == 0) {
                            System.out.println(k + "." + bouquets.get(i).getProductName() + " " + bouquets.get(i).getProductPrice() + " Sold out");
                            k++;
                        } else {
                            System.out.println(k + "." + bouquets.get(i).getProductName() + " " + bouquets.get(i).getProductPrice() + " " + bouquets.get(i).getProductQuantity());
                            k++;
                        }
                }
                System.out.print("Please choose the digit of bouquet that you wish to buy:");
                n = scan.nextLine();
                if (!n.matches("^[1-" + (k - 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                } else if (bouquets.get(Integer.parseInt(n) - 1).getProductQuantity() == 0) {
                    System.out.println("Please choose a bouquet that is not sold out.");
                }

            } while (!n.matches("^[1-" + (k - 1) + "]$") || bouquets.get(Integer.parseInt(n) -1).getProductQuantity() == 0);

            String qty;
            do {
                System.out.print("Please number of bouquet you wish to buy:");
                qty = scan.nextLine();
                if (!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < bouquets.get(Integer.parseInt(n) - 1).getProductQuantity())
                    System.out.println("Please enter a valid quantity.");
            } while (!qty.matches("^([1-9]|[1-9][0-9])$") && Integer.parseInt(qty) < bouquets.get(Integer.parseInt(n) - 1).getProductQuantity());

            bouquetTtlPrice = bouquet.calculateBill(bouquets.get(Integer.parseInt(n) - 1).getProductPrice(), Integer.parseInt(qty));
            bouquets.get(Integer.parseInt(n) - 1).setProductQuantity(bouquets.get(Integer.parseInt(n) - 1).getProductQuantity() - Integer.parseInt(qty));

            //Add ordered item
            Item item = new Item(bouquets.get(Integer.parseInt(n) - 1).getProductID(), bouquets.get(Integer.parseInt(n) - 1).getProductName(), 'B', bouquetTtlPrice, Integer.parseInt(qty));
            items.add(item);

            //checking
            do {
                System.out.print("Do you want to buy another bouquet(Y/N):");
                ans = scan.nextLine();
                if (!ans.matches("^[YyNn]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                }
            } while (!ans.matches("^[YyNn]$"));
        } while (ans.matches("^[Yy]$"));
        return items;
    }
}
