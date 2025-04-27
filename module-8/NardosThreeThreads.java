import java.util.Random;

/**
 * Nardos Gebremdhin
 * 4/26/2025
 * M8: Programming Assignment
 *
 * program that has three threads to output three types of characters to a text area for display
 * */


public class NardosThreeThreads extends Thread {
    public static void main(String[] args) {

        // creating three threads
        Thread letterThread = new Thread(() -> {
            System.out.println("\n--- Random Letters ---");
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                char letter = (char) ('a' + random.nextInt(26));
                System.out.print(letter);
            }
        });

        Thread numberThread = new Thread(() -> {
            System.out.println();
            System.out.println("\n--- Random Numbers ---");
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                char digit = (char) ('0' + random.nextInt(10));
                System.out.print(digit);
            }
        });

        Thread specialCharThread = new Thread(() -> {
            System.out.println();
            System.out.println("\n--- Random Special Characters ---");
            Random random = new Random();
            char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};
            for (int i = 0; i < 10000; i++) {
                char specialChar = specialChars[random.nextInt(specialChars.length)];
                System.out.print(specialChar);
            }
        });


        try {
            // start and finish the letter thread first
            letterThread.start();
            letterThread.join();

            // start and finish the number thread
            numberThread.start();
            numberThread.join();

            // start and finish the special character thread
            specialCharThread.start();
            specialCharThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}