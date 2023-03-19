/*Robin Pindel
 * Module 1 Data Work Programs Assignment
 * 3/14/2023
 * Read Data From File Program
 * This program reads data from the file pindelDataFile.dat
 */

 import java.io.*;
 import java.util.*;

public class PindelMod1ReadDataFromFile {
    //Main method
    public static void main (String[] args) throws ClassNotFoundException, IOException {
        
        //Create input stream and read all created objects from data file pindelDataFile.dat
        try (
            ObjectInputStream inputRead = new ObjectInputStream(new FileInputStream("pindelDataFile.dat"));
        ) {
            //Create variables to assign read object data to for console display    
            int[] intRandomArray = (int[])(inputRead.readObject());
            Date todaysDate = (java.util.Date)(inputRead.readObject());
            double[] doubleRandomArray = (double[])(inputRead.readObject());

            //Console display of random integer array
            System.out.println("");
            for (int i = 0; i < intRandomArray.length; i++) {
            System.out.print(intRandomArray[i] + " ");
            }

            //Console display of date object content
            System.out.println("\n" + todaysDate);

            //Console display of random double array
            for (int i = 0; i < doubleRandomArray.length; i++) {
            System.out.print(doubleRandomArray[i] + " ");
            }
            System.out.println("\n");
        }
    }
}
