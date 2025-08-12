package org.example.array.hard;

/**
 * This class provides three different approaches (Brute Force, Better, Optimal)
 * to find the maximum product subarray in a given integer array.
 * <p>
 * A subarray is a contiguous part of the array, and here we want the product
 * of the subarray elements to be maximized.
 */
public class MaximumProductSubArrayInAnArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};

        // Brute force approach
        final int result = bruteForce(arr);
        System.out.println("Brute Force: " + result);

        // Better approach
        final int resultBetter = better(arr);
        System.out.println("Better: " + resultBetter);

        // Optimal approach
        final int resultOptimal = optimal(arr);
        System.out.println("Optimal: " + resultOptimal);
    }

    /**
     * Brute Force Approach:
     * Try every possible subarray and calculate the product.
     *
     * @param arr input array
     * @return maximum product of any subarray
     *
     * Time Complexity: O(N^3) — Three nested loops.
     * Space Complexity: O(1) — No extra space used.
     */
    public static int bruteForce(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int tmpProduct = 1;
                for (int k = i; k <= j; k++) { // Fixed <= j to include full range
                    tmpProduct *= arr[k];
                }
                maxProduct = Math.max(maxProduct, tmpProduct);
            }
        }
        return maxProduct;
    }

    /**
     * Better Approach:
     * Instead of recalculating product for each subarray from scratch,
     * multiply incrementally while expanding the subarray.
     *
     * @param arr input array
     * @return maximum product of any subarray
     *
     * Time Complexity: O(N^2) — Two nested loops.
     * Space Complexity: O(1) — No extra space used.
     */
    public static int better(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmpProduct = 1;
            for (int j = i; j < arr.length; j++) {
                tmpProduct *= arr[j];
                maxProduct = Math.max(maxProduct, tmpProduct);
            }
        }
        return maxProduct;
    }

    /**
     * Optimal Approach:
     * Traverse from both ends (prefix & suffix) to handle negative numbers.
     * This approach works because a negative number at the start or end
     * could flip the maximum product.
     *
     * @param arr input array
     * @return maximum product of any subarray
     *
     * Time Complexity: O(N) — Single pass from both directions.
     * Space Complexity: O(1) — Only uses constant extra variables.
     */
    public static int optimal(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[arr.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }
}
