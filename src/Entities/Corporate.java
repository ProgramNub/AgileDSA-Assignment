/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Interfaces.ListInterface;

/**
 *
 * @author Desmond Chooi
 */
public class Corporate extends Customer{
    
    
    
    private double creditLimit;
    private char creditPayStat;

    public Corporate() {
       
    }

    public Corporate(String custID, String custName, char custType, String custAddress, String custContact, double creditLimit, char creditPayStat) {
        super(custID, custName,custAddress, custContact, custType);
        
        this.creditLimit = creditLimit;
        this.creditPayStat = creditPayStat;
    }
    
    public Corporate searchCorp(Customer customer, ListInterface<Corporate> corporates, Corporate corp){
                for (int i = 0; i < corporates.size(); i++) {
                    if (customer.getCustID().equals(corporates.get(i).getCustID())) {
                        corp = corporates.get(i);
                    }
                }
        return corp;
    }

    public char getCreditPayStat() {
        return creditPayStat;
    }

    public void setCreditPayStat(char creditPayStat) {
        this.creditPayStat = creditPayStat;
    }

    
   
    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Corporate{" + "creditLimit=" + creditLimit + ", creditPayStat=" + creditPayStat + '}';
    }

    

    

   
    
    
    
}
