package org.example.array.medium;

import java.util.*;

public class CountSubArraySumEqualsK {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 1, 5, 1, 3, 4};
        int target = 7;

        int resultCount = countSubArraySumEqualKBruteForce(arr, target);
        System.out.println("Brute Force Count: " + resultCount);

        int resultCount1 = countSubArraySumEqualKBetter(arr, target);
        System.out.println("Better Count: " + resultCount1);

        int resultCount3 = countSubArraySumEqualKOptimal(arr, target);
        System.out.println("Optimal Count: " + resultCount3);

        List<int[]> array = countSubArraySumEqualKWithIndices(arr, target);
        System.out.println("Subarrays with sum == " + target + ":");
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * Brute-force approach to count subarrays with sum equal to k.
     * Time Complexity: O(N^3)
     * Space Complexity: O(1)
     */
    public static int countSubArraySumEqualKBruteForce(int[] arr, int k) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Better approach using cumulative sum within the inner loop.
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int countSubArraySumEqualKBetter(int[] arr, int k) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal approach using prefix sum and HashMap to store frequency of sums.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int countSubArraySumEqualKOptimal(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // Initialize with sum 0 occurring once

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remove = sum - k;
            count += hm.getOrDefault(remove, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    /**
     * Returns list of subarrays [start, end] where the sum is equal to k.
     * Time Complexity: O(N^2) in worst case due to multiple starting points
     * Space Complexity: O(N^2) for storing multiple prefix indices
     */
    public static List<int[]> countSubArraySumEqualKWithIndices(int[] arr, int k) {
        int sum = 0;
        Map<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        // Initialize prefix sum 0 at index -1 to handle subarrays starting from index 0
        prefixSumMap.put(0, new ArrayList<>());
        prefixSumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int target = sum - k;

            if (prefixSumMap.containsKey(target)) {
                for (int startIndex : prefixSumMap.get(target)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Store current prefix sum index
            prefixSumMap.computeIfAbsent(sum, key -> new ArrayList<>()).add(i);
        }

        return result;
    }
}
