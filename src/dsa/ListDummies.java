/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.LinkedList;
import Interfaces.Product;
import Interfaces.ListInterface;


/**
 *
 * @author User
 */
public class ListDummies {
    
    public static ListInterface<Consumer> ConsumerList() {
        ListInterface<Consumer> Consumer = new LinkedList<>();

        Consumer.add(new Consumer("CR0001", "Eden Hazard", 'I', "Block 20-2, Cardinal Apartment, Oklahama", "012-1286421"));
        Consumer.add(new Consumer("CR0002", "Alvaro Morata", 'I', "Block 90-1-4, Taman Apartment, Rawang, Selangor", "011-2134143"));
        Consumer.add(new Consumer("CR0003", "Alan", 'I', "No.23, Taman Walker, Ipoh, Perak", "010-2464312"));
        Consumer.add(new Consumer("CR0004", "Martin", 'I', "No.44, Taman Sri Rampai, Wangsa Maju, Kuala Lumpur", "018-2785832"));
        Consumer.add(new Consumer("CR0005", "Kaneki", 'I', "No. 10, Jalan Danau Kota, Setapak, Kuala Lumpur", "012-2186121"));

        return Consumer;
    }
    
    public static ListInterface<Corporate> CorporateList() {
        ListInterface<Corporate> Corporate = new LinkedList<>();

        Corporate.add(new Corporate("CP0001", "Super Flower Sdn.Bhd.", 'C', "129 Jalan Alam Shah, Wangsa Maju, Kuala Lumpur", "088421412", 990.00));
        Corporate.add(new Corporate("CP0002", "Goh Marriage Sdn.Bhd.", 'C', "13 Jalan Perindustrian 16, Bayan Lepas, Pulau Pinang", "043435234", 1990.00));
        Corporate.add(new Corporate("CP0003", "North Face Ltd.", 'C', "10 Jalan Sultan Ahmad Shah, Rawang, Selangor", "088214532", 1500.00));
        Corporate.add(new Corporate("CP0004", "ChocoPoker Ltd.", 'C', "91 Jalan Perindustrian Ipoh, Ipoh, Perak", "055242234", 1690.00));
        Corporate.add(new Corporate("CP0005", "HoneyFlower Sdn. Bhd.", 'C', "10 Jalan Perindustrian Ipoh, Ipoh, Perak", "048251872", 900.00));

        return Corporate;
    }
    
    public static ListInterface<Product> FlowerList() {
        ListInterface<Product> flowers = new LinkedList<>();

        flowers.add(new Product("F001",'F',"Rose",11,10.00,"Colour:Pink,Red,White"));
        flowers.add(new Product("F002",'F',"Orkid",11,10.00,"Orhid colour:red blue purple"));
        flowers.add(new Product("F003",'F',"Sun Flower",11,10.00,"Colour Yellow"));

        return flowers;
    }
    
    public static ListInterface<Product> BouquetList() {
        ListInterface<Product> bouquets = new LinkedList<>();

        bouquets.add(new Product("B001",'B',"WEDDING",11,60.00,"Colour Yellow"));
        bouquets.add(new Product("B002",'B',"NEW BORN",11,60.00,"Colour: Pink,Red"));

        return bouquets;
    }
    
//    public static ListInterface<Product> ArrangementList() {
//        ListInterface<Product> arrangements = new LinkedList<>();
//
//        arrangements.add(new Product("A001",'A',"Nova",11,60.00,"Colour: Pink,Red"));
//        arrangements.add(new Product("A001",'A',"Rainbow",11,60.00,"Colour: Pink,Red"));
//
//        return arrangements;
//    }
}
