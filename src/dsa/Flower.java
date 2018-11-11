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
public class Flower implements OrderInterface{
    
    private String flowerID;
    private String name;
    private double price;
    private int quantity;
   
    public Flower() {
    }

    public Flower(String flowerID, String name, double price, int quantity) {
        this.flowerID = flowerID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
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
        
        double flowerUnitPrice = price * qty;
        
        double ttlFlower = 0;
        
        ttlFlower += flowerUnitPrice;
        
        return ttlFlower;
    }

    @Override
    public String toString() {
        return "Flower{" + "flowerID=" + flowerID + ", name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }

    
    
}
