package org.example.BinarySearchOn1DArray;

/**
 * This class demonstrates finding the Lower Bound of a target in a sorted array.
 *
 * Lower Bound = The smallest index 'i' such that nums[i] >= target.
 * If no such element exists, return nums.length (insertion position at the end).
 */
public class LowerBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 8, 9, 11, 15, 17, 18};
        int target = 13;

        int resultOptimal = lowerBoundOptimal(arr, target);
        System.out.println("Lower Bound (Optimal - Binary Search): Target "
                + target + " at index " + resultOptimal);

        int resultBruteForce = lowerBoundBruteForce(arr, target);
        System.out.println("Lower Bound (Brute Force - Linear Search): Target "
                + target + " at index " + resultBruteForce);
    }

    /**
     * Finds the Lower Bound using Binary Search (Optimal Approach).
     *
     * @param nums   Sorted input array.
     * @param target Target value.
     * @return Index of first element >= target, or nums.length if not found.
     *
     * Time Complexity: O(log n) — halves search space each step.
     * Space Complexity: O(1) — constant space.
     */
    public static int lowerBoundOptimal(int[] nums, int target) {
        int ans = nums.length;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid; // possible lower bound
                high = mid - 1; // check if there's a smaller index
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Finds the Lower Bound using Brute Force (Linear Search).
     *
     * @param nums   Sorted input array.
     * @param target Target value.
     * @return Index of first element >= target, or nums.length if not found.
     *
     * Time Complexity: O(n) — scans entire array in worst case.
     * Space Complexity: O(1) — constant space.
     */
    public static int lowerBoundBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return n; // insertion at end if target > all elements
    }
}
