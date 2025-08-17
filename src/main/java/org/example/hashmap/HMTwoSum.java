package org.example.hashmap;

import java.util.HashMap;

/**
 * Program to check if there exists a pair of numbers in an array whose sum equals a target value.
 *
 * <p>Problem: Given an array of integers and a target value k, determine whether
 * there exists a pair (a, b) such that a + b = k.</p>
 *
 * Approach:
 * <ul>
 *   <li>Step 1: Store the frequency of each element in a HashMap.</li>
 *   <li>Step 2: Traverse the array and for each element 'a', check if 'k - a' exists.</li>
 *   <li>Handle the special case when a == b (need frequency > 1).</li>
 * </ul>
 *
 * Example:
 * arr = [2, 3, 4, -5, 2, 3, 4, 5, 2, -3, 4, 9], k = -1
 * Pair: ( -5 , 4 ) → returns true
 *
 * Time Complexity: O(n)  (single pass for frequency map + single pass for checking)
 * Space Complexity: O(n)  (HashMap to store frequencies)
 */
public class HMTwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, -5, 2, 3, 4, 5, 2, -3, 4, 9};
        int k = -1;

        boolean isTwoSumExist = isTwoSumExist(arr, k);
        System.out.println("Two sum exists for k = " + k + " ? " + isTwoSumExist);
    }

    /**
     * Checks if a pair exists in the array whose sum equals k.
     *
     * @param arr input array
     * @param k target sum
     * @return true if such a pair exists, false otherwise
     */
    private static boolean isTwoSumExist(int[] arr, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if complement exists
        for (int a : arr) {
            int b = k - a;

            if (a != b && hs.containsKey(b)) {
                return true;
            } else if (a == b && hs.get(b) > 1) {
                // need at least 2 occurrences of the same number
                return true;
            }
        }
        return false;
    }
}
