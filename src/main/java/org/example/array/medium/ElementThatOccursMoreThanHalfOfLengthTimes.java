package org.example.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * This class finds the majority element in an array,
 * i.e., an element that occurs more than N/2 times.
 *
 * It demonstrates three methods:
 * 1. Brute-force approach
 * 2. Better approach using HashMap
 * 3. Optimal approach using Boyer-Moore Voting Algorithm
 */
public class ElementThatOccursMoreThanHalfOfLengthTimes {

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 2, 2, 2, 1, 8, 3, 4, 2, 2, 2};

        // ===================== Method 1: Brute-force =====================
        /**
         * Approach:
         * For each element, count its frequency by iterating the array again.
         * If count > n/2, set it as the majority element.
         *
         * Time Complexity: O(N^2)
         * Space Complexity: O(1)
         */
        int majorityEle = -1;
        for (int k : arr) {
            int cnt = 0;
            for (int i : arr) {
                if (k == i) {
                    cnt++;
                }
            }
            if (cnt > arr.length / 2) {
                majorityEle = k;
            }
        }

        System.out.println("Method 1 (Brute-force): Majority Element that occurs more than N/2 times: " + majorityEle);


        // ===================== Method 2: HashMap =====================
        /**
         * Approach:
         * Use a HashMap to store frequencies of each element.
         * Check which element has count > n/2.
         *
         * Time Complexity: O(N)
         * Space Complexity: O(N)
         */
        int majorityEle2 = -1;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for (int j : hm.keySet()) {
            if (hm.get(j) > arr.length / 2) {
                majorityEle2 = j;
            }
        }

        System.out.println("Method 2 (HashMap): Majority Element that occurs more than N/2 times: " + majorityEle2);


        // ===================== Method 3: Boyer-Moore Voting Algorithm =====================
        /**
         * Approach:
         * Phase 1: Find a candidate for majority using voting mechanism.
         * Phase 2: Verify if candidate is actually the majority.
         *
         * Time Complexity: O(N)
         * Space Complexity: O(1)
         */
        int cnt = 0;
        int ele = 0;
        for (int k : arr) {
            if (cnt == 0) {
                ele = k;
                cnt = 1;
            } else if (k == ele) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // Verify the candidate
        int count = 0;
        for (int i : arr) {
            if (i == ele) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            System.out.println("Method 3 (Boyer-Moore): Majority Element that occurs more than N/2 times: " + ele);
        } else {
            System.out.println("Method 3 (Boyer-Moore): No Majority Element");
        }
    }
}
