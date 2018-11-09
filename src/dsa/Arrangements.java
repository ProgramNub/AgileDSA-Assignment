/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.List;

/**
 *
 * @author User
 */
public class Arrangements {

    private String style;
    private char size;
    private List flowers;
    private char priority;
    
    public Arrangements() {
    }

    public Arrangements(String style, char size, List flowers, char priority) {
        this.style = style;
        this.size = size;
        this.flowers = flowers;
        this.priority = priority;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public List getFlowers() {
        return flowers;
    }

    public void setFlowers(List flowers) {
        this.flowers = flowers;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }
    
    
    
}
