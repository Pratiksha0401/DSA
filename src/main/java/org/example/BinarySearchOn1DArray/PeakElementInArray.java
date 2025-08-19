package org.example.BinarySearchOn1DArray;

/**
 * This class provides two approaches (Brute Force and Optimal) to find a peak element in an array.
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Notes:
 * - The array may contain multiple peak elements; the methods return the index of any one peak.
 * - For boundary elements (first and last), only one neighbor needs to be considered.
 *
 * Example:
 * <pre>
 * Input: arr = {1, 2, 3, 1}
 * Output: Peak element = 3 (index 2)
 *
 * Input: arr = {5, 10, 20, 15}
 * Output: Peak element = 20 (index 2)
 * </pre>
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
     * <p>
     * We iterate through all elements and check if the current element
     * is greater than its neighbors. If yes, we record it as a peak.
     *
     * @param arr The input integer array
     * @param n   Length of the array
     * @return Index of a peak element (if found), otherwise -1
     *
     * Time Complexity: O(n) - checks every element
     * Space Complexity: O(1) - constant extra space
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
     * <p>
     * Idea:
     * - If arr[mid] < arr[mid+1], then the peak must be in the right half.
     * - Otherwise, the peak lies in the left half (including mid).
     *
     * Edge cases:
     * - If array has only 1 element → return 0
     * - If first element is greater than second → return 0
     * - If last element is greater than second last → return n-1
     *
     * @param arr The input integer array
     * @param n   Length of the array
     * @return Index of a peak element (if found), otherwise -1
     *
     * Time Complexity: O(log n) - binary search eliminates half of the array in each step
     * Space Complexity: O(1) - constant extra space
     */
    public static int peakEleOptimal(int[] arr, int n) {
        int index = -1;

        // Handle edge cases
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        // Binary search between [1, n-2]
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Peak condition
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;

                // If mid < mid+1 → peak must be on right
            else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // Otherwise → peak must be on left
            else {
                high = mid - 1;
            }
        }

        return index;
    }
}
