/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asms2;

import static asms2.AddProduct.a;
import static asms2.AddProduct.product;
import java.util.Scanner;

/**
 *
 * @author lebor
 */
public class CatelogProduct implements ProductInterface{
    
        public void menu(){

        Scanner s = new Scanner(System.in);
        
        int ans=0;
        int count = 0;
        do{
            if(count>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("Flower Menu: ");
            System.out.println("1.View Product");
            System.out.println("2.Add Product");
            System.out.println("3.Update Product Quantuty");
            System.out.println("4.Delete Product");
            System.out.println("5.Exit");
            System.out.print("Please Enter your option : ");
            ans = s.nextInt();
            if(ans == 1){
                showProductList();
                a = true;
            }else if(ans == 2){
                addProduct();
                a = true;
            }else if(ans == 3){
                updateProduct();
                a = true;
            }
            else if(ans == 4){
                DeleteProduct();
            }
            else if(ans == 5){
                System.exit(0);
            }
            count++;
        }while(a!=true);
    }
     
    public void addProduct(){
             System.out.println("Product ID\t"+"Product Category\t"+"Product Name\t"+"Product Quantity\t"+"Product Price\t"+"Product Description\t");
             System.out.println("====================================================================================================================");
             for(int i=0;i<product.size();i++)
                {
                 System.out.printf("%-2d\t\t%-12s\t\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n",product.get(i).productID,product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductQuantity(),product.get(i).productprice,product.get(i).productDescription);
          
                }

        int count = 0;
        int ans = 0;
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
        System.out.print("Please enter Product Name: ");
        }
        p.setProductName(sc.nextLine());
        
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
        
        System.out.print("Please enter Product Description: ");
        while(!sc.hasNext("[A-Za-z]+")){
        sc.next();
        System.out.println("Product Description should not be blank or invalid input!!.Please re-enter");
        System.out.print("Please enter Product Colour: ");
        }
        p.setProductDescription(sc.nextLine());
        
        product.add(p);
        
        System.out.println("New Product Added in to List");
        showList();
            
                    
                    System.out.println("Please Select Your Option");
                    System.out.println("1.Add more Product");
                    System.out.println("2.Return to Main Menu");
                    System.out.println("3.Exit");
                    System.out.print("Enter Option: ");
                    while(a!=true){
                    if(count>=1){
                           System.out.println("Incorrect Input,Only enter 1 ,2 and 3 only"); 
                     }
                    ans = sc.nextInt(); 
                    if(ans ==1){
                      addProduct();
                      a=true;
                    }else if(ans==2){
                        menu();
                        a = true;
                    }else if(ans==3){
                        System.exit(0);
                    }
                    count++;
                }
    }

       public void updateProduct(){
        
           String type;
           Scanner sc = new Scanner(System.in);
       
        do{
                        
                    System.out.println("1. Update Product Quantity");
                    System.out.println("2. Update Product Description");
                    System.out.print("Please enter option: ");
                    type = sc.nextLine();

                    if(type.equals("1"))
                       updateQuantity();
                    else if(type.equals("2"))
                       updateDescription();
                    else if(!type.matches("^[1-2]$"))
                        System.out.println("Incorrect input, please enter input as listed.");
                }while(!type.matches("^[1-2]$"));
       
       }
      
      public void updateDescription(){
       int ans =0;
       int count =0;
       showList();
       Scanner b = new Scanner(System.in);
       
            System.out.print("Select Product By ID number: ");  
            ans = b.nextInt();
            boolean checking = false;
            for(int i = 0; i <product.size();i++)
                 if(product.get(i).getProductID() == ans){
                    System.out.print("Enter Product Description: ");
                     Scanner d = new Scanner(System.in);
                     while(!d.hasNext("[A-Za-z]+")){
                         d.next();
                         System.out.println("Product Description should not be blank or number!!.Please retry");
                            System.out.print("Please enter product Description: ");
                      }
                    String newDescription = d.nextLine();
                    product.get(i).setProductDescription(newDescription);
                    System.out.println("Stock have been updated!\n");
                     checking = true;
                    
                     while(a=true){
                     if(count>=1){
                               System.out.println("Incorrect Input,Only enter 1 or 2 only"); 
                            }
                            System.out.println("Please Select Your Option ");
                            System.out.println("1.Update More Product ");
                            System.out.println("2.Return to Main Menu");
                            System.out.println("3.Exit");
                            System.out.print("Your option: ");
                            Scanner s = new Scanner(System.in);
                            ans = s.nextInt(); 
                            if(ans ==1){
                                updateProduct();
                                a = true;
                            }else if(ans==2){
                                menu();
                                a = true;
                            }else if(ans==3){
                                System.exit(0);
                             }
                              count++;
                        }

                 
                
                 }
            }
      
