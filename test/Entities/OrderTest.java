/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Interfaces.ListInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/*import Interfaces.ListInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;*/

/**
 *
 * @author asus
 */
public class OrderTest {

    private final ListInterface<Item> items = new LinkedList<>();
    private final ListInterface<Order> orders = new LinkedList<>();
    private boolean paid;
    private Customer c1,c2,c3,c4;
    private String delPick, hour, dateString, orderID;
    private double orderTtlPrice;
    private Date dNow, receiveDate;
    
    public OrderTest() {
    }
    
    @Before
    public void setUp() {
        //String custID, String custName, String custAddress, String custContact, char custType
        
        c1 = new Customer("CR0001" ,"Eden Hazard",  "Block 20-2, Cardinal Apartment, Oklahama", "012-1286421", 'I');
        c2 = new Customer("CR0002", "Alvaro Morata",  "Block 90-1-4, Taman Apartment, Rawang, Selangor", "011-2134143", 'I');
        c3 = new Customer("CP0001", "Super Flower Sdn.Bhd.",  "129 Jalan Alam Shah, Wangsa Maju, Kuala Lumpur", "088421412", 'C');
        c4 = new Customer("CP0002", "Goh Marriage Sdn.Bhd.",  "13 Jalan Perindustrian 16, Bayan Lepas, Pulau Pinang", "043435234", 'C');
        
        orderID = "O001";
        
        items.add(new Item("F001","Rose",'F',30.00,3, "O001"));
        items.add(new Item("F002","Orkid",'F',20.00,2, "O001"));
        items.add(new Item("B001","WEDDING",'B',120.00,2, "O001"));
        items.add(new Item("B002","NEW BORN",'B',180.00,3, "O001"));
        
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a ");
    }

    
    /**
     * Test of addOrder method, of class Order.
     * @throws java.text.ParseException
     */
    @Test
    public void testAddOrder() throws ParseException {
        System.out.println("addOrder");
        Order instance = new Order();
        boolean expResult = true;
        DateFormat df = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH);
            
        delPick = "P";
        dateString = "12-12-12";
        receiveDate = df.parse(dateString);
        hour = "4";
        boolean result1 = instance.addOrder(items, orders, c1, paid, delPick, hour, orderTtlPrice, dNow, receiveDate, orderID);
        
        delPick = "D";
        dateString = "1-1-13";
        receiveDate = df.parse(dateString);
        hour = "7";
        boolean result2 = instance.addOrder(items, orders, c2, paid, delPick, hour, orderTtlPrice, dNow, receiveDate, orderID);
        
        delPick = "P";
        dateString = "13-1-12";
        receiveDate = df.parse(dateString);
        hour = "15";
        boolean result3 = instance.addOrder(items, orders, c3, paid, delPick, hour, orderTtlPrice, dNow, receiveDate, orderID);
        
        delPick = "P";
        dateString = "19-11-19";
        receiveDate = df.parse(dateString);
        hour = "6";
        boolean result4 = instance.addOrder(items, orders, c4, paid, delPick, hour, orderTtlPrice, dNow, receiveDate, orderID);
        
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        assertEquals(expResult, result4);
    }
    
}
