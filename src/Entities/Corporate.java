/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author asus
 */
public class Corporate extends Customer{
    
    private String corporateName;
    private double creditLimit;

    public Corporate() {
       
    }

    public Corporate(String custID, String corporateName, String custAddress, String custContact, double creditLimit, char custType) {
        super(custID, custAddress, custContact, custType);
        this.corporateName = corporateName;
        this.creditLimit = creditLimit;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Corporate{" + "corporateName=" + corporateName + ", creditLimit=" + creditLimit + '}';
    }
    
    
    
}
