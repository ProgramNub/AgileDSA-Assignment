/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Interfaces.ListInterface;
import Interfaces.Product;
import java.util.Scanner;

/**
 *
 * @author lebor
 */
public class ProductMenu {

    public static boolean a = false;

    public static void productMain(ListInterface<Product> flowers, ListInterface<Product> bouquets) {
        Scanner s = new Scanner(System.in);

        int ans = 0;
        int count = 0;

        do {
            if (count >= 1) {
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
            if (ans == 1) {
                viewProduct(flowers, bouquets);
                a = true;
            } else if (ans == 2) {
                addProduct(flowers, bouquets);
                a = true;
            } else if (ans == 3) {
                updateProduct(flowers, bouquets);
                a = true;
            } else if (ans == 4) {
                DeleteProduct(flowers, bouquets);
                a = true;
            } else if (ans == 5) {
                System.exit(0);
            }
            count++;
        } while (a != true);
    }

    public static void addProduct(ListInterface<Product> flowers, ListInterface<Product> bouquets) {

        int count = 0;
        String type;

        Product p = new Product();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Fresh Flowers");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangements (Not yet implement)");
            System.out.print("Please choose the product type: ");
            type = sc.nextLine();

            if (type.equals("1")) {
                p.setProductCat('F');
                System.out.print("Product ID:");
                p.setProductID(String.format("F%03d", flowers.size() + 1));
                System.out.println(p.getProductID());
            } else if (type.equals("2")) {
                p.setProductCat('B');
                System.out.print("Product ID:");
                p.setProductID(String.format("B%03d", bouquets.size() + 1));
                System.out.println(p.getProductID());
            } else if (type.equals("3")) {
                //p.setProductCat('A');
            } else if (!type.matches("^[1-3]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!type.matches("^[1-3]$"));

        System.out.print("Please enter Product Name: ");
        while (!sc.hasNext("[A-Za-z]+")) {
            sc.next();
            System.out.println("Product Name should not be blank or invalid input!!.Please re-enter");
            System.out.print("Please enter Product Name: ");
        }
        p.setProductName(sc.nextLine());

        System.out.print("Please enter product Quantity ");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Product quantity should not be blank and must number!!.Please retry");
            System.out.print("Please enter product Quantity: ");
            // productQuantity = sc.nextInt();
        }
        p.setProductQuantity(sc.nextInt());

        System.out.print("Please enter product Price: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Product quantity should not be blank and must number!!.Please retry");
            System.out.println("Please enter product Price: ");
        }
        p.setProductPrice(sc.nextDouble());

        System.out.print("Please enter Product Description: ");
        while (!sc.hasNext("[A-Za-z]+")) {
            sc.next();
            System.out.println("Product Description should not be blank or invalid input!!.Please re-enter");
            System.out.print("Please enter Product Description: ");
        }
        p.setProductDescription(sc.next());

        if (type.equals("1")) {
            flowers.add(p);
        } else if (type.equals("2")) {
            bouquets.add(p);
        }

        System.out.println("New Product Added in to List");
        showProduct(p);

        int ans1 = 0;
        System.out.println("Please Select Your Option");
        System.out.println("1.Add more Product");
        System.out.println("2.Return to Main Menu");
        System.out.println("3.Exit");
        System.out.print("Enter Option: ");
        ans1 = sc.nextInt();
        while (a != true) {
            if (count >= 1) {
                System.out.println("Incorrect Input,Only enter 1 ,2 and 3 only");
            }
            if (ans1 == 1) {
                addProduct(flowers, bouquets);
                a = true;
            } else if (ans1 == 2) {
                productMain(flowers, bouquets);
                a = true;
            } else if (ans1 == 3) {
                System.exit(0);
            }
            //Cannot press 1
            count++;
        }
    }

