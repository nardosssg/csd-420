/**
 *
 * Nardos Gebremedhin
 * 04/05/2025
 * M3: Programming Assignment
 *
 * Program will be storing  50,000 integers in LinkedList and test the time
 * to traverse the list using an iterator vs. using the get(index) method. T
 */


import java.util.Iterator;
import java.util.LinkedList;


public class LinkedListTraversalTest {
    public static void main(String[] args) {
        // creat linked list to store int
        LinkedList<Integer> list = new LinkedList<Integer>();

        // adding 50,000 integers to the list
        for (int i = 1; i <= 50000; i++) {
            list.add(i);
        }

        // measure time taken using Iterator
        long start1 = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        // ending time
        long end1 = System.nanoTime();
        // calc the duration
        long duration1 = end1 - start1;

        // measure time taken using get(index) method
        long start2 = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
        }
        long end2 = System.nanoTime();
        long duration2 = end2 - start2;

        System.out.println("----- For 50,000 Elements -----");
        System.out.println("Time using Iterator: " + duration1 + " ns");
        System.out.println("Time using get(index): " + duration2 + " ns");
        System.out.println();


        // adding 500,000 integers to the list
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 1; i <= 500000; i++) {
            list2.add(i);
        }

        // Traversing using Iterator
        long startTime1 = System.nanoTime();
        Iterator<Integer> iterator1 = list2.iterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        long endTime1 = System.nanoTime();
        long duration11 = endTime1 - startTime1;

        // Traversing using get(index)
        long startTime2 = System.nanoTime();
        for (int i = 0; i < list2.size(); i++) {
            list2.get(i);
        }
        long endTime2 = System.nanoTime();
        long duration22 = endTime2 - startTime2;

        System.out.println("----- For 500,000 Elements -----");
        System.out.println("Time using Iterator: " + duration11 + " ns");
        System.out.println("Time using get(index): " + duration22 + " ns");

    }
    /**
     * The results show that using an Iterator is significantly faster for traversing a LinkedList because it directly
     * moves to the next element in constant time
     * while, using the get(index) is very inefficient, especially for large lists,
     * because LinkedList must traverse from the start each time to reach the specified index.

     * */


}



