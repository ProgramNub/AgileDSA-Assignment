/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class FloralArrangements {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Arrangements arrangement = new Arrangements();
        
        List<String> styles = new ArrayList<>();
        styles.add("Fan shaped");
        styles.add("Elliptical");
        styles.add("Vertical");
        styles.add("Horizontal");
        styles.add("Triangular");
        styles.add("Cresent");
        styles.add("'S' shaped");
        styles.add("Oval shaped");
        styles.add("Cascade shaped");
        
        List<String> flowers = new ArrayList<>();
        styles.add("Fan shaped");
        styles.add("Elliptical");
        styles.add("Vertical");
        styles.add("Horizontal");
        styles.add("Triangular");
        styles.add("Cresent");
        styles.add("'S' shaped");
        styles.add("Oval shaped");
        styles.add("Cascade shaped");
        
        Iterator stl = styles.listIterator();
        while(stl.hasNext())
        {
            System.out.println(stl.next() + " " + stl.next() + " " + stl.next() + " ");
        }
        
        System.out.print("Please pick your style: ");
        String style = scan.nextLine();
        
        System.out.print("Please pick the size(B/S): ");
        char size = scan.next().charAt(0);
        
        List<String> arrange = new ArrayList<>();
        
        char ans = 'N';
        
        while(ans == 'N'){
            System.out.print("Please select flower:");
            String flower = scan.nextLine();
            arrange.add(flower);
            
            System.out.print("Are you finish adding flowers(Y/N):");
            ans = scan.nextLine().charAt(0); 
        }
        
        System.out.print("Please select the priority of your order");
        
    }
    
}
