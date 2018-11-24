/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author User
 */
public class ItemEnjiun {
    private String itemID;
    private String itemName;
    private char type;
    private double unitPrice;
    private int quantityBought;

    public ItemEnjiun() {
    }

    public ItemEnjiun(String itemID, String itemName, char type, double unitPrice, int quantityBought) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.type = type;
        this.unitPrice = unitPrice;
        this.quantityBought = quantityBought;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    @Override
    public String toString() {
        return itemID + "  " + itemName + "  " + type + "  " + unitPrice + "  " + quantityBought;
    }
    
    
}