      public void updateQuantity(){
       int ans =0;
       int count =0;
       showList();
       Scanner b = new Scanner(System.in);
       
            System.out.print("Select Product By ID number: ");  
            ans = b.nextInt();
            boolean checking = false;
            for(int i = 0; i <product.size();i++)
                 if(product.get(i).getProductID() == ans){
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
                               System.out.println("Incorrect Input,Only enter 1 or 2 only"); 
                            }
                            System.out.println("Please Select Your Option ");
                            System.out.println("1.Update More Product ");
                            System.out.println("2.Return to Main Menu");
                            System.out.println("3.Exit");
                            System.out.print("Your option: ");
                            Scanner s = new Scanner(System.in);
                            ans = s.nextInt(); 
                            if(ans ==1){
                                updateProduct();
                                a = true;
                            }else if(ans==2){
                                menu();
                                a = true;
                            }else if(ans==3){
                                System.exit(0);
                             }
                              count++;
                        }

                 
                 }
            }
      
      
            public void showList(){
      
             int count = 0 ;
         
                {
//               // System.out.printf("%-12s %-10s %-6s %-2d %f",product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductColour(),product.get(i).getProductQuantity());
//               System.out.println(product.toString());
                    System.out.println("Product ID\t"+"Product Category\t"+"Product Name\t"+"Product Quantity\t"+"Product Price\t"+"Product Description\t");
             System.out.println("====================================================================================================================");
             for(int i=0;i<product.size();i++)
                {
                 System.out.printf("%-2d\t\t%-12s\t\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n",product.get(i).productID,product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductQuantity(),product.get(i).productprice,product.get(i).productDescription);
          
                }
                }
            }
          
            public void showProductList(){
                int count = 0 ;
                
               System.out.println("Product ID\t"+"Product Category\t"+"Product Name\t"+"Product Quantity\t"+"Product Price\t"+"Product Description\t");
             System.out.println("====================================================================================================================");
             for(int i=0;i<product.size();i++)
                {
                 System.out.printf("%-2d\t\t%-12s\t\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n",product.get(i).productID,product.get(i).getProductCat(),product.get(i).getProductName(),product.get(i).getProductQuantity(),product.get(i).productprice,product.get(i).productDescription);
          
                }
                    while(a!=true){ 
                        if(count>=1){
                        System.out.println("Incorrect Input,Only enter 1 or 2 only"); 
                    }
                    System.out.println("Please Select Your Option");
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.print("Enter Option: ");
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
            
            public void DeleteProduct(){
             int ans =0;
             int count =0;
             showList();Scanner b = new Scanner(System.in);
            System.out.print("Select Product By ID number: ");
            ans = b.nextInt();
            boolean checking = false;
            for(int i = 0; i <product.size();i++)
                 if(product.get(i).getProductID() == ans){
                     product.remove(i);
                    System.out.println("Product have been Deleted!\n");
                     checking = true;
                     while(a=true){
                     if(count>=1){
                            System.out.println("Incorrect Input,Only enter 1 or 2 only"); 
                         }
                    System.out.println("Please Select Your Option");
                    System.out.println("1.Delete Other Product");
                    System.out.println("2.Return to Main Menu");
                    System.out.println("3.Exit");
                    System.out.print("Enter Option: ");
                         Scanner s = new Scanner(System.in);
                         ans = s.nextInt(); 
                         if(ans ==1){
                             DeleteProduct();
                             a = true;
                         }else if(ans==2){
                               menu();
                              a = true;
                         }else if(ans==3){
                                System.exit(0);
                          }
                              count++;
                     }       

            
                    }

  
            
            }
    
}
