/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author HOLLANDV
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    
    private List<Account> accounts;
    private int numberOfAccounts;
    
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;   
        //initialise accounts instance variable
        accounts = new ArrayList<Account>(10);
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void addAccount(Account acct) {
        int i = numberOfAccounts ++;
        accounts.add(acct);
    }
    
    public Account getAccount(int account_index) {
        return accounts.get(account_index);
    }
    
    public int getNumOfAccounts() {
        return accounts.size();
    }
    
}
