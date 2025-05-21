package org.example.recurssion;

import java.util.Scanner;

/**
 * A class to demonstrate a simple recursion that prints a name N times.
 */
public class PrintNameNTimes {

    /**
     * The main method reads an integer input from the user and calls
     * the recursive function to print the name N times.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt(); // Number of times the name should be printed
        printNameNTimes(1, n);
        scanner.close();
    }

    /**
     * Recursively prints the name "Pratiksha" along with the current iteration index.
     *
     * @param i Current index of the recursive call (starts from 1).
     * @param n Total number of times the name should be printed.
     *
     * Time Complexity: O(n)
     * - The function is called recursively n times.
     *
     * Space Complexity: O(n)
     * - Due to the call stack for each recursive call, space usage grows linearly with n.
     */
    public static void printNameNTimes(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("Pratiksha : " + i);
        printNameNTimes(i + 1, n);
    }
}
