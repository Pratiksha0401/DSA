package org.example.math;

public class PrintFactors {
    public static void main(String[] args) {
        printFactors(4);
        printFactorsOptimized(5);
    }

    /**
     * Prints all factors of the given number n using a naive approach.
     * Iterates through all numbers from 1 to n and prints those that divide n evenly.
     *
     * @param n the number whose factors are to be printed
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void printFactors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * Prints all factors of the given number n using an optimized approach.
     * Iterates only up to the square root of n, printing both divisors for each divisor found.
     *
     * @param n the number whose factors are to be printed
     *
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    public static void printFactorsOptimized(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                if (n / i != i) {
                    System.out.println(n / i);
                }
            }
        }
    }
}
