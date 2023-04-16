/* Robin pindel
 * Module 6 Bubble Sort Programming Assignment
 * 4/13/2023
 * 
 * This problem ... <does what?>
 * 
 * References
 * https://careydevelopment.us/2017/06/15/java-8-use-comparators-lambda-expressions/#:~:text=Here%E2%80%99s%20an%20example%20of%20a%20lambda%20expression%20that,Comparator%3CCustomer%3E%20lastNameLambdaComparator%20%3D%20%28c1%2C%20c2%29-%3Ec1.getLastName%20%28%29.compareTo%20%28c2.getLastName%20%28%29%29%3B
 * 
 * https://www.geeksforgeeks.org/sort-an-array-in-java-using-comparator/
 * 
 * https://forums.oracle.com/ords/apexds/post/bubble-sort-comparator-advice-3675
 */


import java.util.*;

public class PindelBubbleSortGeneric {
    // Main method
    public static void main(String[] args) {
        Integer[] listInteger = {151, 001, 150, 004, 133, 010, 007};
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
        bubbleSort(list, (e1, e2) -> e1.compareTo(e2));
    }

    // Comaparator interface method
    // Sort data using this interface - Pokemon names in an array?
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean nextPassNeeded = true;

        for (int r = 1; r < list.length && nextPassNeeded; r++) {
            nextPassNeeded = false;
            for (int m = 0; m < list.length - r; m++) {
                if (comparator.compare(list[m], list[r + m]) > 0) {
                    E temp = list[m];
                    list[m] = list[m + 1];
                    list[m + 1] = temp;

                    nextPassNeeded = true;
                }
            }
        }
    }
}