    public static void updateProduct(ListInterface<Product> flowers, ListInterface<Product> bouquets) {

        String type;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("==========Update Product ========");
            System.out.println("Please Select Product Category");
            System.out.println("1. Fresh Flowers");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangements");
            System.out.println("4. Back To Menu");
            System.out.print("Please choose the product type: ");
//            System.out.println("1. Update Product Quantity");
//            System.out.println("2. Update Product Description");
//            System.out.print("Please enter option: ");
            type = sc.nextLine();

            if (type.equals("1")) {
                updateFlower(flowers, bouquets);
            } else if (type.equals("2")) {
                updateBouquet(flowers,bouquets);
            } else if (!type.matches("^[1-2]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }
        } while (!type.matches("^[1-2]$"));

    }

    public static void updateFlower(ListInterface<Product> flowers, ListInterface<Product> bouquets) {
        int ans = 0;
        String id = "";
        int count = 0;
        DisplayList.displayFlowerList(flowers);
        Scanner b = new Scanner(System.in);

        System.out.print("Select Product By ID number: ");
        id = b.nextLine();
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getProductID().equals(id)) {
                System.out.println("1. Update Product Quantity");
                System.out.println("2. Update Product Description");
                System.out.print("Please enter option: ");
                String opt = b.nextLine();
                String stock = "";
                String newDescription = "";
                if(opt.equals("1")){
                    do{
                        System.out.print("Enter Product Quantity: ");
                        stock = b.nextLine();
                        if(!stock.matches("^[1-9]+$")) {
                            System.out.println("Product quantity should not be blank and must number!!.Please retry");
                            System.out.print("Please enter product Quantity: ");
                        }
                    }while (!stock.matches("^[1-9]+$"));  
                    flowers.get(i).setProductQuantity(Integer.parseInt(stock));
                    System.out.println("Stock have been updated!\n");
                }
                
                else if(opt.equals("2")){
                    do{
                        System.out.print("Enter Product Description: ");
                        newDescription = b.nextLine();
                        if(newDescription == null) {
                            System.out.println("Product quantity should not be blank and must number!!.Please retry");
                            System.out.print("Please enter product Quantity: ");
                        }
                    }while (newDescription == null);   
                    flowers.get(i).setProductDescription(newDescription);
                    System.out.println("Description have been updated!\n");
                }
             
                


                while (a = true) {
                    if (count >= 1) {
                        System.out.println("Incorrect Input,Only enter 1 or 2 only");
                    }
                    System.out.println("Please Select Your Option ");
                    System.out.println("1.Update More Product ");
                    System.out.println("2.Return to Main Menu");
                    System.out.println("3.Exit");
                    System.out.print("Your option: ");
                    Scanner s = new Scanner(System.in);
                    ans = s.nextInt();
                    if (ans == 1) {
                        updateProduct(flowers, bouquets);
                        a = true;
                    } else if (ans == 2) {
                        productMain(flowers, bouquets);
                        a = true;
                    } else if (ans == 3) {
                        System.exit(0);
                    }
                    count++;
                }

            }
        }
    }

    public static void updateBouquet(ListInterface<Product> flowers,ListInterface<Product> bouquets) {
        int ans = 0;
        String id = "";
        int count = 0;
        DisplayList.displayFlowerList(bouquets);
        Scanner b = new Scanner(System.in);

        System.out.print("Select Product By ID number: ");
        id = b.nextLine();
        for (int i = 0; i < bouquets.size(); i++) {
            if (bouquets.get(i).getProductID().contentEquals(id)) {
                System.out.println("1. Update Product Quantity");
                System.out.println("2. Update Product Description");
                System.out.print("Please enter option: ");
                String opt = b.nextLine();
                String stock = "";
                String newDescription = "";
                if(opt.equals("1")){
                    do{
                        System.out.print("Enter Product Quantity: ");
                        stock = b.nextLine();
                        if(!stock.matches("^[1-9]+$")) {
                            System.out.println("Product quantity should not be blank and must number!!.Please retry");
                            System.out.print("Please enter product Quantity: ");
                        }
                    }while (!stock.matches("^[1-9]+$"));  
                    bouquets.get(i).setProductQuantity(Integer.parseInt(stock));
                }
                
                else if(opt.equals("2")){
                    do{
                        System.out.print("Enter Product Description: ");
                        newDescription = b.nextLine();
                        if(!newDescription.matches("^[A-Za-z]+$")) {
                            System.out.println("Product quantity should not be blank and must number!!.Please retry");
                            System.out.print("Please enter product Quantity: ");
                        }
                    }while (!stock.matches("^[1-9]+$"));   
                    bouquets.get(i).setProductDescription(newDescription);
                }
             
                System.out.println("Stock have been updated!\n");


                while (a = true) {
                    if (count >= 1) {
                        System.out.println("Incorrect Input,Only enter 1 or 2 only");
                    }
                    System.out.println("Please Select Your Option ");
                    System.out.println("1.Update More Product ");
                    System.out.println("2.Return to Main Menu");
                    System.out.println("3.Exit");
                    System.out.print("Your option: ");
                    Scanner s = new Scanner(System.in);
                    ans = s.nextInt();
                    if (ans == 1) {
                        updateProduct(flowers, bouquets);
                        a = true;
                    } else if (ans == 2) {
                        productMain(flowers, bouquets);
                        a = true;
                    } else if (ans == 3) {
                        System.exit(0);
                    }
                    count++;
                }

            }
        }
    }

    public static void showProduct(Product p) {

        System.out.println("Product ID\t" + "Product Category\t" + "Product Name\t" + "Product Quantity\t" + "Product Price\t" + "Product Description\t");
        System.out.println("====================================================================================================================");
        System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", p.getProductID(), p.getProductCat(), p.getProductName(), p.getProductQuantity(), p.getProductPrice(), p.getProductDescription());

    }

    public static void viewProduct(ListInterface<Product> flowers, ListInterface<Product> bouquets) {
        int count = 0;
        String type;
        int ans;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("==========View Product========");
            System.out.println("Please Select Product Category");
            System.out.println("1. Fresh Flowers");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangements");
            System.out.println("4. Back To Menu");
            System.out.print("Please choose the product type: ");
            type = sc.nextLine();

            if (type.equals("1")) {
                DisplayList.displayFlowerList(flowers);
            } else if (type.equals("2")) {
                DisplayList.displayBouquetList(bouquets);
            } //else if (type.equals("3")) {
            //                System.out.println("Product ID\t" + "Product Category\t" + "Product Name\t" + "Product Quantity\t" + "Product Price\t" + "Product Description\t");
            //                System.out.println("====================================================================================================================");
            //                for (int i = 0; i < flowers.size(); i++)
            //                        System.out.printf("%-2s\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", flowers.get(i).getProductID(), flowers.get(i).getProductCat(), flowers.get(i).getProductName(), flowers.get(i).getProductQuantity(), flowers.get(i).getProductPrice(), flowers.get(i).getProductDescription());
            //                
            //            } else if (type.equals("4")) {
            else if (type.equals("4")) {
                productMain(flowers, bouquets);
            } else if (!type.matches("^[1-4]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }

        } while (!type.matches("^[1-4]$"));

        while (a = true) {
            if (count >= 1) {
                System.out.println("Incorrect Input,Only enter 1 or 2 only");
            }
            System.out.println("Please Select Your Option");
            System.out.println("1.View Other Product Category");
            System.out.println("2.Return to Main Menu");
            System.out.println("3.Exit");
            System.out.print("Enter Option: ");
            Scanner s = new Scanner(System.in);
            ans = s.nextInt();
            if (ans == 1) {
                viewProduct(flowers, bouquets);
                a = true;
            } else if (ans == 2) {
                productMain(flowers, bouquets);
                a = true;
            } else if (ans == 3) {
                System.exit(0);
            }
            count++;
        }

    }

    public static void DeleteProduct(ListInterface<Product> flowers, ListInterface<Product> bouquets) {
        int ans = 0;
        int count = 0;
        String id = "";
        Scanner b = new Scanner(System.in);
        String type;
        do {

            System.out.println("==========Delete Product ========");
            System.out.println("Please Select Product Category");
            System.out.println("1. Fresh Flowers");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangements");
            System.out.println("4. Back To Menu");
            System.out.print("Please choose the product type: ");
            type = b.nextLine();

            if (type.equals("1")) {
                DisplayList.displayFlowerList(flowers);
                System.out.print("Select Product By ID number: ");
                id = b.nextLine();
                for (int i = 0; i < flowers.size(); i++) {
                    if (flowers.get(i).getProductID().equals(id)) {
                        flowers.remove(i);
                        System.out.println("Product have been Deleted!\n");
                    } else {
                        System.out.println("Product not found.\n");
                    }
                }
            } else if (type.equals("2")) {
                DisplayList.displayBouquetList(bouquets);
                System.out.print("Select Product By ID number: ");
                ans = b.nextInt();
                for (int i = 0; i < flowers.size(); i++) {
                    if (bouquets.get(i).getProductID().equals(ans)) {
                        bouquets.remove(i);
                        System.out.println("Product have been Deleted!\n");
                    } else {
                        System.out.println("Product not found.\n");
                    }
                }
            } //            else if (type.equals("3")) {
            //                System.out.println("Product ID\t" + "Product Category\t" + "Product Name\t" + "Product Quantity\t" + "Product Price\t" + "Product Description\t");
            //                System.out.println("====================================================================================================================");
            //                for (int i = 0; i < product.size(); i++) {
            //                    if (product.get(i).productCat == "Floral Arrangements") {
            //                        System.out.printf("%-2d\t\t%-18s\t %-10s\t\t%-2d \t\t%.2f\t\t%-20s\n", product.get(i).productID, product.get(i).getProductCat(), product.get(i).getProductName(), product.get(i).getProductQuantity(), product.get(i).productprice, product.get(i).productDescription);
            //
            //                    }
            //                }
            //            } 
            else if (type.equals("4")) {
                productMain(flowers, bouquets);
            } else if (!type.matches("^[1-4]$")) {
                System.out.println("Incorrect input, please enter input as listed.");
            }

        } while (!type.matches("^[1-4]$"));

        while (a = true) {
            if (count >= 1) {
                System.out.println("Incorrect Input,Only enter 1 or 2 only");
            }
            System.out.println("Please Select Your Option");
            System.out.println("1.Delete Other Product");
            System.out.println("2.Return to Main Menu");
            System.out.println("3.Exit");
            System.out.print("Enter Option: ");
            Scanner s = new Scanner(System.in);
            ans = s.nextInt();
            if (ans == 1) {
                DeleteProduct(flowers, bouquets);
                a = true;
            } else if (ans == 2) {
                productMain(flowers, bouquets);
                a = true;
            } else if (ans == 3) {
                System.exit(0);
            }
            count++;
        }
    }

}
