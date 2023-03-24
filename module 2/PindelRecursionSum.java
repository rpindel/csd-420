/*Robin Pindel
 * Module 3 Recursin Sum Assignment
 * 3/24/2023
 */

import java.util.*;

public class PindelRecursionSum {
    //main method
    public static void main(String[] args) {
        //Create scanner for user input
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer value for n greater than 1: ");
        int n = input.nextInt();
        System.out.println("The sum of your fractions in double form is " + sum(n));
        input.close();
    }

    //Recursive method
    public static double sum(int n) {
        double sum = 0;
        if (n < 2) {
            return sum + (n / n + 1);
        }
        else {
            sum += (n / n + 1);
            return sum(n - 1);
        }
    }
}
