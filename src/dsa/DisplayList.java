/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.LinkedList;
import Interfaces.Product;
import Interfaces.ListInterface;
import java.time.LocalDate;

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

    public static void displayProductList(ListInterface<Product> flowers,ListInterface<Product> bouquets) {
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
    
//    public static ListInterface<Product> displayProductList(ListInterface<Product> products, String product, char type) {
//
//        ListInterface<Product> prodList = new LinkedList();
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProductCat() == type) {
//                prodList.add(products.get(i));
//            }
//        }
//
//        System.out.println(product + " ID\t" + product + " Category\t\t" + product + " Name\t" + product + " Quantity\t" + product + " Price\t" + product + " Description\t");
//        System.out.println("====================================================================================================================");
//        for (int i = 0; i < prodList.size(); i++) {
//            if (prodList.get(i).getProductQuantity() > 0) {
//                System.out.printf("%d. %-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", i + 1, prodList.get(i).getProductID(), prodList.get(i).getProductCat(), prodList.get(i).getProductName(), prodList.get(i).getProductQuantity(), prodList.get(i).getProductPrice(), prodList.get(i).getProductDescription());
//            } else {
//                System.out.printf("%d. %-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%-20s\n", i + 1, prodList.get(i).getProductID(), prodList.get(i).getProductCat(), prodList.get(i).getProductName(), "Sold out", prodList.get(i).getProductPrice(), prodList.get(i).getProductDescription());
//            }
//        }
//        return prodList;
//    }
    
    public static ListInterface<Product> displayProductList(ListInterface<Product> products, String product, char type) {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();

        ListInterface<Product> prodList = new LinkedList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCat() == type) {
                prodList.add(products.get(i));
            }
        }

        System.out.println(product + " ID\t" + product + " Category\t\t" + product + " Name\t" + product + " Quantity\t\t" + product + " Price\t" + product + " Description\t"+ product +"Offer Month\t"+ product +"offer Rate\t"+product +"offer price\t");
        System.out.println("====================================================================================================================");
        for (int i = 0; i < prodList.size(); i++) {
            if (prodList.get(i).getProductQuantity() > 0) {
                if(month == prodList.get(i).getDiscountMonth()){
                    double newPrice = (prodList.get(i).getProductPrice() * (100-prodList.get(i).getDiscount())/100);
                     
                    
                    System.out.printf("%d. %-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\t\t%d\t\t%.2f\t\t\t%.2f\n", i + 1, prodList.get(i).getProductID(), prodList.get(i).getProductCat(), prodList.get(i).getProductName(), prodList.get(i).getProductQuantity(), prodList.get(i).getProductPrice(),prodList.get(i).getProductDescription(),prodList.get(i).getDiscountMonth(),prodList.get(i).getDiscount(),newPrice);
                }else
                    System.out.printf("%d. %-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\t\t%d\t\t%.2f\n", i + 1, prodList.get(i).getProductID(), prodList.get(i).getProductCat(), prodList.get(i).getProductName(), prodList.get(i).getProductQuantity(), prodList.get(i).getProductPrice(), prodList.get(i).getProductDescription(),prodList.get(i).getDiscountMonth(),prodList.get(i).getDiscount());
            } else {
                if(month == prodList.get(i).getDiscountMonth()){
                    double newPrice = (prodList.get(i).getProductPrice() * (100-prodList.get(i).getDiscount())/100);
                    System.out.printf("%d. %-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%.2f\t\t%-20s\n", i + 1, prodList.get(i).getProductID(), prodList.get(i).getProductCat(), prodList.get(i).getProductName(), "Sold out", prodList.get(i).getProductPrice(), newPrice ,prodList.get(i).getProductDescription());
                }else
                    System.out.printf("%d. %-2s\t\t%-18s\t %-10s\t\t%-2s \t\t%.2f\t\t%-20s\n", i + 1, prodList.get(i).getProductID(), prodList.get(i).getProductCat(), prodList.get(i).getProductName(), "Sold out", prodList.get(i).getProductPrice(), prodList.get(i).getProductDescription());
            }
        }
        return prodList;
    }
}
