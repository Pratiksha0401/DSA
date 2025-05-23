package org.example.recurssion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates three different ways to count the frequency of integers in an array:
 * 1. Brute-force search for each target.
 * 2. Precomputed frequency using a hash array (only works for bounded small integers).
 * 3. Precomputed frequency using a HashMap (works for any range).
 */
public class NumberFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 7, 4, 8, 9};
        int[] find = {1, 2, 8, 10};

        System.out.println("Method 1: Brute-force search");
        for (int i = 0; i < find.length; i++) {
            System.out.println(find[i] + " : " + frequency(find[i], arr));
        }

        // Method 2: Using a frequency array (works when values are small & known range)
        int[] hash = new int[13]; // Assumes all elements in arr are in range 0–12
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        System.out.println("\nMethod 2: Using hash array");
        for (int i = 0; i < find.length; i++) {
            System.out.println(find[i] + " : " + hash[find[i]]);
        }

        // Method 3: Using HashMap (more flexible for arbitrary value ranges)
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        System.out.println("\nMethod 3: Using HashMap");
        for (int key : hm.keySet()) {
            System.out.println(key + " : " + hm.get(key));
        }
    }

    /**
     * Brute-force method to count how many times an element appears in an array.
     *
     * @param n   The number to search for.
     * @param arr The array to search.
     * @return Frequency count of n in arr.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int frequency(int n, int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
