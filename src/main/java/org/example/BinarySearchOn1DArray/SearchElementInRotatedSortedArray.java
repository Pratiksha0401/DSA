package org.example.BinarySearchOn1DArray;

/**
 * This class provides a method to search for a target element
 * in a rotated sorted array using a modified binary search.
 *
 * Example:
 * Input array: [7,8,9,1,2,3,4,5,6]
 * Target: 1
 * Output: 3 (index of target in array)
 *
 * Time Complexity:
 *   - O(log n): Each iteration halves the search space, similar to binary search.
 *
 * Space Complexity:
 *   - O(1): No extra data structures are used, only variables for indices.
 */
public class SearchElementInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 1;
        int search = search(arr, arr.length, target);
        System.out.println("Target " + target + " found at index: " + search);
    }

    /**
     * Searches for a target element in a rotated sorted array.
     *
     * @param arr    Rotated sorted array
     * @param n      Length of the array
     * @param target Element to search
     * @return Index of target if found, otherwise -1
     */
    public static int search(int[] arr, int n, int target) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Target found
            if (arr[mid] == target) return mid;

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1; // search in left half
                } else {
                    low = mid + 1; // search in right half
                }
            }
            // Otherwise right half is sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1; // search in right half
                } else {
                    high = mid - 1; // search in left half
                }
            }
        }

        return -1; // not found
    }
}
