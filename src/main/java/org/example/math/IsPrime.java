package org.example.math;

public class IsPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(5));           // true
        System.out.println(isPrimeOptimize(5));   // true
        System.out.println(isPrime(4));           // false
        System.out.println(isPrimeOptimize(4));   // false
    }

    /**
     * Checks whether a number is prime using a naive approach.
     * A number is prime if it has exactly two divisors: 1 and itself.
     *
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    /**
     * Checks whether a number is prime using an optimized approach.
     * It only iterates up to the square root of the number and counts the number of divisors.
     *
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     *
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    public static boolean isPrimeOptimize(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) {
                    count++;
                }
            }
        }
        return count == 2;
    }
}
