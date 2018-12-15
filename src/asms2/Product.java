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
     public int productQuantity ;
     public double productprice ;
     public String productDescription; 
      
      Product(){};

    public Product(int productID,String productCat, String productName, int productQuantity, double productpric,String productDescription) {
        this.productID = productID;
        this.productCat = productCat;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productprice = productprice;
        this.productDescription = productDescription;
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

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    @Override
    public String toString() {
        return productID +"\t" +   productCat + "\t" + productName +"\t" + productQuantity + "\t" + productprice +"\t"+productDescription +"\n";
    
    }

}


    
