package org.example.array.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides two approaches to solve the problem:
 * <b>Length of the Longest Subarray with Sum 0</b>.
 *
 * <p>The goal is to find the maximum length of a contiguous subarray
 * whose elements sum to zero.</p>
 *
 * Approaches:
 * <ul>
 *     <li><b>Brute Force (O(n²))</b>:
 *         - Check all possible subarrays.
 *         - For each subarray, compute its sum.
 *         - Update the maximum length if the sum equals zero.</li>
 *
 *     <li><b>Optimal (O(n)) using HashMap</b>:
 *         - Maintain a running prefix sum.
 *         - Store the first occurrence of each prefix sum in a HashMap.
 *         - If the same prefix sum is seen again at index i and before at j,
 *           then subarray (j+1 ... i) has sum 0.
 *         - Special case: if prefix sum is 0 at index i, then subarray (0...i) has sum 0.</li>
 * </ul>
 *
 * Example:
 * <pre>
 * Input:  {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * Output: 5   // Subarray [4, -1, 2, 1, -5] has sum 0
 * </pre>
 */
public class LengthOfLongestSubArrayWith0Sum {

    /**
     * Main driver method to test both implementations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int [] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        final int result = bruteForce(arr);
        System.out.println("Brute Force Result: " + result);

        final int result1 = optimal(arr);
        System.out.println("Optimal Result: " + result1);
    }

    /**
     * Brute Force approach to find the longest subarray with sum = 0.
     * <p>
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     *
     * @param arr the input array
     * @return the length of the longest subarray with sum 0
     */
    public static int bruteForce(int [] arr){
        int mLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    mLen = Math.max(mLen, j - i + 1); // length = j - i + 1
                }
            }
        }
        return mLen;
    }

    /**
     * Optimal approach using HashMap to track prefix sums.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n) (for storing prefix sums)
     *
     * @param arr the input array
     * @return the length of the longest subarray with sum 0
     */
    public static int optimal(int arr[]){
        int mLen = 0;
        int sum = 0;
        Map<Integer,Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: If prefix sum is 0, subarray [0..i] has sum 0
            if (sum == 0) {
                mLen = i + 1;
            }
            // Case 2: If prefix sum is seen before, subarray between previous index+1 and i has sum 0
            else if (hm.containsKey(sum)) {
                mLen = Math.max(mLen, i - hm.get(sum));
            }
            // Case 3: Store the prefix sum with its index (only first occurrence)
            else {
                hm.put(sum, i);
            }
        }
        return mLen;
    }
}