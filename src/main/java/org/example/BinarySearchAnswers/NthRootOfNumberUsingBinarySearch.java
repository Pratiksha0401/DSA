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

        System.out.println("Binary Search Safe (3, 27) = " + nthRoot(3, 27));
        System.out.println("Binary Search Safe (4, 16) = " + nthRoot(4, 16));
        System.out.println("Binary Search Safe (3, 64) = " + nthRoot(3, 64));
        System.out.println("Binary Search Safe (2, 20) = " + nthRoot(2, 20)); // not perfect root
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
            long val = 1;
            for (int j = 1; j <= n; j++) {
                val *= i;
                if (val > m) break;
            }
            if (val == m) return i;
            else if (val > m) break;
        }
        return ans;
    }

    /**
     * Helper function to check mid^n compared to m safely (avoiding overflow).
     *
     * @param mid current candidate
     * @param n power
     * @param m target number
     * @return 1 if mid^n == m, 0 if mid^n < m, 2 if mid^n > m
     */
    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) return 2; // too big
        }
        if (ans == m) return 1; // exact root
        return 0; // too small
    }

    /**
     * Optimal Binary Search approach to find the n-th root of m safely.
     *
     * @param n The root to be computed
     * @param m The number
     * @return The integer n-th root of m, or -1 if not a perfect root
     *
     * Time Complexity: O(log m * n) → binary search (log m) * checking power (n)
     * Space Complexity: O(1)
     */
    public static int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) return mid;       // found exact root
            else if (midN == 0) low = mid + 1; // mid^n < m → search right
            else high = mid - 1;             // mid^n > m → search left
        }
        return -1; // no exact integer root
    }
}
