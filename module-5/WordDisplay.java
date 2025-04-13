/**
 * Nardos Gebremedhin
 * 05/12/2025
 * M5: Programming Assignment
 *
 * This program will read text file and then display all non-duplicate in ascending order and then in descending order
 * **/


import java.io.*;
import java.util.*;

public class WordDisplay {
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        Set<String> wordSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);


        // read from the file
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }
        // display words in ascending order
        System.out.println("Words in Ascending Order:");
        for (String word : wordSet) {
            System.out.println(word);
        }

        // display words in descending order
        System.out.println();
        System.out.println("Words in Descending Order:");
        List<String> descendingList = new ArrayList<>(wordSet);
        Collections.reverse(descendingList);
        for (String word : descendingList) {
            System.out.println(word);
        }
    }

}