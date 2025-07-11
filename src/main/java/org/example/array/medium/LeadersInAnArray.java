package org.example.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates two approaches to finding leaders in an array.
 * A "leader" is an element that is strictly greater than all elements to its right.
 *
 * Example:
 * Input:  [13, 14, 5, 8, 2, 6, 0, 11, 3, 2]
 * Output (leaders): [14, 11, 3, 2]
 *
 * Time Complexities:
 * - Brute Force: O(N^2)
 * - Optimal (Right to Left): O(N)
 *
 * Space Complexity:
 * - Both use O(K) space where K is number of leaders (output list)
 */
public class LeadersInAnArray {

    /**
     * Main method to demonstrate both brute-force and optimal approaches.
     */
    public static void main(String[] args) {
        int[] arr = {13, 14, 5, 8, 2, 6, 0, 11, 3, 2};

        List<Integer> resBrute = leadersOfArrayBrute(arr);
        System.out.println("Brute Force Leaders: " + resBrute);

        List<Integer> resOptimal = leadersOfArrayOptimal(arr);
        System.out.println("Optimal Leaders: " + resOptimal);
    }

    /**
     * Brute-force approach to find leaders in the array.
     * For each element, it checks all elements to the right.
     *
     * @param arr The input array of integers
     * @return A list of leader elements
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(K) where K is number of leaders
     */
    private static List<Integer> leadersOfArrayBrute(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    /**
     * Optimal approach to find leaders in the array by traversing from right to left.
     * Keeps track of the maximum element seen so far.
     *
     * @param arr The input array of integers
     * @return A list of leader elements
     *
     * Time Complexity: O(N)
     * Space Complexity: O(K) where K is number of leaders
     */
    private static List<Integer> leadersOfArrayOptimal(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        // Reverse the result to maintain left-to-right order
        Collections.reverse(list);
        return list;
    }
}
