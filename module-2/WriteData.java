/*
*   Nardos Gebremedhin
*   Module 2: Programming Assignment
*   03/28/2025
*
*   This program will generate an array of five random integers and five random doubles
*   then writes or append the data to a file.
* */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        //Write the data in a file titled [yourname] datafile.dat.
        String fileName = "Nardosdatafile.dat";
        Random random = new Random();

        // An array of five random integers.
        int[] intArray = new int[5];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(100);
        }
        // An array of five random double values.
        double[] doubleArray = new double[5];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = random.nextDouble() * 100;
        }

        // Write data to the file
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {


            pw.print("Integers: ");
            for (int num : intArray) {
                pw.print(num + " ");
            }
            pw.println();


            pw.print("Doubles: ");
            for (double num : doubleArray) {
                pw.print(num + " ");
            }
            pw.println();
            pw.println();

            System.out.println("Data successfully written to file.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        }
    }
