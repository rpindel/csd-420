/*Robin Pindel
 * Module 1 Data Work Programs Assignment
 * 3/14/2023
 * Read Data From File Program
 * This program reads data from the file pindelDataFile.dat
 */

 import java.io.*;
 import java.util.*;

public class ReadDataFromFile {
    //Main method
    public static void main (String[] args) throws ClassNotFoundException, IOException {
        try (
            ObjectInputStream inputRead = new ObjectInputStream(new FileInputStream("pindelDataFile.dat"));
        ) {
            //int[] intRandomArray = new int[5];
            //double[] doubleRandomArray = new double[5];
            
            int[] intRandomArray = (int[])(inputRead.readObject());
            Date todaysDate = (java.util.Date)(inputRead.readObject());
            double[] doubleRandomArray = (double[])(inputRead.readObject());

            for (int i = 0; i < intRandomArray.length; i++) {
            System.out.print(intRandomArray[i] + " ");
            }

            System.out.println("\n" + todaysDate);

            for (int i = 0; i < doubleRandomArray.length; i++) {
            System.out.print(doubleRandomArray[i] + " ");
            }
        }
    }
}
