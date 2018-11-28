package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Desmond Chooi
 */
public class Customer {
    
    private String custID;
    private String custAddress;
    private String custContact;
    private char custType;

    public Customer() {
        
    }

    public Customer(String custID, String custAddress, String custContact, char custType) {
        this.custID = custID;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custType = custType;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public char getCustType() {
        return custType;
    }

    public void setCustType(char custType) {
        this.custType = custType;
    }
    
    

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    @Override
    public String toString() {
        return "Customer{" + "custID=" + custID + ", custAddress=" + custAddress + ", custContact=" + custContact + ", custType=" + custType + '}';
    }

    
    
    
    
    
}