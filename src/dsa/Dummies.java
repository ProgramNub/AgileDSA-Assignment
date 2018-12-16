/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Customer;
import Entities.ItemEnjiun;
import Entities.LinkedList;
import Entities.Order;
import Entities.Product;
import Interfaces.ListInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Dummies {
    
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static ListInterface<Consumer> ConsumerList(ListInterface<Consumer> Consumer) {

        Consumer.add(new Consumer("CR0001", "Eden Hazard", "980202-12-3838", 'I', "Block 20-2, Cardinal Apartment, Oklahama", "012-1286421"));
        Consumer.add(new Consumer("CR0002", "Alvaro Morata", "929292-39-2929",'I', "Block 90-1-4, Taman Apartment, Rawang, Selangor", "011-2134143"));
        Consumer.add(new Consumer("CR0003", "Alan","948484-38-3838", 'I', "No.23, Taman Walker, Ipoh, Perak", "010-2464312"));
        Consumer.add(new Consumer("CR0004", "Martin", "999999-99-9999",'I', "No.44, Taman Sri Rampai, Wangsa Maju, Kuala Lumpur", "018-2785832"));
        Consumer.add(new Consumer("CR0005", "Kaneki", "989898-98-9898",'I', "No. 10, Jalan Danau Kota, Setapak, Kuala Lumpur", "012-2186121"));

        return Consumer;
    }
    
    public static ListInterface<Corporate> CorporateList(ListInterface<Corporate> Corporate) {
        
        Corporate.add(new Corporate("CP0001", "Super Flower Sdn.Bhd.", 'C', "129 Jalan Alam Shah, Wangsa Maju, Kuala Lumpur", "088421412", 100.00, 'P'));
        Corporate.add(new Corporate("CP0002", "Goh Marriage Sdn.Bhd.", 'C', "13 Jalan Perindustrian 16, Bayan Lepas, Pulau Pinang", "043435234", 1990.00, 'D'));
        Corporate.add(new Corporate("CP0003", "North Face Ltd.", 'C', "10 Jalan Sultan Ahmad Shah, Rawang, Selangor", "088214532", 1500.00, 'L'));
        Corporate.add(new Corporate("CP0004", "ChocoPoker Ltd.", 'C', "91 Jalan Perindustrian Ipoh, Ipoh, Perak", "055242234", 1690.00, 'D'));
        Corporate.add(new Corporate("CP0005", "HoneyFlower Sdn. Bhd.", 'C', "10 Jalan Perindustrian Ipoh, Ipoh, Perak", "048251872", 900.00, 'L'));

        return Corporate;
    }
    
    public static ListInterface<Product> ProductList(ListInterface<Product> products) {

        products.add(new Product("F001",'F',"Rose",11,10.00,"Colour:Pink,Red,White",20,11));
        products.add(new Product("F002",'F',"Orkid",11,10.00,"Orhid colour:red blue purple",20,12));
        products.add(new Product("F003",'F',"Sun Flower",11,10.00,"Colour Yellow",0,0));
        products.add(new Product("B001",'B',"WEDDING",11,60.00,"Colour Yellow",0,0));
        products.add(new Product("B002",'B',"NEW BORN",11,60.00,"Colour: Pink,Red",0,0));

        return products;
    }

    public static ListInterface<Order> OrderList(ListInterface<Product> products, ListInterface<Corporate> custs) {
        ListInterface<Order> orderList = new LinkedList<>();
        
//        ListInterface<ItemEnjiun> itemList = new LinkedList<>();
        
        try {
            orderList.add(new Order("OD0001", 500.00, SIMPLE_DATE_FORMAT.parse("11-11-2018"), SIMPLE_DATE_FORMAT.parse("15-11-2018"), custs.get(0), 2, 'P', 'B', 12));
            orderList.add(new Order("OD0002", 100.00, SIMPLE_DATE_FORMAT.parse("20-11-2018"), SIMPLE_DATE_FORMAT.parse("22-11-2018"), custs.get(1), 2, 'D', 'B', 12));
        } catch (Exception ex) {
            Logger.getLogger(Dummies.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return orderList;
    }
}
