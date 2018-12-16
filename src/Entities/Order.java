
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Interfaces.ListInterface;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author User
 */
public class Order {
    
    private String orderID;
    private double orderPrice;
    private Date dateOrdered;
    private Date dateReceive;
    private Customer customer;
    private int hourReceive;
    private char status;
    private char type;
    private int month;
    
    
    private boolean done;
    private boolean check;
    private boolean paid;

    public Order() {
    }

    public Order(String orderID, double orderPrice, Date dateOrdered, Date dateReceive, Customer customer, int hourReceive, char status, char type, int month) {
        this.orderID = orderID;
        
        this.orderPrice = orderPrice;
        this.dateOrdered = dateOrdered;
        this.dateReceive = dateReceive;
        this.customer = customer;
        this.hourReceive = hourReceive;
        this.status = status;
        this.type = type;
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
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
    
    public void setPayment(boolean paid, boolean checked) {
        checked = true;
        if(paid != true)
            setDone(false);
        else
            setDone(true);
    }
    
    public boolean addOrder(ListInterface<Item> items, ListInterface<Order> orders, Customer customer, boolean paid, String delPick, String hour, double orderTtlPrice, Date dNow, Date receiveDate, String orderID){
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        char stat;
        
        if (paid == true) {
            stat = 'P';
        } else {
            stat = 'U';
        }

        orders.add(new Order(orderID, orderTtlPrice, dNow, receiveDate , customer,Integer.parseInt(hour), stat, delPick.charAt(0), month));
        
        return true;
        
    }
    
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setDone(boolean done){
        this.done = done;
    }
    
    public boolean getDone(){
        return done;
    }
    
    public boolean getChecked(){
        return check;
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

    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderPrice=" + orderPrice + ", dateOrdered=" + dateOrdered + ", dateReceive=" + dateReceive + ", customer=" + customer + ", hourReceive=" + hourReceive + ", status=" + status + ", type=" + type + ", check=" + check + '}';
    }

    

    

}
=======
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

