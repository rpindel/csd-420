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
    public static void main(String[] args) throws Exception {
        // Ingest/read text file with words
        File wordFile = new File(".\\collection_of_words.txt");
        Scanner wordsIngress = new Scanner(wordFile);
        
        // Write words to a HashSet and normal TreeSet
        Set<String> hashSet = new HashSet<>();
        NavigableSet<String> treeSet = new TreeSet<>();
        
        while (wordsIngress.hasNext()) {
            hashSet.add(wordsIngress.next());
            treeSet.add(wordsIngress.next());
        }

        wordsIngress.close();

        // Output Hashset in standard (non-ordered) order
        System.out.println("\nThe collection_of-words.txt file contains the " + 
        "words, in no particular order: ");
        System.out.println(hashSet);
        
        // Output TreeSet in ascending order
        System.out.println("\nThe collection_of-words.txt file contains the " + 
        "words, in ascending order: ");
        System.out.println(hashSet);

        // Create reverse order TreeSet and output
        NavigableSet<String> revTreeSet = treeSet.descendingSet();
        System.out.println("\nThe collection_of-words.txt file contains the " + 
        "words, in ascending order: ");
        System.out.println(revTreeSet);
        System.out.println("");
    }
}
