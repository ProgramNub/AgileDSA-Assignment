/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asms2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author lebor
 */
public class AddProduct {
      public static void main (String[] args){
        List<Product> product = new ArrayList<>();
         String productCat;
         String productName;
         String productColour;
         int productQuantity ;
         double productprice ;
         
         
         Product p1 = new Product("Flash Flower","Rose","red",11,10.00);
         Product p2 = new Product("Flash Flower","red","Orkid",11,10.00);
         Product p3 = new Product("Flash Flower","red","Sun Flower",11,10.00);
         product.add(p1);
         product.add(p2);
         product.add(p3);
         System.out.println("Product Category\tProduct Name\tProduct Colour\tProduct Quantity\tProduct Price");
         
//         for(int i=0;i<=product.size();i++){
//         System.out.print(product.get(i).productCat +"\t"+
//                 product.get(i).productName+"\t"+
//                 product.get(i).productColour+"\t"+
//                 product.get(i).productQuantity+"\t"+
//                 product.get(i).productprice); 
//         }

      //for(int i=0;i<=product.size();i++){
         System.out.println(product.toString());
     //  }

        Product p= new Product();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter Product Category: ");
        productCat = sc.nextLine();  
        while(!productCat.matches("[a-zA-Z, ]+")){
        System.out.println("Category name should not be blank or invalid input!!.Please re-enter");
         System.out.println("Please enter Product Category: ");
        productCat = sc.nextLine(); 
        }
      

        System.out.println("Please enter Product Name: ");
        productName = sc.nextLine();
         while(!productName.matches("[a-zA-Z, ]+")){
        System.out.println("Product name should not be blank or invalid input!!.Please re-enter");
          System.out.println("Please enter Product Name: ");
          productName = sc.nextLine(); 
         }
        
        System.out.println("Please enter Product Colour: ");
        productColour = sc.nextLine();
         while(!productColour.matches("[a-zA-Z, ]+ ")){
        System.out.println("Product Colour should not be blank or invalid input!!.Please re-enter");
        System.out.println("Please enter Product Colour: ");
        productColour = sc.nextLine();
         }
        
        System.out.println("Please enter product Quantity ");
        productQuantity = sc.nextInt();
        while(productQuantity<=0){
        System.out.println("Product quantity should not be blank and must number!!.Please retry");
        System.out.println("Please enter product Quantity ");
        productQuantity = sc.nextInt();
         }
        
        System.out.println("Please enter product Price ");
        productprice = sc.nextDouble();
        while(productprice<=0){
        System.out.println("Product quantity should not be blank and must number!!.Please retry");
        System.out.println("Please enter product Price ");
        
        productprice = sc.nextDouble();
        }
        product.add(new Product(productCat, productName, productColour, productQuantity, productprice));
        p = product.get(0);
        System.out.println("New Product Added as Below");
        System.out.println("Product Category\tProduct Name\tProduct Colour\tProduct Quantity\tProduct Price");
        System.out.println(p);

       
}

   
  

    
}
