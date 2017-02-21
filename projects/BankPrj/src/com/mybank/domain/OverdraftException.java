/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.domain;

/**
 *
 * @author HOLLANDV
 */
public class OverdraftException extends Exception {
    
    private double deficit;
    
    public OverdraftException(String msg, double deficit) {
        super(msg);
        this.deficit = deficit;
    }
    
    public double getDeficit() {
        return deficit;
    }
    
    
}
