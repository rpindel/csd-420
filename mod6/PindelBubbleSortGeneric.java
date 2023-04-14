/* Robin pindel
 * Module 6 Bubble Sort Programming Assignment
 * 4/13/2023
 * 
 * This problem ... <does what?>
 */

import java.util.*;

public class PindelBubbleSortGeneric {
    // Main method
    public static void main(String[] args) {
        Integer[] listInteger = {001, 004, 007, 010, 133, 150, 151};
        bubbleSort(listInteger);
        for (int p = 0; p <listInteger.length; p++) {
            System.out.print(listInteger[p] + " ");
        }
        String[] listString = {"Bulbasaur", "Charmander", "Squirtle", "Pidgey", "Eevee", "Mewtwo", "Mew"};
        bubbleSort(listString, null);
        for (int p = 0; p <listString.length; p++) {
            System.out.print(listString[p] + " ");
        }

      }
    
    // Comparable interface method
    // Sort data using this interface - Pokedex numbers in an array?
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean nextPassNeeded = true;

        for (int r = 1; r < list.length && nextPassNeeded; r++) {
            nextPassNeeded = false;
            for (int m = 0; m < list.length - r; m++) {
                if ((Integer) list[r] > (Integer) list[r + 1]) {
                    E temp = list[r];
                    list[r] = list[r + 1];
                    list[r + 1] = temp;

                    nextPassNeeded = true;
                }
            }
        }
    }

    // Comaparator interface method
    // Sort data using this interface - Pokemon names in an array?
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

    }
}