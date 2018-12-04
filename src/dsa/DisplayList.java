/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Interfaces.Product;
import Interfaces.ListInterface;

/**
 *
 * @author User
 */
public class DisplayList {

    public static void displayCorporateList(ListInterface<Corporate> displayCorporate) {
        System.out.println("=======Corporate List==========");
        for (int i = 0; i < displayCorporate.size(); i++) 
            System.out.println(String.format("%d. %-6s \t %-20s \t %s \t %-50s \t %-12s \t %-6.2f", i + 1,
                    displayCorporate.get(i).getCustID(),
                    displayCorporate.get(i).getCorporateName(),
                    displayCorporate.get(i).getCustType(),
                    displayCorporate.get(i).getCustAddress(),
                    displayCorporate.get(i).getCustContact(),
                    displayCorporate.get(i).getCreditLimit()));
        

    }

    public static void displayConsumerList(ListInterface<Consumer> displayConsumer) {
        System.out.println("==============Consumer List=============");
        for (int i = 0; i < displayConsumer.size(); i++) 
            System.out.println(String.format("%d. %-6s \t %-20s \t %s \t %-50s \t %-12s", i + 1,
                    displayConsumer.get(i).getCustID(),
                    displayConsumer.get(i).getConsumerName(),
                    displayConsumer.get(i).getCustType(),
                    displayConsumer.get(i).getCustAddress(),
                    displayConsumer.get(i).getCustContact()));
        
    }

    public static void displayProductList(ListInterface<Product> flowers,ListInterface<Product> bouquets, String product) {
        System.out.println("Product ID\t" + "Product Category\t\t" + "Product Name\t" + "Product Quantity\t" + "Product Price\t" + "Product Description\t");
        System.out.println("====================================================================================================================");
            for (int i = 0; i < flowers.size(); i++) {
                if(flowers.get(i).getProductQuantity() > 0){
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", flowers.get(i).getProductID(), flowers.get(i).getProductCat(), flowers.get(i).getProductName(), flowers.get(i).getProductQuantity(), flowers.get(i).getProductPrice(), flowers.get(i).getProductDescription());
                } else
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%-20s\n", flowers.get(i).getProductID(), flowers.get(i).getProductCat(), flowers.get(i).getProductName(), "Sold out", flowers.get(i).getProductPrice(), flowers.get(i).getProductDescription());  
            }
            
            for (int i = 0; i < bouquets.size(); i++) {
                if(bouquets.get(i).getProductQuantity() > 0){
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", bouquets.get(i).getProductID(), bouquets.get(i).getProductCat(), bouquets.get(i).getProductName(), bouquets.get(i).getProductQuantity(), bouquets.get(i).getProductPrice(), bouquets.get(i).getProductDescription());
                } else
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%-20s\n", bouquets.get(i).getProductID(), bouquets.get(i).getProductCat(), bouquets.get(i).getProductName(), "Sold out", bouquets.get(i).getProductPrice(), bouquets.get(i).getProductDescription());
            }
    }
    
    public static void displayFlowerList(ListInterface<Product> flowers) {
        System.out.println("Product ID\t" + "Product Category\t\t" + "Product Name\t" + "Product Quantity\t" + "Product Price\t" + "Product Description\t");
        System.out.println("====================================================================================================================");
            for (int i = 0; i < flowers.size(); i++) {
                if(flowers.get(i).getProductQuantity() > 0){
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", flowers.get(i).getProductID(), flowers.get(i).getProductCat(), flowers.get(i).getProductName(), flowers.get(i).getProductQuantity(), flowers.get(i).getProductPrice(), flowers.get(i).getProductDescription());
                    //System.out.printf(flowers.get(i).getProductID(), flowers.get(i).getProductCat(), flowers.get(i).getProductName(), flowers.get(i).getProductQuantity(), flowers.get(i).getProductPrice(), flowers.get(i).getProductDescription());
                } else
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%-20s\n", flowers.get(i).getProductID(), flowers.get(i).getProductCat(), flowers.get(i).getProductName(), "Sold out", flowers.get(i).getProductPrice(), flowers.get(i).getProductDescription());  
            }
}
    
    public static void displayBouquetList(ListInterface<Product> bouquets) {
        System.out.println("Product ID\t" + "Product Category\t\t" + "Product Name\t" + "Product Quantity\t" + "Product Price\t" + "Product Description\t");
        System.out.println("====================================================================================================================");
            for (int i = 0; i < bouquets.size(); i++) {
                if(bouquets.get(i).getProductQuantity() > 0){
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", bouquets.get(i).getProductID(), bouquets.get(i).getProductCat(), bouquets.get(i).getProductName(), bouquets.get(i).getProductQuantity(), bouquets.get(i).getProductPrice(), bouquets.get(i).getProductDescription());
                } else
                    System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%-20s\n", bouquets.get(i).getProductID(), bouquets.get(i).getProductCat(), bouquets.get(i).getProductName(), "Sold out", bouquets.get(i).getProductPrice(), bouquets.get(i).getProductDescription());
            }
    }
}
