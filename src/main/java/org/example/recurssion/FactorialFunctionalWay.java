package org.example.recurssion;

import java.util.Scanner;

/**
 * A class to calculate the factorial of a number using a functional recursive approach.
 */
public class FactorialFunctionalWay {

    /**
     * Main method to read user input and display the factorial.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + n + " is: " + factorial(n));
        }
    }

    /**
     * Recursively calculates the factorial of a number.
     *
     * @param n The number whose factorial is to be calculated.
     * @return Factorial of n.
     *
     * Time Complexity: O(n)
     * - One recursive call per number from n down to 1.
     *
     * Space Complexity: O(n)
     * - Each recursive call uses one stack frame, totaling n frames.
     */
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
