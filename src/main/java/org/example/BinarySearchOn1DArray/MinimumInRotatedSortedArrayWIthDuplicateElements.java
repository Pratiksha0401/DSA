package org.example.BinarySearchOn1DArray;

/**
 * This class provides a method to find the minimum element
 * in a rotated sorted array that may contain duplicate elements.
 *
 * Example:
 * Input: [4, 5, 4, 5, 0, 1, 0, 1, 2, 2]
 * Output: 0
 *
 * Algorithm:
 * - Perform a modified binary search.
 * - If left, mid, and right are equal, shrink the search space
 *   from both ends (low++, high--).
 * - If the subarray is already sorted, the leftmost element is the minimum.
 * - Otherwise, discard the half that is guaranteed not to contain the minimum.
 *
 * Time Complexity:
 *   - Best/Average Case: O(log n), similar to binary search.
 *   - Worst Case: O(n), when many duplicates exist (e.g., [2,2,2,2,2]).
 *     In this case, the algorithm may have to shrink the array one element at a time.
 *
 * Space Complexity:
 *   - O(1), since only constant extra variables are used.
 */
public class MinimumInRotatedSortedArrayWIthDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 5, 0, 1, 0, 1, 2, 2};
        final int min = findMinWithDuplicateElements(arr, arr.length);
        System.out.println("Minimum element: " + min);
    }

    /**
     * Finds the minimum element in a rotated sorted array
     * that may contain duplicate elements.
     *
     * @param arr Rotated sorted array with possible duplicates
     * @param n   Length of the array
     * @return Minimum element in the array
     *
     * Time Complexity: O(log n) on average, O(n) in the worst case with duplicates
     * Space Complexity: O(1)
     */
    public static int findMinWithDuplicateElements(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If duplicates exist on both sides, shrink range
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // If the current subarray is already sorted
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
