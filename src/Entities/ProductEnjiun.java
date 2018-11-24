/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



/**
 *
 * @author User
 */
public class ProductEnjiun {
    
    private String productID;
    private String name;
    private char type;
    private double price;
    private int quantity;

    public ProductEnjiun() {
    }

    public ProductEnjiun(String productID, String name, char type, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double calculateBill(double price, int qty){
        
        double bouquetUnitPrice = price * qty;
        
        double ttlBouquet = 0;
        
        ttlBouquet += bouquetUnitPrice;
        
        return ttlBouquet;
    }

    
    
    @Override
    public String toString() {
        return productID + "  " + name + "  " + type + "  " + price + "  " + quantity;
    }
    
    
}
