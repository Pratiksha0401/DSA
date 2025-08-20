package org.example.BinarySearchAnswers;

/**
 * This class provides two methods to compute the integer square root of a number.
 * <p>
 * The integer square root of a number n is defined as the largest integer "x" such that:
 *     x * x <= n
 * </p>
 *
 * Example:
 * n = 28 → sqrt = 5
 * n = 7 → sqrt = 2
 */
public class FindingSqrtOfNumberUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println("Brute Force sqrt(28) = " + findSqrtBruteForce(28));
        System.out.println("Brute Force sqrt(7) = " + findSqrtBruteForce(7));
        System.out.println("Optimal sqrt(28) = " + findSqrtOptimal(28));
        System.out.println("Optimal sqrt(7) = " + findSqrtOptimal(7));
    }

    /**
     * Brute Force approach to compute integer square root.
     * <p>
     * Iterate from 1 to n, and find the largest i such that i * i <= n.
     * </p>
     *
     * @param n The number for which square root is to be found
     * @return The floor value of sqrt(n)
     *
     * Time Complexity: O(n) → we may iterate through all numbers up to n
     * Space Complexity: O(1) → no extra space is used
     */
    public static int findSqrtBruteForce(int n) {
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    /**
     * Optimal approach to compute integer square root using Binary Search.
     * <p>
     * Perform binary search in the range [1, n].
     * If mid * mid <= n, move right to find a larger possible sqrt.
     * Otherwise, move left.
     * </p>
     *
     * @param n The number for which square root is to be found
     * @return The floor value of sqrt(n)
     *
     * Time Complexity: O(log n) → binary search reduces range by half each step
     * Space Complexity: O(1) → constant extra space is used
     */
    public static int findSqrtOptimal(int n) {
        int ans = -1;
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid * mid) <= n) {
                ans = mid;       // mid is a candidate
                low = mid + 1;   // try to find a larger sqrt
            } else {
                high = mid - 1;  // shrink search to left side
            }
        }
        return ans;
    }
}
