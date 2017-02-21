/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.domain;

/**
 *
 * @author HOLLANDV
 */
public class CheckingAccount extends Account {
    
    private double overdraftAmount;
    
    public CheckingAccount(double initBalance, double overdraft) {
        super(initBalance);
        overdraftAmount = overdraft; 
    }
    
    public CheckingAccount(double initBalance) {
        this(initBalance, 0.0);

    }
    
    public void withdraw(double amt) throws OverdraftException {
            if (balance < amt) {
                double overdraftNeeded = amt - balance;
                if (overdraftAmount < overdraftNeeded) {
                    throw new OverdraftException("Insufficient funds for overdraft protection",overdraftNeeded);
                }
                else {
                    balance = 0;
                    overdraftAmount = overdraftAmount - overdraftNeeded;
                }
            }
            else {
                balance = balance - amt;
            }
        }  
}
