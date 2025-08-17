package org.example.hashmap;

import java.util.HashMap;

/**
 * Program to find the first non-repeating element in an array using HashMap.
 *
 * <p>Problem: Given an array of integers, find the first element that occurs exactly once.</p>
 *
 * Approach:
 * <ul>
 *   <li>Step 1: Store the frequency of each element in a HashMap.</li>
 *   <li>Step 2: Traverse the array again and return the first element with frequency = 1.</li>
 * </ul>
 *
 * Example:
 * arr = [2, 4, 6, 9, 2, 3, 4, 3, 4] → First non-repeating element = 6
 *
 * Time Complexity: O(n)  (two traversals of the array)
 * Space Complexity: O(n)  (to store frequencies in HashMap)
 */
public class HMFirstNonRepeatingEle {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 9, 2, 3, 4, 3, 4};

        int result = findFirstNonRepeating(arr);
        if (result != -1) {
            System.out.println("First non-repeating element: " + result);
        } else {
            System.out.println("No non-repeating element found.");
        }
    }

    /**
     * Finds the first non-repeating element in the array.
     *
     * @param arr input array
     * @return the first non-repeating element, or -1 if none exists
     */
    private static int findFirstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find first element with frequency = 1
        for (int num : arr) {
            if (hm.get(num) == 1) {
                return num;
            }
        }

        return -1; // No non-repeating element
    }
}
