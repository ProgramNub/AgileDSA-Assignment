/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 * @author User
 */
public class Bouquet implements Order{
    
    private String bouquetID;
    private String name;
    private double price;
    private int quantity;

    public Bouquet(String bouquetID, String name, double price, int quantity) {
        this.bouquetID = bouquetID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Bouquet() {
    }

    public String getBouquetID() {
        return bouquetID;
    }

    public void setBouquetID(String bouquetID) {
        this.bouquetID = bouquetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public double calculateBill(double price, int qty){
        
        double bouquetUnitPrice = price * qty;
        
        double ttlBouquet = 0;
        
        ttlBouquet += bouquetUnitPrice;
        
        return ttlBouquet;
    }
    
    @Override
    public String toString() {
        return "Bouquet{" + "bouquetID=" + bouquetID + ", name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
    
}
