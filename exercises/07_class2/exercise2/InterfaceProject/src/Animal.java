/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOLLANDV
 */
public abstract class Animal {
    
    protected int legs;
    
    protected Animal(int legs) {
        this.legs = legs;
    }
    
    public void walk() {
        System.out.println("This animal walks on " + legs + " legs");
    }
    
    public abstract void eat();
    
}
