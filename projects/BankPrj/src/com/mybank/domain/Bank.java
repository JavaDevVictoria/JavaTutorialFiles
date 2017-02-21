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
public class Bank {
    private static List<Customer> customers;
    private static int numberOfCustomers;
    
    static {
        customers = new ArrayList<Customer>(10);
        numberOfCustomers = 0;
    }
    
    private Bank() {
        
    }
    
    public static void addCustomer(String f, String l) {
        customers.add(new Customer(f,l));
    }
    
    public static int getNumOfCustomers() {
        return customers.size();
    }
    
    public static Customer getCustomer(int customer_index) {
        return customers.get(customer_index);
    }
    
}
