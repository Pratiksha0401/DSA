package org.example.array.medium;

/**
 * This class demonstrates different approaches to solve the
 * "Maximum Subarray Sum" problem, also known as Kadane's Algorithm.
 *
 * <p>The problem is to find the contiguous subarray within a one-dimensional
 * array of numbers which has the largest sum.</p>
 *
 * <p>Two approaches are shown:</p>
 * <ul>
 *   <li><b>Brute Force:</b> Check all possible subarrays and compute their sums.
 *       (Not implemented fully in this example, only the skeleton is shown).</li>
 *   <li><b>Optimal (Kadane's Algorithm):</b> Uses dynamic programming by
 *       maintaining the maximum sum ending at each index, achieving O(n) time complexity.</li>
 * </ul>
 *
 * Example:
 * <pre>
 * Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6  // subarray [4, -1, 2, 1] has the largest sum
 * </pre>
 */
public class KadanesAlgorithmMaximumSubarraySuminanArray {

    /**
     * Main method to test the implementation of Kadane's Algorithm.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum: " + maxSubArrayOptimal(arr));
    }

    /**
     * Brute-force approach to find the maximum subarray sum.
     * <p>
     * Time Complexity: O(n^3) because it checks all possible subarrays.
     * Space Complexity: O(1)
     * </p>
     *
     * @param nums the input array
     * @return maximum subarray sum
     */
    public static int maxSubArrayBruteForce(int[] nums) {
        int sum = nums[0];
        int ma = nums[0];

        // Iterate over all possible subarray start indices
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tempSum = 0;
                // Compute sum of subarray nums[i..j]
                for (int k = i; k <= j; k++) {
                    tempSum += nums[k];
                }
                ma = Math.max(ma, tempSum);
            }
        }
        return ma;
    }

    /**
     * Optimal approach to find the maximum subarray sum using Kadane's Algorithm.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * </p>
     *
     * @param nums the input array
     * @return maximum subarray sum
     */
    public static int maxSubArrayOptimal(int[] nums) {
        int sum = nums[0]; // stores max sum ending at current index
        int ma = nums[0];  // stores global maximum sum

        for (int i = 1; i < nums.length; i++) {
            // Either start new subarray at nums[i] or extend previous subarray
            sum = Math.max(nums[i], sum + nums[i]);

            // Update global maximum
            ma = Math.max(ma, sum);
        }
        return ma;
    }
}