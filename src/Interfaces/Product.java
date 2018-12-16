/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author lebor
 */
public class Product {

    private String productID;
    private char productCat;
    private String productName;
    private int productQuantity;
    private double productPrice;
    private String productDescription;

    public Product() {
        
    }

    public Product(String productID, char productCat, String productName, int productQuantity, double productPrice, String productDescription) {
        this.productID = productID;
        this.productCat = productCat;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public char getProductCat() {
        return productCat;
    }

    public void setProductCat(char productCat) {
        this.productCat = productCat;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double calculateBill(double price, int qty){
        
        double bouquetUnitPrice = price * qty;
        
        double ttlBouquet = 0;
        
        ttlBouquet += bouquetUnitPrice;
        
        return ttlBouquet;
    }
    
    @Override
    public String toString() {
        return productID + "\t" + productCat + "\t" + productName + "\t" + productQuantity + "\t" + productPrice + "\t" + productDescription + "\n";

    }

}
