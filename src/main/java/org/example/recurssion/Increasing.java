package org.example.recurssion;

import java.util.Scanner;

/**
 * A class to print numbers in increasing order from 1 to N using recursion.
 */
public class Increasing {

    /**
     * Main method to read input from the user and initiate the recursive printing.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        scn.close();

        inc(n);
    }

    /**
     * Recursively prints numbers from 1 to n in increasing order.
     *
     * @param n The number up to which to print.
     *
     * Time Complexity: O(n)
     * - One recursive call and one print per number from 1 to n.
     *
     * Space Complexity: O(n)
     * - Due to recursion stack, space used is proportional to n.
     */
    public static void inc(int n) {
        if (n == 0) {
            return;
        }
        inc(n - 1);
        System.out.println(n);
    }
}
