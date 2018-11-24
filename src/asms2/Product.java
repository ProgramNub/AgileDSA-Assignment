/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asms2;

/**
 *
 * @author lebor
 */
public class Product {
    public int productID;
     public String productCat;
     public String productName;
     public String productColour;
     public int productQuantity ;
     public double productprice ;
      
      Product(){};

    public Product(int productID,String productCat, String productName, String productColour, int productQuantity, double productprice) {
        this.productID = productID;
        this.productCat = productCat;
        this.productName = productName;
        this.productColour = productColour;
        this.productQuantity = productQuantity;
        this.productprice = productprice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    

    public String getProductCat() {
        return productCat;
    }

    public void setProductCat(String productCat) {
        this.productCat = productCat;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    @Override
    public String toString() {
        return productID +"\t" +   productCat + "\t" + productName + "\t" + productColour + "\t" + productQuantity + "\t" + productprice +"\n";
    
    }

}


    
