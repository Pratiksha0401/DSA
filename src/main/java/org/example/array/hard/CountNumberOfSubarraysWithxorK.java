package org.example.array.hard;

import java.util.HashMap;

/**
 * This class demonstrates three approaches to solve the problem:
 * <b>Count Number of Subarrays with XOR = K</b>.
 *
 * Problem:
 * Given an array and an integer K, count how many subarrays have XOR equal to K.
 *
 * Approaches:
 * <ul>
 *   <li><b>Brute Force (O(n^3))</b>: Generate all subarrays, compute XOR each time.</li>
 *   <li><b>Better Force (O(n^2))</b>: Maintain running XOR while extending subarray.</li>
 *   <li><b>Optimal (O(n))</b>: Use prefix XOR + HashMap to count efficiently.</li>
 * </ul>
 *
 * Example:
 * <pre>
 * Input: arr = [4, 2, 2, 6, 4], K = 6
 * Output: 4
 * Subarrays: [4,2], [6], [2,2,6], [4,2,2,6,4]
 * </pre>
 */
public class CountNumberOfSubarraysWithxorK {
    /**
     * Main method to test all three approaches.
     */
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int target = 6;

        int resultCnt1 = bruteForce(arr, target);
        System.out.println("Brute Force: " + resultCnt1);

        int resultCnt2 = betterForce(arr, target);
        System.out.println("Better Force: " + resultCnt2);

        int resultCnt3 = xorOptimal(arr, target);
        System.out.println("Optimal: " + resultCnt3);
    }

    /**
     * Brute Force approach: Check all subarrays.
     *
     * Steps:
     * 1. Generate all possible subarrays using two loops.
     * 2. For each subarray, compute XOR (third loop).
     * 3. If XOR equals k, increment count.
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @param k target XOR value
     * @return number of subarrays with XOR = k
     */
    public static int bruteForce(int[] nums, int k) {
        int count = 0;

        // Step 1: Pick starting index
        for (int i = 0; i < nums.length; i++) {
            // Step 2: Pick ending index
            for (int j = i; j < nums.length; j++) {
                int xor = 0;
                // Step 3: Compute XOR of subarray [i..j]
                for (int l = i; l <= j; l++) {
                    xor = xor ^ nums[l];
                }
                // Step 4: If XOR equals target, increment counter
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Better approach: Maintain running XOR for each subarray.
     *
     * Steps:
     * 1. Fix starting index i.
     * 2. Extend subarray by moving j, updating running XOR.
     * 3. If running XOR == k, increment count.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @param k target XOR value
     * @return number of subarrays with XOR = k
     */
    public static int betterForce(int[] nums, int k) {
        int count = 0;

        // Step 1: Pick starting index
        for (int i = 0; i < nums.length; i++) {
            int xor = 0; // running XOR
            // Step 2: Extend subarray
            for (int j = i; j < nums.length; j++) {
                xor ^= nums[j];
                // Step 3: If XOR equals k, increment count
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal approach using Prefix XOR + HashMap.
     *
     * Steps:
     * 1. Maintain a running prefix XOR.
     * 2. For each index i:
     *    - Compute xor = xor ^ nums[i].
     *    - To find subarray with XOR = k, check if (xor ^ k) exists in map.
     *    - If exists, add its frequency to count.
     * 3. Store/update frequency of prefix XOR in HashMap.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums input array
     * @param k target XOR value
     * @return number of subarrays with XOR = k
     */
    public static int xorOptimal(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> prefixXor = new HashMap<>();
        prefixXor.put(0, 1); // Base case: prefix XOR = 0 occurs once
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            // Step 1: Update running prefix XOR
            xor ^= nums[i];

            // Step 2: Check if xor ^ k exists in map
            int tmp = xor ^ k;
            if (prefixXor.containsKey(tmp)) {
                count += prefixXor.get(tmp);
            }

            // Step 3: Update frequency of current prefix XOR
            prefixXor.put(xor, prefixXor.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}