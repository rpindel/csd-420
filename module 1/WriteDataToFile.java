/*Robin Pindel
 * Module 1 Data Work Programs Assignment
 * 3/14/2023
 * Write Data To File Program
 * This program writes data to a file pindelDataFile.dat
 */

import java.io.*;
import java.util.*;

public class WriteDataToFile {
    //Main method
    public static void main (String[] args) throws IOException {
        int[] intRandomArray = new int[5];
        for (int i = 0; i < 5; i++) {
            intRandomArray[i] = (int)(Math.random() * 10) + 1;          
        }
        for (int i = 0; i < intRandomArray.length; i++) {
            System.out.print(intRandomArray[i] + " ");
        }

        Date todaysDate = new java.util.Date();
        System.out.println("\n" + todaysDate);
        
        double[] doubleRandomArray = new double[5];
        for (int i = 0; i < 5; i++) {
            doubleRandomArray[i] = (double)(Math.random() * 10) + 1;
        }
        for (int i = 0; i < doubleRandomArray.length; i++) {
            System.out.print(doubleRandomArray[i] + " ");
        }
        try (
            ObjectOutputStream outputWrite = new ObjectOutputStream(new FileOutputStream("pindelDataFile.dat"));
        ) {
            outputWrite.writeObject(intRandomArray);
            outputWrite.writeObject(todaysDate);
            outputWrite.writeObject(doubleRandomArray);
        }
    }
}