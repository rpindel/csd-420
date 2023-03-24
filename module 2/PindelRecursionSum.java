/*Robin Pindel
 * Module 3 Recursin Sum Assignment
 * 3/24/2023
 */

import java.util.*;

public class PindelRecursionSum {
    //main method
    public static void main(String[] args) throws InputMismatchException {
        //Create scanner for user input
        Scanner input = new Scanner(System.in);
        System.out.println("Let's calculate the sum of fractions from i / i + i down through 1 / 2.");
        System.out.println("Please enter an integer value for i greater than 0: ");
        
        try {
            double i = input.nextInt();
            System.out.println("The sum of your fractions in double form is " + sum(i));
        }
        catch(Exception e) {
            System.out.println("<< Invalid value type entered >>");
            System.out.println("Please re-run the program and enter an integer value greated than zero.");
            System.exit(1);
        }    
        input.close();
    }

    //Recursive method
    public static double sum(double i) {
        if (i > 1) {
            //System.out.println("Rec n = " + i);
            return (i / (i + 1)) + sum(i - 1);
        }
        else {
            //System.out.println("Base n = " + i);
            return (i / (i + 1));
        }
    }
}   

