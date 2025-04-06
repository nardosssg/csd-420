/**
 *
 * Nardos Gebremedhin
 * 04/05/2025
 * M3: Programming Assignment
 * A test program that contains a static method that returns a new ArrayList
 *
 */


import java.util.ArrayList;
import java.util.Random;


public class RemoveDuplicatesTest {

        // method to remove duplicates from ArrayList
        public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
            ArrayList<E> newList = new ArrayList<>();
            // looping through each element in the list
            for (E element : list) {
                if (!newList.contains(element)) {
                    newList.add(element);
                }
            }
            return newList;
        }


        public static void main(String[] args) {
            ArrayList<Integer> originalList = new ArrayList<>();
            Random rand = new Random();

            // Fill the original list with 50 random numbers between 1 and 20
            for (int i = 0; i < 50; i++) {
                originalList.add(rand.nextInt(20) + 1);
            }

            // display original List
            System.out.println("Original list with duplicates:");
            System.out.println(originalList);

            // calling remove method and storing in the listWithoutDuplicates
            ArrayList<Integer> listWithoutDuplicates = removeDuplicates(originalList);

            // display after removing duplicates
            System.out.println("\nList after removing duplicates:");
            System.out.println(listWithoutDuplicates);
        }

}