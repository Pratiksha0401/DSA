package org.example.hashmap;

import java.util.HashSet;

/**
 * Program to find the number of distinct elements in an array.
 *
 * <p>Approach:
 * Use a HashSet because it stores only unique elements.
 * Simply add all elements from the array into the HashSet
 * and return its size.</p>
 *
 * Example:
 * arr = [2, 3, 4, 5, 2, 3, 6]
 * Distinct elements = {2, 3, 4, 5, 6}
 * Answer = 5
 *
 * Time Complexity: O(n)   (each insertion in HashSet is O(1) on average)
 * Space Complexity: O(n)  (HashSet stores all unique elements)
 */
public class NoOfDistinctEle {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 2, 3, 6};
        int size = noOfDistinctEle(arr);
        System.out.println("Number of distinct elements = " + size);
    }

    /**
     * Finds the count of distinct elements in an array.
     *
     * @param arr input array
     * @return number of distinct elements
     */
    private static int noOfDistinctEle(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : arr) {
            hs.add(num);
        }
        return hs.size();
    }
}
