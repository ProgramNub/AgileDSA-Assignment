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
    
    public static boolean a = false;
      public static void main (String[] args){
         Product p1 = new Product(1,"fresh flower","Rose","red",11,10.00);
         Product p2 = new Product(2,"fresh flower","red","Orkid",11,10.00);
         Product p3 = new Product(3,"fresh flower","red","Sun Flower",11,10.00);
         product.add(p1);
         product.add(p2);
         product.add(p3);
         menu();
      }     
   
        public static void menu(){

        Scanner s = new Scanner(System.in);
        
        int option;
        int count = 0;
        do{
            if(count>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("Menu: ");
            System.out.println("1.View Product");
            System.out.println("2.Add Product");
            System.out.println("3.Update Product Quantuty");
            System.out.println("4.Delete Product");
            System.out.println("5.Exit");
            System.out.print("Please Enter your choice : ");
            option = s.nextInt();
            if(option == 1){
                showProductList();
                a = true;
            }else if(option == 2){
                addProduct();
                a = true;
            }else if(option == 3){
                updateProduct();
                a = true;
            }
            else if(option == 4){
                DeleteProduct();
            }
            else if(option == 5){
                System.exit(0);
            }
            count++;
        }while(a!=true);
    }
    public static void addProduct(){
             System.out.println("Product Category\t"+"Product Name\t"+"Product Colour\t"+"Product Quantity\t"+"Product Price");
             System.out.println("====================================================================================================================");
             for(int i=0;i<product.size();i++)
                {
                 System.out.printf("%-12s\t\t %-10s\t%-10s\t\t%-2d \t\t%.2f\n",product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductColour(),product.get(i).getProductQuantity(),product.get(i).productprice);
          
                }

        int count = 0;
        int choice = 0;
        String type;
        Product p= new Product();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Product ID:");
        p.setProductID(product.size()+1);
        
        System.out.println(p.getProductID());
        
       do{
                        
                    System.out.println("1. Fresh Flowers");
                    System.out.println("2. Bouquets");
                    System.out.println("3. Floral Arrangements");
                    System.out.print("Please choose the product type: ");
                    type = sc.nextLine();

                    if(type.equals("1"))
                        p.setProductCat("Fresh Flowers");
                    else if(type.equals("2"))
                        p.setProductCat("Bouquet");
                    else if(type.equals("3"))
                        p.setProductCat("Arrangements"); 
                    else if(!type.matches("^[1-3]$"))
                        System.out.println("Incorrect input, please enter input as listed.");
                }while(!type.matches("^[1-3]$"));
        
        System.out.print("Please enter Product Name: ");
        while(!sc.hasNext("[A-Za-z]+")){
        sc.next();
        System.out.println("Product Name should not be blank or invalid input!!.Please re-enter");
        System.out.print("Please enter Product Colour: ");
        }
        p.setProductName(sc.nextLine());
        
        System.out.print("Please enter Product Colour: ");
        while(!sc.hasNext("[A-Za-z]+")){
        sc.next();
        System.out.println("Product Colour should not be blank or invalid input!!.Please re-enter");
        System.out.print("Please enter Product Colour: ");
        }
        p.setProductColour(sc.nextLine());
        
        
        System.out.print("Please enter product Quantity ");

        while(!sc.hasNextInt()){
        sc.next();
        System.out.println("Product quantity should not be blank and must number!!.Please retry");
        System.out.print("Please enter product Quantity: ");
       // productQuantity = sc.nextInt();
         }
        p.setProductQuantity(sc.nextInt());
        
        System.out.print("Please enter product Price: ");
        
        while(!sc.hasNextDouble()){
        System.out.println("Product quantity should not be blank and must number!!.Please retry");
        System.out.println("Please enter product Price: ");
        }
        p.setProductprice(sc.nextDouble());
        
        product.add(p);
        System.out.println("New Product Added in to List");
        showList();
        
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.print("Please choose an option e.g. 2 to exit: ");
                    while(a!=true){
                    if(count>=1){
                           System.out.println("Wrong number entered!"); 
                     }
                    choice = sc.nextInt(); 
                    if(choice==1){
                        menu();
                        a = true;
                    }else if(choice==2){
                        System.exit(0);
                    }
                    count++;
                }
    }

      
      public static void updateProduct(){
       int choice =0;
       int count =0;
       showList();
       Scanner b = new Scanner(System.in);
       System.out.print("Select Product By ID number: ");  
       choice = b.nextInt();
       boolean checking = false;
       for(int i = 0; i <product.size();i++)
           if(product.get(i).getProductID() == choice){
               System.out.print("Enter Product Queantity: ");
               Scanner stock = new Scanner(System.in);
                while(!stock.hasNextInt()){
                    stock.next();
                    System.out.println("Product quantity should not be blank and must number!!.Please retry");
                    System.out.print("Please enter product Quantity: ");
                }
               int newQuantity = stock.nextInt();
               product.get(i).setProductQuantity(newQuantity);
               System.out.println("Stock have been updated!\n");
               checking = true;
               
               while(a=true){
                if(count>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.print("Please choose an option e.g. 2 to exit: ");
                    Scanner s = new Scanner(System.in);
                    choice = s.nextInt(); 
                    if(choice==1){
                        menu();
                        a = true;
                    }else if(choice==2){
                        System.exit(0);
                     }
                      count++;
                }

              
                
            }else if(choice ==0){
                menu();
            }
    
            if(checking!= true){
              do{
                 System.out.println("Invalid item\n");
                  System.out.println("1.Return to Main Menu");
                   System.out.println("2.Exit");
                 System.out.print("Please choose an option e.g. 2 to exit" );
                 Scanner s = new Scanner(System.in);
                  choice = s.nextInt(); 
                 if(choice==1){
                     menu();
                     a = true;
                 }else if(choice==2){
                     System.exit(0);
                 }
             }while(a != true);
      
             }
            }
            public static void showList(){
      
             int count = 0 ;
          
             
                {
//               // System.out.printf("%-12s %-10s %-6s %-2d %f",product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductColour(),product.get(i).getProductQuantity());
//               System.out.println(product.toString());
                    System.out.println("ProductId\t"+"Product Category\t"+"Product Name\t"+"Product Colour\t"+"Product Quantity\t"+"Product Price");
                    System.out.println("====================================================================================================================");
                         for(int i=0;i<product.size();i++)
                         {
                                System.out.printf("%-3d\t\t%-12s\t\t %-10s\t%-10s\t\t%-2d \t\t%.2f\n",product.get(i).productID,product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductColour(),product.get(i).getProductQuantity(),product.get(i).productprice);
          
                         }
                }
            }
          
            public static void showProductList(){
                int count = 0 ;
                
             System.out.println("ProductId\t"+"Product Category\t"+"Product Name\t"+"Product Colour\t"+"Product Quantity\t"+"Product Price");
                    System.out.println("====================================================================================================================");
                         for(int i=0;i<product.size();i++)
                         {
                                System.out.printf("%-3d\t\t%-12s\t\t %-10s\t%-10s\t\t%-2d \t\t%.2f\n",product.get(i).productID,product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductColour(),product.get(i).getProductQuantity(),product.get(i).productprice);
          
                         }
                    while(a!=true){ 
                        if(count>=1){
                        System.out.println("Wrong number entered!");
                    }
                 System.out.println("1.Return to Main Menu");
                 System.out.println("2.Exit");
                 System.out.println("Please choose an option e.g. 2 to exit: ");
                 Scanner s = new Scanner(System.in);
                 int c = s.nextInt(); 
        
                    if(c==1){
                        a = true;
                        menu();
                     }else if(c==2){
                       System.exit(0);
                     }
                         count++;
                     }
                
             
              
            }
            
            public static void DeleteProduct(){
             int choice =0;
             int count =0;
             showList();Scanner b = new Scanner(System.in);
            System.out.print("Select Product By ID number: ");
            choice = b.nextInt();
            boolean checking = false;
            for(int i = 0; i <product.size();i++)
                 if(product.get(i).getProductID() == choice){
                     product.remove(i);
                    System.out.println("Product have been Deleted!\n");
                     checking = true;
                     while(a=true){
                     if(count>=1){
                             System.out.println("Wrong number entered!");
                         }
                          System.out.println("1.Return to Main Menu");
                         System.out.println("2.Exit");
                         System.out.print("Please choose an option e.g. 2 to exit: ");
                         Scanner s = new Scanner(System.in);
                         choice = s.nextInt(); 
                         if(choice==1){
                               menu();
                              a = true;
                         }else if(choice==2){
                                System.exit(0);
                          }
                              count++;
                     }       

              
                
                    }else if(choice ==0){
                       menu();
                  }
    
                    if(checking!= true){
                      do{
                         System.out.println("Invalid item\n");
                          System.out.println("1.Return to Main Menu");
                          System.out.println("2.Exit");
                         System.out.println("Please choose an option e.g. 2 to exit: ");
                         Scanner s = new Scanner(System.in);
                          choice = s.nextInt(); 
                         if(choice==1){
                             menu();
                             a = true;
                         }else if(choice==2){
                             System.exit(0);
                         }
                     }while(a != true);

                     }
                    }
            

      }
   
  



