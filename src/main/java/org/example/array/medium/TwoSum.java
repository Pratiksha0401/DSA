package org.example.array.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 9, 5, 3, 4};
        int target = 11;

        int sumArr[] = twoSumBrute1(arr, target);
        System.out.println("twoSumBrute1 : " + sumArr[0] + ", " + sumArr[1]);

        int sumArr1[] = twoSumBetter(arr, target);
        System.out.println("twoSumBetter : " + sumArr1[0] + ", " + sumArr1[1]);

        int sumArr2[] = twoSumOptimal(arr, target);
        System.out.println("twoSumOptimal : " + sumArr2[0] + ", " + sumArr2[1]);
    }

    /**
     * Brute-force approach to find two indices such that their values add up to the target.
     * Checks every pair of elements in a nested loop.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr Input array
     * @param k Target sum
     * @return Indices of the two elements that sum to k
     */
    public static int[] twoSumBrute1(int arr[], int k) {
        int sum[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    sum[0] = j;
                    sum[1] = i;
                }
            }
        }
        return sum;
    }

    /**
     * Better approach using a HashMap to store and lookup complements in a single pass.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) — due to the HashMap
     *
     * @param arr Input array
     * @param k Target sum
     * @return Indices of the two elements that sum to k
     */
    public static int[] twoSumBetter(int arr[], int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int tmp = k - arr[i];
            if (hm.containsKey(tmp)) {
                sum[0] = i;
                sum[1] = hm.get(tmp);
                break; // Exit once pair is found
            } else {
                hm.put(arr[i], i);
            }
        }
        return sum;
    }

    /**
     * Optimal approach using two-pointer technique.
     * Only works when the array is sorted.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr Input array (must be sorted)
     * @param k Target sum
     * @return Indices of the two elements that sum to k
     */
    public static int[] twoSumOptimal(int arr[], int k) {
        int sum[] = new int[2];
        int sp = 0;
        int ep = arr.length - 1;

        while (sp < ep) {
            int s = arr[sp] + arr[ep];
            if (s == k) {
                sum[0] = sp;
                sum[1] = ep;
                break;
            } else if (s < k) {
                sp++;
            } else {
                ep--;
            }
        }
        return sum;
    }
}
