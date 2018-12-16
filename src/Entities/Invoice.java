/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Interfaces.ListInterface;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Invoice {
    
    private String invoiceID;
    private Corporate corporate;
    private Date dueDate;
    private Date issuedDate;
    private int month;

    public Invoice() {
    }

    public Invoice(String invoiceID, Corporate corporate, Date dueDate, Date issuedDate, int month) {
        this.invoiceID = invoiceID;
        this.corporate = corporate;
        this.dueDate = dueDate;
        this.issuedDate = issuedDate;
        this.month = month;
    }

    

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Corporate getCorporate() {
        return corporate;
    }

    public void setCorporate(Corporate corporate) {
        this.corporate = corporate;
    }
    
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    
    
    
    
    
}
