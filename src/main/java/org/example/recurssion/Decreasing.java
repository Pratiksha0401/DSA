package org.example.recurssion;

import java.util.Scanner;

/**
 * A class to print numbers in decreasing order from N to 1 using recursion.
 */
public class Decreasing {

    /**
     * Main method to read input and initiate the recursive print.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        scn.close();

        dec(n);
    }

    /**
     * Recursively prints numbers in decreasing order from n to 1.
     *
     * @param n The number to start printing from.
     *
     * Time Complexity: O(n)
     * - One recursive call and one print operation for each value from n to 1.
     *
     * Space Complexity: O(n)
     * - Each recursive call consumes stack space, so total space used is proportional to n.
     */
    public static void dec(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        dec(n - 1);
    }
}
