package org.example.recurssion;

/**
 * A class to demonstrate recursive computation of:
 * - The n-th Fibonacci number
 * - The full Fibonacci series up to n terms
 */
public class FibonaciSerise {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Fibonacci number at position " + n + ": " + fibo(n));

        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibo(i) + " ");
        }
    }

    /**
     * Recursively calculates the n-th Fibonacci number.
     *
     * @param n The index (0-based) of the Fibonacci number.
     * @return The n-th Fibonacci number.
     *
     * Time Complexity: O(2^n)
     * - Each call branches into two more calls, leading to exponential growth.
     *
     * Space Complexity: O(n)
     * - Recursive stack depth is proportional to n.
     */
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
