/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Desmond Chooi
 */
public class Consumer extends Customer{
    
    private String consumerName;
    

    public Consumer() {
    }

    public Consumer(String custID, String consumerName, char custType, String custAddress, String custContact) {
        super(custID, custAddress, custContact, custType);
        this.consumerName = consumerName;
        
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public String toString() {
        return "Consumer{" + "consumerName=" + consumerName + '}';
    }

    

    
    
    
    
}
