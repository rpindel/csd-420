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
        // Create LinkedList and store 50K integers
        /*
        LinkedList<Integer> fiftyK = new LinkedList<>();
        for (int i = 0; i < 50000; i++) {
            fiftyK.add(i);
        }

        // Traverse 50K LinkedList
        long fiftyKStartIterator;
        long fiftyKEndIterator;
        long fiftyKStartIndex;
        long fiftyKEndIndex;

        // Iterator
        fiftyKStartIterator = Calendar.getInstance().getTimeInMillis();
        Iterator<Integer> itFiftyK = fiftyK.iterator();
        int a = itFiftyK.next();
        fiftyKEndIterator = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n50K using Iterator: " + (fiftyKEndIterator - fiftyKStartIterator) + " ms");
        System.out.println("Start: " + fiftyKStartIterator);
        System.out.println("End: " + fiftyKEndIterator);
        System.out.println("fiftyK.size(): " + fiftyK.size());

        // Get(index)
        fiftyKStartIndex = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < fiftyK.size(); i++) {
            int b = fiftyK.get(i);
        }
        fiftyKEndIndex = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n50K using get(index): " + (fiftyKEndIndex - fiftyKStartIndex) + " ms");
        System.out.println("Start: " + fiftyKStartIndex);
        System.out.println("End: " + fiftyKEndIndex);
        System.out.println("fiftyK.size(): " + fiftyK.size());
        System.out.println("index[0]: " + fiftyK.get(0));
        System.out.println("index[end]: " + fiftyK.get(fiftyK.size() - 1));
        */

        // Create LinkedList and store 500K integers
        LinkedList<Integer> fiveHundredK = new LinkedList<>();
        for (int i = 0; i < 500000; i++) {
            fiveHundredK.add(i);
        }

        // Traverse 500K LinkedList
        long fiveHundredKStartIterator;
        long fiveHundredKEndIterator;
        long fiveHundredKStartIndex;
        long fiveHundredKEndIndex;

        // Iterator
        fiveHundredKStartIterator = Calendar.getInstance().getTimeInMillis();
        Iterator<Integer> itFiveHundredK = fiveHundredK.iterator();
        int c = itFiveHundredK.next();
        fiveHundredKEndIterator = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n500K using Iterator: " + (fiveHundredKEndIterator - fiveHundredKStartIterator) + " ms");
        System.out.println("Start: " + fiveHundredKStartIterator);
        System.out.println("End: " + fiveHundredKEndIterator);
        System.out.println("fiveHundredK.size(): " + fiveHundredK.size());

        // Get(index)
        fiveHundredKStartIndex = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < fiveHundredK.size(); i++) {
            //int d = fiveHundredK.get(i);
            System.out.println(fiveHundredK.get(i));
        }
        fiveHundredKEndIndex = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n500K using get(index): " + (fiveHundredKEndIndex - fiveHundredKStartIndex) + " ms");
        System.out.println("Start: " + fiveHundredKStartIndex);
        System.out.println("End: " + fiveHundredKEndIndex);
        System.out.println("fivehundred.size(): " + fiveHundredK.size());
        System.out.println("index[0]: " + fiveHundredK.get(0));
        System.out.println("index[end]: " + fiveHundredK.get(fiveHundredK.size() - 1));
        System.out.println("");
    }
}
