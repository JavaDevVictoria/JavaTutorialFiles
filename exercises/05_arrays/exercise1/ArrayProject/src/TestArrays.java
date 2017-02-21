/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOLLANDV
 */
public class TestArrays {
    
    public static void main (String args[]) {
        int[] array1 = {2,3,5,7,11,13,17,19};
        printArray(array1);  
        
        int[] array2 = array1;
        
        for (int i = 0; i < array2.length; i=i+2) {
            array2[i] = i;
        }
        printArray(array1);
    }
    
    public static void printArray(int[] array) {
        System.out.print("<");
        for ( int i = 0; i < array.length; i++ ) {
            // print an element
            System.out.print(array[i]);
            // print a comma delimiter if not the last element
            if ( (i + 1) < array.length ) {
            System.out.print(", ");
            }
        }
        System.out.print(">");
    }  
}
