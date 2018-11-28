/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.ItemEnjiun;

import Interfaces.ListInterface;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public class SalesOrder {

//    
      public static ListInterface<ItemEnjiun> findDuplicates(ListInterface<ItemEnjiun> input) {
 
        Set<ItemEnjiun> duplicates = new HashSet<>();
        Set<ItemEnjiun> originals = new HashSet<>();

                for (int i = 0; i < input.size(); i++) {
                    for (int j = 1; j < input.size(); j++) {
                        if (input.get(i).getItemName().equals(input.get(j).getItemName()) && i != j) {
                            // duplicate element found
                            input.get(i).setQuantityBought(input.get(i).getQuantityBought() + input.get(j).getQuantityBought());
                            input.remove(j);
                            duplicates.add(input.get(i));
                            break;
                        }
                        else{
                            originals.add(input.get(i));
                            break;
                        }
                    }
                }
                duplicates.addAll(originals);
                return duplicates;
    }
//    private static void findDuplicates(ListInterface<? extends Collection<?>> collections)
//    {
//        for (int i = 0; i < collections.size(); i++)
//        {
//            for (int j = i + 1; j < collections.size(); j++)
//            {
//                Collection<?> ci = collections.get(i);
//                Collection<?> cj = collections.get(j);
//                boolean b = containsAny(ci, cj);
//                System.out.println(
//                    "Collection " + ci + " contains any of " + cj + ": " + b);
//            }
//        }
//    }
//
//    private static boolean containsAny(Collection<?> containing,
//        Collection<?> contained)
//    {
//        Set<Object> set = new LinkedHashSet<Object>(contained);
//        return containing.stream().anyMatch(e -> set.contains(e));
//    }
}

