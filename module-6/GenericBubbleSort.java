/**
 * Nardos Gebremdhin
 * 4/18/2025
 * M6: Programming Assignment
 *
 * program with the two generic methods using a bubble sort.
 * First method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
 * */

import java.util.Comparator;

public class GenericBubbleSort  {

    // bubble Sort using comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    // bubble Sort using comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //helper method to print arrays
    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    // testing
    public static void main(String[] args) {
        // test with int array using comparable
        Integer[] numbers = {5, 2, 9, 1, 3};
        System.out.println("Before sorting: ");
        printArray(numbers);
        System.out.println();

        bubbleSort(numbers);
        System.out.println("After sorting: ");
        printArray(numbers);

        // test with String array using comparator
        String[] words = {"Banana", "Apple", "Mango", "Cherry"};
        System.out.println();
        System.out.println("Before sorting: ");
        printArray(words);
        System.out.println();

        // Sort by length of string
        Comparator<String> lengthComparator = (a, b) -> Integer.compare(a.length(), b.length());

        bubbleSort(words, lengthComparator);
        System.out.println("After sorting by length: ");
        printArray(words);
    }

}