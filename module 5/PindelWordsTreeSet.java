/* Robin Pindel
 * Module 5 Programming Assignment - TreeSet
 * 4/6/2023
 * 
 * This program ingests a text file containing words, adds unique words to a 
 * TreeSet, and then outputs the list of unique words in ascending and 
 * descending order */



import java.util.*;
import java.io.*;

public class PindelWordsTreeSet {
    // Main method
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // Ingest/read text file with words
        try (
            ObjectInputStream wordsIngress = new ObjectInputStream(new FileInputStream("collection_of_words.txt"));
        ) {
            Set<String> wordsTreeSet = new TreeSet(wordsIngress.readObject());

        }
        // Write words to a TreeSet
        // Output TreeSet in ascending order
        // Output TreeSet in descending order
    }
}
