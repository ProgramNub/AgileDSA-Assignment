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
    private String custName;
    private String custAddress;
    private String custContact;
    private char custType;

    public Customer() {
        
    }

    public Customer(String custID, String custName, String custAddress, String custContact, char custType) {
        this.custID = custID;
        this.custName = custName;
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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public char getCustType() {
        return custType;
    }

    public void setCustType(char custType) {
        this.custType = custType;
    }

    @Override
    public String toString() {
        return "Customer{" + "custID=" + custID + ", custName=" + custName + ", custAddress=" + custAddress + ", custContact=" + custContact + ", custType=" + custType + '}';
    }

    

    
    
    
    
    
}