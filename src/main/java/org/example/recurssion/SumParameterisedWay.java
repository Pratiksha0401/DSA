package org.example.recurssion;

import java.util.Scanner;

/**
 * A class that calculates the sum of the first N natural numbers
 * using a parameterized recursive approach.
 */
public class SumParameterisedWay {

    /**
     * The main method reads an integer input and initiates
     * the recursive sum calculation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.close();

        int sum = 0;
        sumNNumbers(n, sum);
    }

    /**
     * Recursively calculates and prints the sum of numbers from 1 to n
     * using the parameterized approach where the cumulative sum is passed
     * as an argument in each recursive call.
     *
     * @param n   The current number to include in the sum.
     * @param sum The cumulative sum calculated so far.
     *
     * Time Complexity: O(n)
     * - One recursive call for each value from n down to 1.
     *
     * Space Complexity: O(n)
     * - Each recursive call adds one frame to the call stack.
     */
    public static void sumNNumbers(int n, int sum) {
        if (n < 1) {
            System.out.println("Sum: " + sum);
            return;
        }
        sumNNumbers(n - 1, sum + n);
    }
}
