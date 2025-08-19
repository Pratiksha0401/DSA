package org.example.BinarySearchOn1DArray;

/**
 * This class provides a method to determine how many times
 * a sorted array (with possible duplicate elements) has been rotated.
 *
 * Key Idea:
 * - In a rotated sorted array, the number of rotations is equal to the index
 *   of the minimum element (the "pivot").
 * - Duplicates add complexity because arr[low] == arr[mid] == arr[high]
 *   can make it ambiguous which side to search, so we reduce the search
 *   space linearly in such cases.
 *
 * Example:
 *   Input: [4, 5, 5, 1, 1, 2, 3, 3]
 *   Output: 3 (array rotated 3 times, min=1 at index 3)
 *
 *   Input: [2, 2, 2, 0, 1, 2]
 *   Output: 3 (array rotated 3 times, min=0 at index 3)
 *
 *   Input: [5, 6, 7, 8, 0, 0, 1, 2]
 *   Output: 4 (array rotated 4 times, min=0 at index 4)
 *
 * Time Complexity:
 *   - O(log n) on average (binary search logic).
 *   - O(n) in the worst case when many duplicates force linear shrinking
 *     (arr[low] == arr[mid] == arr[high]).
 *
 * Space Complexity:
 *   - O(1), since only constant extra space is used.
 */
public class FindOutHowManyTimesTheArrayHasBeenRotatedWithDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 1, 1, 2, 3, 3};
        final int rotationsWithDuplicateElements = findRotationsWithDuplicateElements(arr, arr.length);
        System.out.println(rotationsWithDuplicateElements); // Output: 3

        int[] arr1 = {2, 2, 2, 0, 1, 2};
        System.out.println(findRotationsWithDuplicateElements(arr1, arr1.length)); // Output: 3

        int[] arr2 = {5, 6, 7, 8, 0, 0, 1, 2};
        System.out.println(findRotationsWithDuplicateElements(arr2, arr2.length)); // Output: 4
    }

    /**
     * Finds the number of times a rotated sorted array with duplicates
     * has been rotated. The number of rotations corresponds to the
     * index of the smallest element.
     *
     * @param arr Rotated sorted array (with duplicates allowed)
     * @param n   Length of the array
     * @return Number of rotations (index of the smallest element)
     *
     * Time Complexity: O(log n) average, O(n) worst case with duplicates
     * Space Complexity: O(1)
     */
    public static int findRotationsWithDuplicateElements(int[] arr, int n) {
        int index = -1, low = 0, high = n - 1, min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the subarray is already sorted
            if (arr[low] < arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                break;
            }

            // If duplicates are found, shrink the boundaries
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            // Right half is sorted
            else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
