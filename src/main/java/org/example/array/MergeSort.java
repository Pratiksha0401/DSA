package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeSort implementation in Java.
 *
 * Time Complexity:
 *   - Best Case:    O(n log n)
 *   - Average Case: O(n log n)
 *   - Worst Case:   O(n log n)
 *
 * Space Complexity:
 *   - O(n) extra space for temporary list used during merge.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 3, 9, 1, 5, 2, 7, 6};

        // Sorting the array using merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Printing the sorted array
        for (int n : arr) {
            System.out.print(n + ",");
        }
    }

    /**
     * Recursively divides the array into halves and sorts each half.
     *
     * Time Complexity per call: O(log n) recursive depth
     * Total Time Complexity: O(n log n)
     *
     * @param arr  the array to sort
     * @param low  starting index
     * @param high ending index
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return; // Base case: one element
        }

        int mid = low + (high - low) / 2;

        // Recursively sort left and right halves
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // Merge the sorted halves
        merge(arr, low, mid, high);
    }

    /**
     * Merges two sorted subarrays: arr[low..mid] and arr[mid+1..high].
     *
     * Time Complexity: O(n) where n = high - low + 1
     * Space Complexity: O(n) temporary list
     *
     * @param arr  original array
     * @param low  start index of the first sorted subarray
     * @param mid  end index of the first sorted subarray
     * @param high end index of the second sorted subarray
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> tmp = new ArrayList<>(); // Temporary storage for merged result

        int left = low;
        int right = mid + 1;

        // Compare and merge elements from both halves
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                tmp.add(arr[left++]);
            } else {
                tmp.add(arr[right++]);
            }
        }

        // Copy any remaining elements from the left half
        while (left <= mid) {
            tmp.add(arr[left++]);
        }

        // Copy any remaining elements from the right half
        while (right <= high) {
            tmp.add(arr[right++]);
        }

        // Copy merged elements back into original array
        for (int i = low; i <= high; i++) {
            arr[i] = tmp.get(i - low);
        }
    }
}
