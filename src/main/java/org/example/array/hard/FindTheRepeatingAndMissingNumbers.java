package org.example.array.hard;

/**
 * This program finds the repeating and missing numbers in an array of size N
 * containing numbers from 1 to N, where one number is missing and one is repeated.
 *
 * Example:
 * Input:  [2, 4, 3, 6, 1, 1]
 * Output: Repeating = 1, Missing = 5
 *
 * Approaches:
 * 1. bruteForce() - Nested loops to check counts for each number.
 * 2. better() - Using a frequency hash array to track counts in O(N).
 */
public class FindTheRepeatingAndMissingNumbers {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 1, 1};
        final int[] ints = bruteForce(arr);
        System.out.println("Brute Force Result:");
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        int[] arr1 = {2, 4, 3, 5, 2, 1};
        final int[] int1 = better(arr1);
        System.out.println("Better Approach Result:");
        for (int anInt : int1) {
            System.out.println(anInt);
        }
    }

    /**
     * Brute Force Approach:
     * For each number from 1 to N, count how many times it appears in the array.
     * - If count == 2 → repeating number
     * - If count == 0 → missing number
     *
     * @param arr Input array containing numbers 1 to N with one missing and one repeating
     * @return int[] where result[0] = repeating number, result[1] = missing number
     *
     * Time Complexity: O(N^2) — for each number, we scan the array.
     * Space Complexity: O(1) — no extra space except variables.
     */
    public static int[] bruteForce(int[] arr) {
        int repeating = -1, missing = -1;
        for (int i = 1; i <= arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i)
                    count++;
            }
            if (count == 2) repeating = i;
            else if (count == 0) missing = i;

            if (repeating != -1 && missing != -1) break;
        }
        return new int[]{repeating, missing};
    }

    /**
     * Better Approach:
     * Use a hash array (frequency array) to count occurrences of each number.
     * - If frequency == 2 → repeating number
     * - If frequency == 0 → missing number
     *
     * @param arr Input array containing numbers 1 to N with one missing and one repeating
     * @return int[] where result[0] = repeating number, result[1] = missing number
     *
     * Time Complexity: O(N) — single pass for counting + single pass for finding.
     * Space Complexity: O(N) — extra array to store frequencies.
     */
    public static int[] better(int[] arr) {
        int repeating = -1, missing = -1;
        int[] hash = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int j = 1; j < hash.length; j++) {
            if (hash[j] == 2) repeating = j;
            else if (hash[j] == 0) missing = j;
            if (repeating != -1 && missing != -1) break;
        }
        return new int[]{repeating, missing};
    }
}
