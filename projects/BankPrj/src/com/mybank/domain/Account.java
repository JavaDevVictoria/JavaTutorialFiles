package com.mybank.domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOLLANDV
 */
public class Account {
    
    protected double balance;
    
    protected Account(double initBalance) {
        balance = initBalance;
    }
        
        public double getBalance() {
            return balance;
        }
        
        public void deposit(double amt) {
            balance = balance + amt;
        }
        
        public void withdraw(double amt) throws OverdraftException {
            if (balance >= amt)
            {
                balance = balance - amt;
            }
            else {
                throw new OverdraftException("Insufficient funds ", amt-balance);
            }
        }   
}
