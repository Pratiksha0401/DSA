package org.example.recurssion;

/**
 * A class to demonstrate recursive computation of:
 * - The n-th Fibonacci number
 * - The full Fibonacci series up to n terms
 */
public class FibonaciSerise {

    /**
     * Main method to test Fibonacci number and series.
     *
     * @param args Command-line arguments (not used).
     */
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
     * - Because the function calls itself twice for each non-base case,
     *   the number of calls grows exponentially.
     * - This leads to a binary recursion tree of height `n`.
     *
     * Space Complexity: O(n)
     * - The maximum depth of the recursion stack is `n`.
     * - Each recursive call adds one frame to the call stack.
     */
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
