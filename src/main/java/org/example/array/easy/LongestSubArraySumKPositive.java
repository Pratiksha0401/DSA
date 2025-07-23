package org.example.array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumKPositive {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 2, 1, 1, 2, 1, 3};
        int k = 7;

        System.out.println(getLongestSubArrayLengthBruteForce(arr, k));       // O(N^3)
        System.out.println(getLongestSubArrayLengthBetter(arr, k));           // O(N^2)
        System.out.println(getLongestSubArrayLengthPrefixSum(arr, k));        // O(N)
        System.out.println(getLongestSubArrayLengthTwoPointer(arr, k));       // O(N)
    }

    /**
     * Brute-force approach using three nested loops to find the longest subarray with sum k.
     * Time Complexity: O(N^3)
     * Space Complexity: O(1)
     */
    public static int getLongestSubArrayLengthBruteForce(int[] arr, int k) {
        int mLen = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int l = i; l < j; l++) {
                    sum += arr[l];
                }
                if (sum == k) {
                    mLen = Math.max(mLen, j - i);
                }
            }
        }
        return mLen;
    }

    /**
     * Better approach using two nested loops to calculate the sum on the fly.
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int getLongestSubArrayLengthBetter(int[] arr, int k) {
        int mLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    mLen = Math.max(mLen, j - i + 1);
                }
            }
        }
        return mLen;
    }

    /**
     * Optimal approach using prefix sum and hashmap to store first occurrence of prefix sums.
     * Works for arrays with negative, zero, and positive integers.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int getLongestSubArrayLengthPrefixSum(int[] arr, int k) {
        int mLen = 0;
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the full prefix sum is equal to k
            if (sum == k) {
                mLen = Math.max(mLen, i + 1);
            }

            // If there exists a prefix with sum = sum - k
            int rem = sum - k;
            if (hm.containsKey(rem)) {
                int len = i - hm.get(rem);
                mLen = Math.max(mLen, len);
            }

            // Store the first occurrence of this sum
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return mLen;
    }

    /**
     * Two pointer (sliding window) technique to find longest subarray with sum = k.
     * Assumes all elements are positive (does not work with negatives).
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int getLongestSubArrayLengthTwoPointer(int[] arr, int k) {
        int mLen = 0;
        int sum = 0;
        int left = 0, right = 0;
        int n = arr.length;

        while (right < n) {
            // Expand window to the right
            sum += arr[right];

            // Shrink window from the left if sum exceeds k
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            // Update max length if sum matches k
            if (sum == k) {
                mLen = Math.max(mLen, right - left + 1);
            }

            right++;
        }

        return mLen;
    }
}