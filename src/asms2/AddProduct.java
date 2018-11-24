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
         Product p1 = new Product(1,"fresh flower","Rose",11,10.00,"Colour:Pink,Red,White");
         Product p2 = new Product(2,"fresh flower","Orkid",11,10.00,"Orhid colour:red blue purple");
         Product p3 = new Product(3,"fresh flower","Sun Flower",11,10.00,"Colour Yellow");
         product.add(p1);
         product.add(p2);
         product.add(p3);
         catelogProduct.menu();
      }
}
   
  


