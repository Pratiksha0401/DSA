package org.example.BinarySearchAnswers;

/**
 * This class finds the n-th root of a number m using
 * both brute force and optimal binary search approaches.
 *
 * Example:
 * n = 3, m = 27 → 3 (since 3^3 = 27)
 * n = 4, m = 16 → 2 (since 2^4 = 16)
 */
public class NthRootOfNumberUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println("Brute Force (3, 27) = " + bruteForce(3, 27));
        System.out.println("Brute Force (4, 16) = " + bruteForce(4, 16));

        System.out.println("Binary Search (3, 27) = " + binarySearch(3, 27));
        System.out.println("Binary Search (4, 16) = " + binarySearch(4, 16));
        System.out.println("Binary Search (3, 64) = " + binarySearch(3, 64));
    }

    /**
     * Brute Force approach to find the n-th root of m.
     * Tries all numbers from 1 to m and checks i^n == m.
     *
     * @param n The root to be computed
     * @param m The number
     * @return The integer n-th root of m, or -1 if not a perfect root
     *
     * Time Complexity: O(m) → checks each number up to m
     * Space Complexity: O(1)
     */
    public static int bruteForce(int n, int m) {
        int ans = -1;
        for (int i = 1; i <= m; i++) {
            double val = Math.pow(i, n);
            if (val == m) {
                return i;
            } else if (val > m) {
                break;
            }
        }
        return ans;
    }

    /**
     * Optimal approach using Binary Search to find the n-th root of m.
     * Search in range [1, m]. At each step check mid^n relative to m.
     *
     * @param n The root to be computed
     * @param m The number
     * @return The integer n-th root of m, or -1 if not a perfect root
     *
     * Time Complexity: O(log m * log n) → binary search + power calculation
     * Space Complexity: O(1)
     */
    public static int binarySearch(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double val = Math.pow(mid, n);

            if (val == m) return mid;
            else if (val < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1; // not a perfect root
    }
}
