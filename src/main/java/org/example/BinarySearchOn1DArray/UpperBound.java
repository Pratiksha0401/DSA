package org.example.BinarySearchOn1DArray;

/**
 * This class demonstrates finding the Upper Bound of a target in a sorted array.
 *
 * Upper Bound = The smallest index 'i' such that nums[i] > target.
 * If no such element exists, return nums.length (insertion position at the end).
 */
public class UpperBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 8, 9, 11, 11, 15, 15, 17, 18};
        int target = 13;

        int resultOptimal = upperBoundOptimal(arr, target);
        System.out.println("Upper Bound (Optimal - Binary Search): Target "
                + target + " at index " + resultOptimal);

        int resultBruteForce = upperBoundBruteForce(arr, target);
        System.out.println("Upper Bound (Brute Force - Linear Search): Target "
                + target + " at index " + resultBruteForce);
    }

    /**
     * Finds the Upper Bound using Binary Search (Optimal Approach).
     *
     * @param nums   Sorted input array.
     * @param target Target value.
     * @return Index of first element > target, or nums.length if not found.
     *
     * Time Complexity: O(log n) — halves search space each step.
     * Space Complexity: O(1) — constant space.
     */
    public static int upperBoundOptimal(int[] nums, int target) {
        int ans = nums.length;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                ans = mid; // possible upper bound
                high = mid - 1; // check smaller index
            } else {
                low = mid + 1; // move right
            }
        }
        return ans;
    }

    /**
     * Finds the Upper Bound using Brute Force (Linear Search).
     *
     * @param nums   Sorted input array.
     * @param target Target value.
     * @return Index of first element > target, or nums.length if not found.
     *
     * Time Complexity: O(n) — scans entire array in worst case.
     * Space Complexity: O(1) — constant space.
     */
    public static int upperBoundBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return n; // insertion at end if all <= target
    }
}
