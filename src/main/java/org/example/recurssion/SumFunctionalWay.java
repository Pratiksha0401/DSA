package org.example.recurssion;

import java.util.Scanner;

/**
 * A class that calculates the sum of the first N natural numbers
 * using a functional (non-parameterized) recursive approach.
 */
public class SumFunctionalWay {

    /**
     * Main method to read input from the user and print the sum.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Sum of first " + n + " numbers: " + sumNNumbers(n));
    }

    /**
     * Recursively calculates the sum of the first n natural numbers.
     * This is a functional recursive approach where the return value of
     * each call is used in the final result.
     *
     * @param n The number up to which the sum is calculated.
     * @return The sum of numbers from 1 to n.
     *
     * Time Complexity: O(n)
     * - One recursive call for each value from n down to 1.
     *
     * Space Complexity: O(n)
     * - Each recursive call adds one frame to the call stack.
     */
    public static int sumNNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNNumbers(n - 1);
    }
}
