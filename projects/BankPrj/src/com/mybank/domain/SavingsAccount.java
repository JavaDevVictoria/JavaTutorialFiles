/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.domain;

/**
 *
 * @author HOLLANDV
 */
public class SavingsAccount extends Account {
    
    private double interestRate;
    
    public SavingsAccount(double initBalance, double interestRate) {
        super(initBalance);
        this.interestRate = interestRate;
    }
}
