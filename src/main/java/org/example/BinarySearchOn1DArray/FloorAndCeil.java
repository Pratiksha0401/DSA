package org.example.BinarySearchOn1DArray;

/**
 * Demonstrates finding the Floor and Ceil of a target in a sorted array using Binary Search.
 *
 * Floor = Largest element <= target.
 * Ceil  = Smallest element >= target.
 * Returns -1 if floor/ceil doesn't exist.
 */
public class FloorAndCeil {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 8, 9, 11, 11, 15, 15, 17, 18};
        int target = 13;

        int floorValue = findFloor(arr, target);
        int ceilValue = findCeil(arr, target);

        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("Floor (largest <= target): " + floorValue);
        System.out.println("Ceil  (smallest >= target): " + ceilValue);
    }

    /**
     * Finds the floor value using Binary Search.
     *
     * @param nums   Sorted input array.
     * @param target Target value.
     * @return Floor value, or -1 if no floor exists.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findFloor(int[] nums, int target) {
        int ans = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) { // floor candidate
                ans = nums[mid];
                low = mid + 1; // try to find a bigger floor
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Finds the ceil value using Binary Search.
     *
     * @param nums   Sorted input array.
     * @param target Target value.
     * @return Ceil value, or -1 if no ceil exists.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findCeil(int[] nums, int target) {
        int ans = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) { // ceil candidate
                ans = nums[mid];
                high = mid - 1; // try to find smaller ceil
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
