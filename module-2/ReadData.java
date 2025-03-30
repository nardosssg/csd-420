/*
 *   Nardos Gebremedhin
 *   Module 2: Programming Assignment
 *   03/28/2025
 *
 *   This program will read the data from the file and display it.
 * */
import java.io.*;

public class ReadData {
    public static void main(String[] args) {
        String fileName = "Nardosdatafile.dat";

        // read data from the file and print
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File NOT found. Please run the WriteData program first.");
        } catch (IOException e) {
            System.out.println("ERROR occurred while reading the file!");
            e.printStackTrace();
        }

    }
}
