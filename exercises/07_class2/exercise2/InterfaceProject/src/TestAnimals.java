/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOLLANDV
 */
public class TestAnimals {
    
    public static void main (String args[]) {
        Fish f = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();
        
        //demonstrate different implementations of an interface
        f.play();
        c.play();
        
        //demonstrate virtual method invocation
        e.eat();
        e.walk();
        
        //demonstrate calling super methods
        a.walk();
    }
    
}
