package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the Merge Sort algorithm for sorting an integer array.
 * Merge Sort is a divide-and-conquer algorithm with a time complexity of O(n log n).
 */
public class MergeSort {

    /**
     * The main method where execution begins.
     * It initializes an unsorted array, sorts it using merge sort,
     * and prints the sorted elements.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr = {13, 58, 4, 64, 2, 74, 13, 6, 45};

        // Sort the array using merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * Recursively sorts the given array using the Merge Sort algorithm.
     *
     * @param arr the array to be sorted
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     */
    public static void mergeSort(int[] arr, int low, int high) {
        // Base case: a single-element array is already sorted
        if (low == high) {
            return;
        }

        // Find the midpoint to divide the array
        int mid = low + (high - low) / 2;

        // Recursively sort the left and right halves
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // Merge the sorted halves
        merge(arr, low, mid, high);
    }

    /**
     * Merges two sorted subarrays of arr[].
     * First subarray is arr[low..mid]
     * Second subarray is arr[mid+1..high]
     *
     * @param arr the original array containing the subarrays
     * @param low the starting index of the first subarray
     * @param mid the ending index of the first subarray
     * @param high the ending index of the second subarray
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        // Temporary list to hold the merged result
        List<Integer> tmp = new ArrayList<>();

        int left = low;      // Starting index for the left subarray
        int right = mid + 1; // Starting index for the right subarray

        // Merge elements from both subarrays in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tmp.add(arr[left]);
                left++;
            } else {
                tmp.add(arr[right]);
                right++;
            }
        }

        // Copy any remaining elements from the left subarray
        while (left <= mid) {
            tmp.add(arr[left]);
            left++;
        }

        // Copy any remaining elements from the right subarray
        while (right <= high) {
            tmp.add(arr[right]);
            right++;
        }

        // Copy merged elements back into the original array
        for (int i = low; i <= high; i++) {
            arr[i] = tmp.get(i - low);
        }
    }
}
