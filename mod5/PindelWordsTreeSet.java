/* Robin Pindel
 * Module 5 Programming Assignment - TreeSet
 * 4/6/2023
 * 
 * This program ingests a text file containing words, adds unique words to a 
 * HashSet and TreeSet, and then outputs the list of unique words in no, ascending,
 * and descending order 
 */

import java.util.*;
import java.io.*;

public class PindelWordsTreeSet {
    // Main method
    public static void main(String[] args) throws Exception {                
        // Ingest/read text file with words and create a HashSet
        // String file1 = "C:\\Users\\tk78876\\csd\\csd-420\\mod5\\collection_of_words.txt";
        String file1 = "./collection_of_words.txt"; 
        File wordFile1 = new File(file1);
        Scanner wordsIngress1 = new Scanner(wordFile1);
        Set<String> hashSet = new HashSet<>();
        while (wordsIngress1.hasNext()) {
            hashSet.add(wordsIngress1.next());
        }

        // Ingest/read text file with words and create a TreeSet
        // String file2 = "C:\\Users\\tk78876\\csd\\csd-420\\mod5\\collection_of_words.txt";
        String file2 = "./collection_of_words.txt";
        File wordFile2 = new File(file2);
        Scanner wordsIngress2 = new Scanner(wordFile2);
        NavigableSet<String> treeSet = new TreeSet<>();
        while (wordsIngress2.hasNext()) {
            treeSet.add(wordsIngress2.next());
        }

        wordsIngress1.close();
        wordsIngress2.close();

        // Output Hashset in standard (non-ordered) order
        System.out.println("\nThe collection_of_words.txt file contains these " + 
        "words, in no particular order: ");
        System.out.println(hashSet);
        
        // Output TreeSet in ascending order
        System.out.println("\nThe collection_of_words.txt file contains these " + 
        "words, in ascending order: ");
        System.out.println(treeSet);

        // Create reverse order TreeSet and output
        NavigableSet<String> revTreeSet = treeSet.descendingSet();
        System.out.println("\nThe collection_of_words.txt file contains these " + 
        "words, in descending order: ");
        System.out.println(revTreeSet);
        System.out.println("");
    }
}