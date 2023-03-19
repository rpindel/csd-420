/*Robin Pindel
 * Module 1 Data Work Programs Assignment
 * 3/14/2023
 * Write Data To File Program
 * This program writes data to the file pindelDataFile.dat
 */

import java.io.*;
import java.util.*;

public class PindelMod1WriteDataToFile {
    //Main method
    public static void main (String[] args) throws IOException {
        //Create array of 5 random integers between 1 and 10
        int[] intRandomArray = new int[5];
        for (int i = 0; i < 5; i++) {
            intRandomArray[i] = (int)(Math.random() * 10) + 1;          
        }

        //Create an instance of date for today's date
        Date todaysDate = new java.util.Date();
        
        //Create array of 5 random doubles between 1 and 10
        double[] doubleRandomArray = new double[5];
        for (int i = 0; i < 5; i++) {
            doubleRandomArray[i] = (double)(Math.random() * 10) + 1;
        }

        //Create output stream and write all created objects to data file pindelDataFile.dat
        try (
            ObjectOutputStream outputWrite = new ObjectOutputStream(new FileOutputStream("pindelDataFile.dat"));
        ) {
            outputWrite.writeObject(intRandomArray);
            outputWrite.writeObject(todaysDate);
            outputWrite.writeObject(doubleRandomArray);
        }
    }
}