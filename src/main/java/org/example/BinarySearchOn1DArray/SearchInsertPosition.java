package org.example.BinarySearchOn1DArray;

/**
 * This class demonstrates how to find the index at which a target value
 * should be inserted into a sorted array using Binary Search.
 *
 * If the target exists in the array, its index is returned.
 * If it does not exist, the index where it should be inserted to keep
 * the array sorted is returned.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 8, 9, 11, 15, 17, 18};
        int target = 13;

        int result = searchInsert(arr, target);
        System.out.println("Search Insert Position: Target " + target +
                " should be at index " + result);
    }

    /**
     * Finds the index where the target should be inserted in the sorted array.
     *
     * @param nums   The sorted array.
     * @param target The target value.
     * @return The index of the target or the index where it should be inserted.
     *
     * Time Complexity: O(log n) — The search space is halved in each step.
     * Space Complexity: O(1) — Constant space used.
     */
    public static int searchInsert(int[] nums, int target) {
        int ans = nums.length; // Default insertion at the end
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;   // Candidate position found
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
