package org.example.array.medium;

import java.util.Arrays;

/**
 * Class to generate the next lexicographical permutation of an integer array.
 * <p>
 * Example:
 * Input:  {6, 3, 5, 1, 8, 2, 0}
 * Output: {6, 3, 5, 2, 0, 1, 8}
 *
 * Time Complexity: O(N)
 * - Finding the pivot: O(N)
 * - Finding the element to swap: O(N)
 * - Reversing the suffix: O(N)
 *
 * Space Complexity: O(1) - in-place algorithm
 */
public class NextPermutation {

    /**
     * Main method to test the next permutation logic.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 1, 8, 2, 0};

        // Step 1: Find the pivot index (first decreasing element from the end)
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // The array is the highest permutation, reverse to get lowest
            reverse(arr, 0, arr.length - 1);
        } else {
            // Step 2: Find the smallest element greater than arr[index] from the end
            for (int i = arr.length - 1; i > index; i--) {
                if (arr[i] > arr[index]) {
                    swap(arr, i, index);
                    break;
                }
            }
            // Step 3: Reverse the suffix after the pivot
            reverse(arr, index + 1, arr.length - 1);
        }

        System.out.println("Next Permutation: " + Arrays.toString(arr));
    }

    /**
     * Utility method to swap two elements in the array.
     *
     * @param arr The input array
     * @param i   First index
     * @param j   Second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Utility method to reverse a portion of the array.
     *
     * @param arr   The input array
     * @param start Start index of the segment to reverse
     * @param end   End index of the segment to reverse
     */
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
