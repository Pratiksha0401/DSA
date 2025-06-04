package org.example.array;

/**
 * A utility class to check if an array is a sorted and rotated array.
 */
public class SortedRotateArray {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println("Is rotated sorted: " + check(arr));  // true

        int[] arr1 = {2, 1, 3, 4};
        System.out.println("Is rotated sorted: " + check(arr1)); // false

        int[] arr2 = {1, 2, 3};
        System.out.println("Is rotated sorted: " + check(arr2)); // true
    }

    /**
     * Checks whether the given array is a rotated version of a sorted array.
     *
     * A rotated sorted array will have at most one point where the order decreases (i.e., nums[i] > nums[i+1]).
     * The check wraps around to include the comparison of the last element with the first.
     *
     * @param nums the input array to check
     * @return true if the array is a rotated sorted array, false otherwise
     *
     * Time Complexity: O(n) — one full pass through the array
     * Space Complexity: O(1) — no extra space used
     */
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Compare current element with the next, wrapping around using modulo
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // At most one decreasing point is allowed
        return count <= 1;
    }
}
