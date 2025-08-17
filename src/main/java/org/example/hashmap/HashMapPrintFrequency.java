package org.example.hashmap;

import java.util.HashMap;

/**
 * Demonstrates two approaches to find the frequency of query elements in an array.
 *
 * <p>Problem: Given an array of integers and a set of queries,
 * print how many times each query element appears in the array.</p>
 *
 * Approaches:
 * <ul>
 *   <li>{@link #printfrequency(int[], int[])} - Uses a HashMap to precompute frequencies (efficient).</li>
 *   <li>{@link #printfrequency2loops(int[], int[])} - Uses brute force nested loops (inefficient).</li>
 * </ul>
 */
public class HashMapPrintFrequency {

    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 2, 2, 6, 1, 8, 7, 4, 3};
        int queries[] = {2, 4, 7, 9};

        System.out.println("Using HashMap (efficient):");
        printfrequency(arr, queries);

        System.out.println("\nUsing Two Loops (inefficient):");
        printfrequency2loops(arr, queries);
    }

    /**
     * Prints frequency of each query element using a HashMap.
     *
     * <p>Steps:
     * <ol>
     *   <li>Build a HashMap of element → frequency in one pass.</li>
     *   <li>For each query, print its frequency if found, otherwise 0.</li>
     * </ol>
     *
     * @param arr     the input array
     * @param queries the queries to check
     *
     * Time Complexity: O(n + q)
     * Space Complexity: O(n)
     */
    public static void printfrequency(int arr[], int queries[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Answer queries
        for (int val : queries) {
            System.out.println("Frequency of " + val + " = " + hm.getOrDefault(val, 0));
        }
    }

    /**
     * Prints frequency of each query element using two loops (brute force).
     *
     * @param arr     the input array
     * @param queries the queries to check
     *
     * Time Complexity: O(n * q)
     * Space Complexity: O(1)
     */
    public static void printfrequency2loops(int arr[], int queries[]) {
        for (int val : queries) {
            int count = 0;
            for (int num : arr) {
                if (val == num) {
                    count++;
                }
            }
            System.out.println("Frequency of " + val + " = " + count);
        }
    }
}
