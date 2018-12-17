/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import Entities.Consumer;
import Entities.Corporate;
import Entities.Customer;
import Entities.LinkedList;
import Interfaces.ListInterface;
import static dsa.CustomerUtility.displayConsumerList;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asus
 */
public class CustomerUtilityTest {

    public CustomerUtilityTest() {
    }

    @Before
    public void setUp() {
    }

//    /**
//     * Test of displayCustomer method, of class CustomerUtility.
//     */
//    @Test
//    public void testDisplayCustomer() {
//        System.out.println("displayCustomer");
//        ListInterface<Consumer> Consumer = null;
//        ListInterface<Corporate> Corporate = null;
//        CustomerUtility.displayCustomer(Consumer, Corporate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of displayConsumerList method, of class CustomerUtility.
//     */
//    @Test
//    public void testDisplayConsumerList_0args() {
//        System.out.println("displayConsumerList");
//        ListInterface<Consumer> expResult = null;
//        ListInterface<Consumer> result = CustomerUtility.displayConsumerList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of displayCorporateList method, of class CustomerUtility.
//     */
//    @Test
//    public void testDisplayCorporateList_0args() {
//        System.out.println("displayCorporateList");
//        ListInterface<Corporate> expResult = null;
//        ListInterface<Corporate> result = CustomerUtility.displayCorporateList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of displayConsumerList method, of class CustomerUtility.
//     */
//    @Test
//    public void testDisplayConsumerList_ListInterface() {
//        System.out.println("displayConsumerList");
//        ListInterface<Consumer> displayConsumer = null;
//        CustomerUtility.displayConsumerList(displayConsumer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of displayCorporateList method, of class CustomerUtility.
//     */
//    @Test
//    public void testDisplayCorporateList_ListInterface() {
//        System.out.println("displayCorporateList");
//        ListInterface<Corporate> displayCorporate = null;
//        CustomerUtility.displayCorporateList(displayCorporate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of mainMenu method, of class CustomerUtility.
//     */
//    @Test
//    public void testMainMenu() {
//        System.out.println("mainMenu");
//        int expResult = 0;
//        int result = CustomerUtility.mainMenu();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registerNewCustomer method, of class CustomerUtility.
//     */
//    @Test
//    public void testRegisterNewCustomer() {
//        System.out.println("registerNewCustomer");
//        ListInterface<Consumer> Consumer = null;
//        ListInterface<Corporate> Corporate = null;
//        CustomerUtility.registerNewCustomer(Consumer, Corporate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of AddConsumer method, of class CustomerUtility.
//     */
//    @Test
//    public void testAddConsumer() {
//        System.out.println("AddConsumer");
//        ListInterface<Consumer> consumerList = null;
//        CustomerUtility.AddConsumer(consumerList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of AddCorporate method, of class CustomerUtility.
//     */
//    @Test
//    public void testAddCorporate() {
//        System.out.println("AddCorporate");
//        ListInterface<Corporate> corporateList = null;
//        CustomerUtility.AddCorporate(corporateList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateCustomer method, of class CustomerUtility.
//     */
//    @Test
//    public void testUpdateCustomer() {
//        System.out.println("updateCustomer");
//        ListInterface<Consumer> Consumer = null;
//        ListInterface<Corporate> Corporate = null;
//        CustomerUtility.updateCustomer(Consumer, Corporate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateConsumer method, of class CustomerUtility.
     */
    @Test
    public void testUpdateConsumer() {
        System.out.println("updateConsumer");

        ListInterface<Consumer> cons = Dummies.ConsumerList(new LinkedList<>());
        String choice = "CR0001";
        String conName = "";
        String conAddress = "";
        String conContact = "";
        boolean consumerFound = false;
        Consumer consumer = null;

        for (int i = 0; i < cons.size(); i++) {
            if (cons.get(i).getCustID().equals(choice)) {
                consumer = cons.get(i);
                consumerFound = true;
                break;
            }
        }

        //Update Consumer Details
        consumer.setConsumerName(conName);
        consumer.setCustAddress(conAddress);
        consumer.setCustContact(conContact);
        
        assertEquals(5, cons.size());
    }

//    /**
//     * Test of updateCorporate method, of class CustomerUtility.
//     */
//    @Test
//    public void testUpdateCorporate() {
//        System.out.println("updateCorporate");
//        ListInterface<Corporate> corp = null;
//        CustomerUtility.updateCorporate(corp);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchCorp method, of class CustomerUtility.
//     */
//    @Test
//    public void testSearchCorp() {
//        System.out.println("searchCorp");
//        Customer customer = null;
//        ListInterface<Corporate> corporates = null;
//        Corporate corp = null;
//        CustomerUtility instance = new CustomerUtility();
//        Corporate expResult = null;
//        Corporate result = instance.searchCorp(customer, corporates, corp);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
