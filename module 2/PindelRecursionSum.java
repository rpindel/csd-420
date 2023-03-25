/*Robin Pindel
 * Module 3 Recursin Sum Assignment
 * 3/24/2023
 * 
 * This application takes user input and recursively calculates the sum of 
 * fractions based on the user input.
 */

import java.util.*;

public class PindelRecursionSum {
    //Main method
    public static void main(String[] args) throws InputMismatchException {
        //Create scanner for user input
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Let's calculate the sum of fractions from i / (i + "
        + "1) down through 1 / 2.");
        System.out.println("Please enter an integer value for i greater than 0: ");
        
        //Try block to catch exception caused by user not inputting an integer
        //Outputs fraction sum total to console
        try {
            int i = input.nextInt();
            System.out.println("");
            System.out.println("\nThe sum of your fractions in double form is " 
            + fractionSum(i) + ".");
            System.out.println("");
        }
        //User input exception handling
        catch(Exception e) {
            System.out.println("");
            System.out.println("<< Exception - Invalid value type entered >>");
            System.out.println("Please re-run the program and enter an integer "
            + "value greated than zero.");
            System.out.println("");
            System.exit(1);
        }    
        input.close();
    }

    //Recursive method
    public static double fractionSum(double i) {
        //Recursive call for fraction sum total        
        if (i > 1) {
            System.out.println((int)i + " / " + (int)(i + 1) + " + ");
            return (i / (i + 1)) + fractionSum(i - 1);
        }
        //Base case defintion
        else {
            System.out.println((int)i + " / " + (int)(i + 1) + " =");
            return (i / (i + 1));
        }
    }
}   

