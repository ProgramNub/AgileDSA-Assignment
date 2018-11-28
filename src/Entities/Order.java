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
 * @author User
 */
public class Order {
    
    private String orderID;
    private ListInterface orderItems;
    private double orderPrice;
    private Date dateOrdered;
    private Date dateReceive;
    private int hourReceive;
    private char status;
    private char type;
    private String orderRef;

    public Order() {
    }

    public Order(String orderID,ListInterface orderItems, double orderPrice, Date dateOrdered, Date dateReceive, int hourReceive,char status, char type, String orderRef) {
        this.orderID = orderID;
        this.orderItems = orderItems;
        this.orderPrice = orderPrice;
        this.dateOrdered = dateOrdered;
        this.dateReceive = dateReceive;
        this.hourReceive = hourReceive;
        this.status = status;
        this.type = type;
        this.orderRef = orderRef;
    }

    public ListInterface getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ListInterface orderItems) {
        this.orderItems = orderItems;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Date getDateReceive() {
        return dateReceive;
    }

    public void setDateReceive(Date dateReceive) {
        this.dateReceive = dateReceive;
    }

    public int getHourReceive() {
        return hourReceive;
    }

    public void setHourReceive(int hourReceive) {
        this.hourReceive = hourReceive;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderItems=" + orderItems + ", orderPrice=" + orderPrice + ", dateOrdered=" + dateOrdered + ", dateReceive=" + dateReceive + ", hourReceive=" + hourReceive + ", status=" + status + ", type=" + type + ", orderRef=" + orderRef + '}';
    }

    
    
    
    
}
