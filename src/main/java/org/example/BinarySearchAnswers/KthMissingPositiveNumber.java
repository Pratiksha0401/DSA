package org.example.BinarySearchAnswers;

/**
 * Problem:
 * You are given a sorted array of positive integers (without duplicates).
 * Find the k-th missing positive number.
 *
 * Example:
 * vec = [4,7,9,10], k = 4 → Output: 5
 *
 * Approaches:
 * 1. Brute Force → Shift k forward whenever we encounter a number <= k.
 * 2. Optimal (Binary Search) → Use the missing count formula: vec[mid] - (mid+1).
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;

        int ans = missingKBruteForce(vec, n, k);
        System.out.println("Brute Force → The missing number is: " + ans);

        int res = missingKOptimal(vec, n, k);
        System.out.println("Optimal (Binary Search) → The missing number is: " + res);
    }

    /**
     * Brute Force approach:
     * Traverse the array. If the current element <= k, increment k.
     * Otherwise, break since we found the position where k lies.
     *
     * @param vec sorted input array
     * @param n   size of array
     * @param k   k-th missing number to find
     * @return the k-th missing positive number
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int missingKBruteForce(int[] vec, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (vec[i] <= k) k++; // shift k since this number is present
            else break;
        }
        return k;
    }

    /**
     * Optimal Binary Search approach:
     * Use the fact that at index mid, the count of missing numbers is:
     * missing = vec[mid] - (mid + 1).
     *
     * - If missing < k → search right (low = mid+1).
     * - Else → search left (high = mid-1).
     *
     * Finally, the answer is k + high + 1.
     *
     * @param vec sorted input array
     * @param n   size of array
     * @param k   k-th missing number to find
     * @return the k-th missing positive number
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int missingKOptimal(int[] vec, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1); // count of missing nums till index mid

            if (missing < k) {
                low = mid + 1; // k-th missing is further right
            } else {
                high = mid - 1; // k-th missing lies to the left
            }
        }
        return k + high + 1;
    }
}
