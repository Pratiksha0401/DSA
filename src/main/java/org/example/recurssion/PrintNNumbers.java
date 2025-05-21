package org.example.recurssion;

import java.util.Scanner;

/**
 * A class to demonstrate printing numbers from 1 to N using recursion.
 */
public class PrintNNumbers {

    // Counter to keep track of current number being printed
    static int cnt = 0;

    /**
     * Main method to read input and initiate the recursive printing.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        scn.close();

        print(n);
    }

    /**
     * Recursively prints numbers from 1 to n.
     *
     * @param n The maximum number to print.
     *
     * Time Complexity: O(n)
     * - Each recursive call prints one number, and it runs n times.
     *
     * Space Complexity: O(n)
     * - Each recursive call adds a frame to the call stack, so space used is proportional to n.
     */
    public static void print(int n) {
        if (cnt == n) {
            return;
        }
        cnt++;
        System.out.println(cnt);
        print(n);
    }
}
