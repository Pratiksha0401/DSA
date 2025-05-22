package org.example.recurssion;

import java.util.Scanner;

/**
 * A class to compute the factorial of a number using a parameterized recursive approach.
 */
public class FactorialParameterizedWay {

    /**
     * Main method to read input from user and initiate recursive factorial computation.
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
            factorial(n, 1);
        }
    }

    /**
     * Calculates the factorial of a number using a parameterized recursive approach.
     *
     * @param n    The current number to multiply.
     * @param fact The accumulated factorial result so far.
     *
     * Time Complexity: O(n)
     * - One recursive call for each value from n down to 1.
     *
     * Space Complexity: O(n)
     * - Each recursive call uses one stack frame.
     */
    public static void factorial(int n, int fact) {
        if (n == 0 || n == 1) {
            System.out.println("Factorial: " + fact);
            return;
        }
        factorial(n - 1, fact * n);
    }
}
