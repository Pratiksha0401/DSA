package org.example.BinarySearchOn1DArray;

/**
 * This class provides a method to search for a target element
 * in a rotated sorted array that may contain duplicate elements.
 *
 * Example 1:
 * Input array: [2, 5, 6, 0, 0, 1, 2]
 * Target: 0
 * Output: true (target found)
 *
 * Example 2:
 * Input array: [2, 5, 6, 0, 0, 1, 2]
 * Target: 3
 * Output: false (target not found)
 *
 * Time Complexity:
 *   - Best/Average Case: O(log n) when duplicates don't cause ambiguity.
 *   - Worst Case: O(n), because when arr[low] == arr[mid] == arr[high],
 *                 the algorithm reduces the search space linearly (low++, high--).
 *
 * Space Complexity:
 *   - O(1), since only a few integer variables are used.
 */
public class SearchElementInRotatedSortedArrayWithDuplicateElements {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        boolean found = searchWithDuplicates(arr, arr.length, target);
        System.out.println("Is target " + target + " present in array? " + found);
    }

    /**
     * Searches for a target element in a rotated sorted array
     * that may contain duplicate elements.
     *
     * @param arr    Rotated sorted array (may have duplicates)
     * @param n      Length of the array
     * @param target Element to search
     * @return true if target is found, otherwise false
     */
    public static boolean searchWithDuplicates(int[] arr, int n, int target) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Target found
            if (arr[mid] == target) return true;

            // If duplicates at boundaries, shrink the search space
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false; // Target not found
    }
}
