/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DisplayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> type = new ArrayList<>();
        type.add("Fresh Flowers");
        type.add("Bouquets");
        type.add("Floral Arrangements");
        
        System.out.println("1. Fresh Flowers");
        System.out.println("2. Bouquets");
        System.out.println("3. Floral Arrangements");
        System.out.print("Please choose the product type: ");
        
    }
    
}
