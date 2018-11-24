/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;


import Entities.ProductEnjiun;
import Entities.ItemEnjiun;
import Interfaces.ListInterface;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BouquetOrder {

    public static ListInterface<ItemEnjiun> Bouquet(ListInterface<ItemEnjiun> items, ListInterface<ProductEnjiun> products) {

        Scanner scan = new Scanner(System.in);

        ProductEnjiun bouquet = new ProductEnjiun();

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
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getType() == 'B') {
                        if (products.get(i).getQuantity() == 0) {
                            System.out.println(k + "." + products.get(i).getName() + " " + products.get(i).getPrice() + " Sold out");
                            k++;
                        } else {
                            System.out.println(k + "." + products.get(i).getName() + " " + products.get(i).getPrice() + " " + products.get(i).getQuantity());
                            k++;
                        }
                    }
                }
                System.out.print("Please choose the digit of bouquet that you wish to buy:");
                n = scan.nextLine();
                if (!n.matches("^[1-" + (k - 1) + "]$")) {
                    System.out.println("Incorrect input, please enter input as listed.");
                } else if (products.get(Integer.parseInt(n) + 2).getQuantity() == 0) {
                    System.out.println("Please choose a bouquet that is not sold out.");
                }

            } while (!n.matches("^[1-" + (k - 1) + "]$") || products.get(Integer.parseInt(n) + 2).getQuantity() == 0);

            String qty;
            do {
                System.out.print("Please number of bouquet you wish to buy:");
                qty = scan.nextLine();

                if (!qty.matches("^[1-" + products.get(Integer.parseInt(n) + 2).getQuantity() + "]$")) {
                    System.out.println("Please enter a valid quantity.");
                }

            } while (!qty.matches("^[1-" + products.get(Integer.parseInt(n) + 2).getQuantity() + "]$"));

            bouquetTtlPrice = bouquet.calculateBill(products.get(Integer.parseInt(n) + 2).getPrice(), Integer.parseInt(qty));
            products.get(Integer.parseInt(n) + 2).setQuantity(products.get(Integer.parseInt(n) + 2).getQuantity() - Integer.parseInt(qty));

            //Add ordered item
            ItemEnjiun item = new ItemEnjiun(products.get(Integer.parseInt(n) + 2).getProductID(), products.get(Integer.parseInt(n) + 2).getName(), 'B', bouquetTtlPrice, Integer.parseInt(qty));
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
