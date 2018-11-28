/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asms2;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author lebor
 */
public class AddProduct {
   public static List<Product>product = new LinkedList();
   public static CatelogProduct catelogProduct = new CatelogProduct();
    public static boolean a = false;
      public static void main (String[] args){
         Product p1 = new Product(1,"Fresh Flowers","Rose",11,10.00,"Colour:Pink,Red,White");
         Product p2 = new Product(2,"Fresh Flowers","Orkid",11,10.00,"Orhid colour:red blue purple");
         Product p3 = new Product(3,"Fresh Flowers1","Sun Flower",11,10.00,"Colour Yellow");
         Product p4 = new Product(4,"Bouquets","WEDDING",11,60.00,"Colour Yellow");
         Product p5 = new Product(5,"Bouquets","NEW BORN",11,60.00,"Colour: Pink,Red");
         Product p6 = new Product(6,"Floral Arrangements","Orkid",11,60.00,"Colour: Pink,Red");
         Product p7 = new Product(7,"Floral Arrangements","Rose",11,60.00,"Colour: Pink,Red");
         product.add(p1);
         product.add(p2);
         product.add(p3);
         product.add(p4);
         product.add(p5);
         product.add(p6);
         product.add(p7);
         catelogProduct.menu();
      }
}
   
  


