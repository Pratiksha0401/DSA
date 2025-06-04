package org.example.array;

import java.util.*;

/**
 * Main class to demonstrate finding second largest and second smallest
 * elements in an array.
 */
public class SecondMaxMin {

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 2, 4, 1, 8, 4, 2, 8, 6};

        // Print the second largest element
        System.out.println("Second Largest: " + secondLargest(arr));

        // Print the second smallest element
        System.out.println("Second Smallest: " + secondSmallest(arr));

        // Sort the array and print it
        Arrays.sort(arr);
        System.out.print("Sorted Array: ");
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    /**
     * Finds the second largest unique element in the array.
     *
     * @param arr the input array of integers
     * @return the second largest element, or Integer.MIN_VALUE if not found
     *
     * Time Complexity: O(n) — one pass through the array
     * Space Complexity: O(1) — constant extra space
     */
    public static int secondLargest(int[] arr) {
        int secL = Integer.MIN_VALUE;
        int large = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                secL = large;
                large = arr[i];
            } else if (arr[i] > secL && arr[i] != large) {
                secL = arr[i];
            }
        }
        return secL;
    }

    /**
     * Finds the second smallest unique element in the array.
     *
     * @param arr the input array of integers
     * @return the second smallest element, or Integer.MAX_VALUE if not found
     *
     * Time Complexity: O(n) — one pass through the array
     * Space Complexity: O(1) — constant extra space
     */
    public static int secondSmallest(int[] arr) {
        int secS = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                secS = small;
                small = arr[i];
            } else if (arr[i] < secS && arr[i] != small) {
                secS = arr[i];
            }
        }
        return secS;
    }
}

