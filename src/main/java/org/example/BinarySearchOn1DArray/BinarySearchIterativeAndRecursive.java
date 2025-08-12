package org.example.BinarySearchOn1DArray;

/**
 * This class demonstrates both iterative and recursive implementations
 * of Binary Search on a sorted 1D integer array.
 *
 * Binary Search works only on sorted arrays and has a time complexity of O(log n).
 */
public class BinarySearchIterativeAndRecursive {
    public static void main(String[] args) {
        // Array must be sorted
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        int resultIndex = iterativeApproach(arr, target);
        System.out.println("Iterative Binary Search: Target " + target +
                (resultIndex != -1 ? " found at index " + resultIndex : " not found"));

        int resultIndexRecursive = recursiveApproach(arr, 0, arr.length - 1, target);
        System.out.println("Recursive Binary Search: Target " + target +
                (resultIndexRecursive != -1 ? " found at index " + resultIndexRecursive : " not found"));
    }

    /**
     * Performs Binary Search using an iterative approach.
     *
     * @param arr    The sorted integer array to search.
     * @param target The value to search for.
     * @return Index of the target if found, otherwise -1.
     *
     * Time Complexity: O(log n) — The search space is halved in each step.
     * Space Complexity: O(1) — Constant extra space used.
     */
    public static int iterativeApproach(int[] arr, int target) {
        int index = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                index = mid;
                break; // Exit once found
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    /**
     * Performs Binary Search using a recursive approach.
     *
     * @param arr    The sorted integer array to search.
     * @param low    The lower bound index of the current search space.
     * @param high   The upper bound index of the current search space.
     * @param target The value to search for.
     * @return Index of the target if found, otherwise -1.
     *
     * Time Complexity: O(log n) — The search space is halved in each recursive call.
     * Space Complexity: O(log n) — Due to recursion stack space.
     */
    public static int recursiveApproach(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return recursiveApproach(arr, low, mid - 1, target);
        } else {
            return recursiveApproach(arr, mid + 1, high, target);
        }
    }
}
