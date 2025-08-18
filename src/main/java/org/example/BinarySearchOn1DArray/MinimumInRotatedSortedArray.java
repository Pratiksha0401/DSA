package org.example.BinarySearchOn1DArray;

/**
 * This class provides methods to find the minimum element
 * in a rotated sorted array without duplicates.
 *
 * Example:
 * Input: [4, 5, 6, 7, 0, 1, 2, 3]
 * Output: 0
 *
 * Time Complexity:
 *   - O(log n) for both methods, since binary search is applied.
 *   - In worst case with duplicates (not handled here), it can degrade to O(n).
 *
 * Space Complexity:
 *   - O(1), as only a few variables are used.
 */
public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        final int min = findMin(arr, arr.length);
        System.out.println("Minimum element (standard approach): " + min);

        int[] nums = {1, 2, 3, 4, 5};
        final int minOptimal = findMinOptimal(nums, nums.length);
        System.out.println("Minimum element (optimal approach): " + minOptimal);
    }

    /**
     * Finds the minimum element in a rotated sorted array
     * using binary search.
     *
     * @param arr Rotated sorted array (no duplicates assumed)
     * @param n   Length of the array
     * @return Minimum element in the array
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findMin(int[] arr, int n) {
        int min = Integer.MAX_VALUE, low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    /**
     * Optimized method to find the minimum element in a rotated sorted array.
     * Stops early if the subarray is already sorted.
     *
     * @param arr Rotated sorted array (no duplicates assumed)
     * @param n   Length of the array
     * @return Minimum element in the array
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findMinOptimal(int[] arr, int n) {
        int min = Integer.MAX_VALUE, low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the subarray is already sorted
            if (arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
