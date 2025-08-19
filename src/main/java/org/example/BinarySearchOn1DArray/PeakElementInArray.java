package org.example.BinarySearchOn1DArray;

/**
 * This class provides methods to find a peak element in an array.
 * A peak element is defined as an element that is strictly greater than its neighbors.
 * <p>
 * Example:
 * arr = {1, 2, 3, 1}
 * Peak element = 3 (index 2)
 * </p>
 */
public class PeakElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};

        final int peakEle = peakEleBruteForce(arr, arr.length);
        System.out.println("Peak element using Brute Force = " + arr[peakEle]);

        final int peakEleOp = peakEleOptimal(arr, arr.length);
        System.out.println("Peak element using Optimal = " + arr[peakEleOp]);
    }

    /**
     * Brute force approach to find a peak element in an array.
     * We iterate over all elements and check if the current element
     * is greater than its neighbors.
     *
     * @param arr The input integer array
     * @param n   Length of the array
     * @return Index of a peak element (if found), otherwise -1
     *
     * Time Complexity: O(n) - we check all elements in the array
     * Space Complexity: O(1) - no extra space is used
     */
    public static int peakEleBruteForce(int[] arr, int n) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i - 1] < arr[i]) && (i == n - 1 || arr[i] > arr[i + 1])) {
                index = i; // Found peak element
            }
        }
        return index;
    }

    /**
     * Optimal approach to find a peak element in an array using Binary Search.
     * We leverage the fact that if mid is smaller than its right neighbor,
     * then a peak lies on the right side; otherwise, it lies on the left.
     *
     * @param arr The input integer array
     * @param n   Length of the array
     * @return Index of a peak element (if found), otherwise -1
     *
     * Time Complexity: O(log n) - binary search reduces the search space by half each time
     * Space Complexity: O(1) - constant space usage
     */
    public static int peakEleOptimal(int[] arr, int n) {
        int index = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Handle boundary conditions
            if ((mid == 0 || arr[mid - 1] < arr[mid]) &&
                    (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid; // Peak element found
            }

            // If mid < mid+1, peak must be in right half , eliminate left half
            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1; // Otherwise, peak is in left half, eliminate right half
            }
        }

        return index;
    }
}
