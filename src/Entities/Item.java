/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Interfaces.ListInterface;

/**
 *
 * @author User
 */
public class Item {
    private String itemID;
    private String itemName;
    private char type;
    private double unitPrice;
    private int quantityBought;
    

    public Item() {
    }

    public Item(String itemID, String itemName, char type, double unitPrice, int quantityBought) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.type = type;
        this.unitPrice = unitPrice;
        this.quantityBought = quantityBought;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityBought() {
        return quantityBought;
    }
    
    public double calculateBill(double price, int qty){
        
        double bouquetUnitPrice = price * qty;
        
        double ttlBouquet = 0;
        
        ttlBouquet += bouquetUnitPrice;
        
        return ttlBouquet;
    }
    

    
    public void corpCredit(boolean paid, Corporate corp, double productTtlPrice){
        corp.setCreditLimit(corp.getCreditLimit() - productTtlPrice);
        corp.setCreditPayStat('D');
    }
    
    public ListInterface<Item> sortItemList(ListInterface<Product> products ,ListInterface<String> itemID, ListInterface<Item> items, Item item1, String qty, double price) {
            if (itemID.contains(item1.getItemID())) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getItemID().equals(item1.getItemID())) {
                        items.get(i).setQuantityBought(items.get(i).getQuantityBought() + Integer.parseInt(qty));
                        items.get(i).setUnitPrice(items.get(i).getUnitPrice() + price);
                    }
                }
            } else {
                itemID.add(item1.getItemID());
                items.add(item1);
            }
            
            //Update products
            for (int w = 0; w < products.size(); w++) {
                if (products.get(w).getProductID().equals(item1.getItemID())) {
                    products.get(w).setProductQuantity(products.get(w).getProductQuantity() - Integer.parseInt(qty));
                }
            }
        return items;    
    }


    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    @Override
    public String toString() {
        return itemID + "  " + itemName + "  " + type + "  " + unitPrice + "  " + quantityBought;
    }
    
    
}
