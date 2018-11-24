/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerMaintenance;

import entity.Corporate;
import entity.Consumer;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Desmond Chooi
 */
public class CustomerMenu {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        List<Consumer> Consumer = CustomerUtility.displayConsumerList();
        List<Corporate> Corporate = CustomerUtility.displayCorporateList();
        
        
        while(true){
            int choice = CustomerUtility.mainMenu();
            
            if(choice == 1){
                CustomerUtility.registerNewCustomer(Consumer, Corporate);
            }else if(choice ==  2){
                    
                CustomerUtility.displayCustomer(Consumer, Corporate);
            }else if(choice == 3){
                CustomerUtility.updateCustomer(Consumer, Corporate);
            }else if(choice == 5){
                System.out.println("Bye Bye");
                break;
            }
        }
    }
    
}
