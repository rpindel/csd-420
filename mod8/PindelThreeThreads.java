/* Robin Pindel
 * Module 8 Programing Assignment - Three Threads
 * 4/19/2023
 * 
 * This program creates arrays of characters and then uses threads to display elements from those arrays a defined number of times
 * 
 * References
 */

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

public class PindelThreeThreads {
    //Main method
    public static void main(String[] args) {
        // Create threadpool and execute the user-defined classes as concurrent threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new PrintAlpha(10000));
        executor.execute(new PrintNumeric(10000));
        executor.execute(new PrintSymbol(10000));

        executor.shutdown();
    }
    
}
// User-defined class that creates an array of alphabet characters and provides a method to randomly display a character
class PrintAlpha implements Runnable {
    private int times;
    private ArrayList<Character> charsList = new ArrayList<>(
        Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z'));

    public PrintAlpha(int t) {
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            int index = (int) (Math.random() * charsList.size());
            System.out.print(charsList.get(index));
        }  
    }
}
// User-defined class that creates an array of numeric characters and provides a method to randomly display a character
class PrintNumeric implements Runnable {
    private int times;
    
    public PrintNumeric(int t) {
        times = t;
    }

    @Override
    public void run() {

        for (int i = 0; i < times; i++) {
            System.out.print((int) (Math.random() * 10));
        }  
    }
}
// User-defined class that creates an array of symbol characters and provides a method to randomly display a character
class PrintSymbol implements Runnable {
    private int times;
    private ArrayList<Character> symbolList = new ArrayList<>(
        Arrays.asList('!','@','#','$','%','^','&','*','(',')','{','}',
        '[',']','|','\\','<','>','/','?'));

    public PrintSymbol(int t) {
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            int index = (int) (Math.random() * symbolList.size());
            System.out.print(symbolList.get(index));
        }  
    }
}
