package org.example.array.easy;

import java.util.*;

/**
 * This class demonstrates two methods to move all zeros in an integer array to the end,
 * while maintaining the relative order of non-zero elements.
 */
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 5, 3, 7, 0, 9, 0, 0};

        movesZerosToEndOptimal(arr);
        System.out.println("Optimal approach:");
        for (int n : arr) {
            System.out.print(n + ",");
        }
        System.out.println();

        int[] arr1 = {1, 2, 0, 5, 3, 7, 0, 9, 0, 0};
        movesZerosToEndBruteForce(arr1);
        System.out.println("Brute-force approach:");
        for (int n : arr1) {
            System.out.print(n + ",");
        }
    }

    /**
     * Moves all zeros in the array to the end using an optimal two-pointer approach.
     * This method modifies the array in-place and maintains the relative order of non-zero elements.
     *
     * Time Complexity: O(n) – where n is the length of the array.
     * Space Complexity: O(1) – constant space.
     *
     * @param arr The input array of integers.
     */
    public static void movesZerosToEndOptimal(int[] arr) {
        int j = -1;

        // Find the index of the first zero
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found, array is already fine
        if (j == -1) return;

        // Swap non-zero elements with zero
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
    }

    /**
     * Moves all zeros in the array to the end using a brute-force approach with extra space.
     * This method uses an ArrayList to temporarily store non-zero elements.
     *
     * Time Complexity: O(n) – where n is the length of the array.
     * Space Complexity: O(n) – due to the use of an auxiliary list.
     *
     * @param arr The input array of integers.
     */
    public static void movesZerosToEndBruteForce(int[] arr) {
        List<Integer> li = new ArrayList<>();

        // Collect all non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                li.add(arr[i]);
            }
        }

        // Fill the array: non-zeros followed by zeros
        int d = li.size();
        Arrays.fill(arr, 0); // Fill all with 0 first
        for (int i = 0; i < d; i++) {
            arr[i] = li.get(i);
        }
    }
}
