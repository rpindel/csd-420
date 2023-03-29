/*Robin Pindel
 * Module 3 ArrayList Dedup
 * 3/28/2023
 * 
 * This program will generate an ArrayList of random ints and then dedup that 
 * ArrayList into a new ArrayList
 */

import java.util.*;

public class PindelDedupArrayList {
    // Main method
    public static void main(String[] args) {
        // Create ArrayList
        ArrayList<Integer> arrayDup = new ArrayList<>();

        // Populate ArrayList with 50 random values from 1-20
        for (int i = 0; i < 50; i++) {
            arrayDup.add((int)(Math.random() * 20));
        }

        // Print original ArrayList to console
        System.out.println("");
        System.out.println("The original ArrayList is: ");
        arrayDup.forEach(e -> System.out.print(e + " "));

        //Create new ArrayList and populate it with dedup'd values from 
        //original ArrayList
        ArrayList<Integer> arrayDedup = removeDuplicates(arrayDup);

        // Print new ArrayList
        System.out.println("");
        System.out.println("\nThe dedup'd ArrayList is: ");
        arrayDedup.forEach(e -> System.out.print(e + " "));
        System.out.println("");
        System.out.println("");
    }
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Create new ArrayList        
        ArrayList<E> arrayDedup = new ArrayList<>();

        for (E element : list) {
            if (!arrayDedup.contains(element)) {
                arrayDedup.add(element);
            }
        }
        return arrayDedup;
    }
} 