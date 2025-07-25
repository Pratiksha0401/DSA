package org.example.array.hard;

import java.util.*;

/**
 * This class demonstrates different methods to find all elements
 * that occur more than ⌊n/3⌋ times in an integer array.
 */
public class ElementThatOccursMoreThanOne3rdOfLengthTimesORMooreVotingAlgorithm {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 3, 4, 2, 2, 3, 3};

        System.out.println("Brute Force: " + bruteForceApproach(arr));
        System.out.println("Better (Map): " + betterApproach(arr));
        System.out.println("Optimal (Voting): " + optimalApproach(arr));
        System.out.println("Optimal (Handles Negatives): " + optimalNegativeValues(arr));
    }

    /**
     * Brute Force Approach:
     * Counts the frequency of each element by comparing with every other element.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n) - result list
     */
    public static List<Integer> bruteForceApproach(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (ele == arr[j]) {
                    count++;
                }
            }
            if (count > n / 3 && !result.contains(ele)) {
                result.add(ele);
            }
        }
        return result;
    }

    /**
     * Better Approach (HashMap):
     * First pass: Count frequency of each number using a HashMap.
     * Second pass: Iterate array and pick the first two numbers (if any) that occur more than ⌊n/3⌋ times.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> betterApproach(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;

        // First pass: Count frequencies
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        // Second pass: Select elements > n/3 (preserving original logic)
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            if (hm.get(ele) > n / 3 && !list.contains(ele)) {
                list.add(ele);
            }
            if (list.size() == 2) {
                break;
            }
        }
        return list;
    }

    /**
     * Optimal Approach (Boyer-Moore Voting Algorithm):
     * Uses two candidates and counters to find potential elements.
     * Requires a second pass to confirm their actual frequencies.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static List<Integer> optimalApproach(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int ele1 = 0, ele2 = 1; // Start with different dummy values

        for (int num : arr) {
            if (num == ele1) {
                cnt1++;
            } else if (num == ele2) {
                cnt2++;
            } else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Verify candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int num : arr) {
            if (num == ele1) cnt1++;
            if (num == ele2) cnt2++;
        }

        int threshold = arr.length / 3;
        if (cnt1 > threshold) result.add(ele1);
        if (cnt2 > threshold && ele1 != ele2) result.add(ele2);

        return result;
    }

    /**
     * Optimal Approach (Boyer-Moore Voting Algorithm for All Integers):
     * Same logic as optimalApproach, but supports negative values using null checks.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static List<Integer> optimalNegativeValues(int[] arr) {
        Integer ele1 = null, ele2 = null;
        int cnt1 = 0, cnt2 = 0;

        // First pass: Find potential candidates
        for (int num : arr) {
            if (ele1 != null && ele1.equals(num)) {
                cnt1++;
            } else if (ele2 != null && ele2.equals(num)) {
                cnt2++;
            } else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Second pass: Verify actual counts
        cnt1 = cnt2 = 0;
        for (int num : arr) {
            if (ele1 != null && num == ele1) cnt1++;
            else if (ele2 != null && num == ele2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = arr.length / 3;
        if (cnt1 > threshold) result.add(ele1);
        if (cnt2 > threshold && !ele1.equals(ele2)) result.add(ele2);

        return result;
    }
}
