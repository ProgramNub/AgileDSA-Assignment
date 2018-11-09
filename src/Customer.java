/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Objects;

/**
 *
 * @author asus
 */
public class Customer {
    private String name;
    private String CustID;
    private String ContactNo;
    
    
    
    public Customer() {
    }
    
    public Customer(String name, String CustID, String ContactNo) {
        this.name = name;
        this.CustID = CustID;
        this.ContactNo = ContactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
