package org.example.BinarySearchOn1DArray;

/**
 * This class provides a method to determine how many times
 * a sorted array has been rotated.
 *
 * Key Idea:
 * - A sorted rotated array has its minimum element at the "pivot" point.
 * - The index of this minimum element corresponds to the number of rotations.
 *
 * Example:
 *   Input: [3, 4, 5, 1, 2]
 *   Output: 3 (array has been rotated 3 times)
 *
 *   Input: [1, 2, 3, 4, 5]
 *   Output: 0 (no rotation)
 *
 *   Input: [1, 1, 1, 1, 1]
 *   Output: 0 (array is uniform, effectively no rotation)
 *
 * Time Complexity:
 *   - O(log n) on average, since it uses binary search.
 *   - O(n) in the worst case if there are many duplicate elements,
 *     as comparisons may degrade to linear checks.
 *
 * Space Complexity:
 *   - O(1), since only constant extra space is used.
 */
public class FindOutHowManyTimesTheArrayHasBeenRotated {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        final int rotations = findRotations(arr, arr.length);
        System.out.println(rotations); // Output: 3

        int[] arr1 = {1, 2, 3, 4, 5};
        final int rotations1 = findRotations(arr1, arr1.length);
        System.out.println(rotations1); // Output: 0

        int[] arr2 = {1, 1, 1, 1, 1};
        final int rotations2 = findRotations(arr2, arr2.length);
        System.out.println(rotations2); // Output: 0
    }

    /**
     * Finds the number of times a sorted array has been rotated.
     * The number of rotations is equal to the index of the minimum element.
     *
     * @param arr Rotated sorted array (may contain duplicates)
     * @param n   Length of the array
     * @return Number of rotations (index of the smallest element)
     *
     * Time Complexity: O(log n) average, O(n) worst case with duplicates
     * Space Complexity: O(1)
     */
    public static int findRotations(int[] arr, int n) {
        int index = -1, min = Integer.MAX_VALUE, low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the subarray is already sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    index = low;
                    min = arr[low];
                }
                break;
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
