/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 * @author User
 */
public interface Order<T> {
    
    public double calculateBill(double price, int quantity);
    
}
