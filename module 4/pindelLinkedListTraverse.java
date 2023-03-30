/*Robin Pindel
 * Module 4 LinkedList Traverse Assignment
 * 3/30/2023
 * 
 * Thie program will store a large number of integer values and then 
 * traverse the collection using different methods.
 * 
 * Reference
 * GeeksforGeeks. (2023, February 16). For-each loop in Java. GeeksforGeeks. 
 * Retrieved March 30, 2023, from https://www.geeksforgeeks.org/for-each-loop-in-java/# 
 * 
 * Java Iterator. Java iterator. (n.d.). Retrieved March 30, 2023, from https://www.w3schools.com/java/java_iterator.asp 
 *  */

import java.util.*;

public class pindelLinkedListTraverse {
    // Main method
    public static void main(String[] args) {   
        // Create ArrayList and store 50K integers
        ArrayList<Integer> _50K = new ArrayList<>();
        for (int i = 0; i < 50.000; i++) {
            _50K.add(i);
        }

        // Traverse 50K ArrayList
        long _50KStart;
        long _50KEnd;

        // Iterator
        _50KStart = Calendar.getInstance().getTimeInMillis();
        Iterator<Integer> it_50K = _50K.iterator();
        int a = it_50K.next();
        _50KEnd = Calendar.getInstance().getTimeInMillis();
        System.out.println("For each loop :: " + (_50KEnd - _50KStart) + " ms");

        // Get(index)
        _50KStart = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < _50K.size(); i++) {
            int b = _50K.get(i);
        }
        _50KEnd = Calendar.getInstance().getTimeInMillis();
        System.out.println("For each loop :: " + (_50KEnd - _50KStart) + " ms");

        // Create ArrayList and store 500K integers
        ArrayList<Integer> _500K = new ArrayList<>();
        for (int i = 0; i < 500.000; i++) {
            _500K.add(i);
        }

        // Traverse 500K ArrayList
        long _500KStart;
        long _500KEnd;

        // Iterator
        _500KStart = Calendar.getInstance().getTimeInMillis();
        Iterator<Integer> it_500K = _500K.iterator();
        int c = it_500K.next();
        _500KEnd = Calendar.getInstance().getTimeInMillis();
        System.out.println("For each loop :: " + (_500KEnd - _500KStart) + " ms");

        // Get(index)
        for (int i = 0; i < _500K.size(); i++) {
            int d = _500K.get(i);
        }
        _500KEnd = Calendar.getInstance().getTimeInMillis();
        System.out.println("For each loop :: " + (_500KEnd - _500KStart) + " ms");
    }
}
