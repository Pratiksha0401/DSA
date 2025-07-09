package org.example.array.medium;

/**
 * This class demonstrates a solution to the "Best Time to Buy and Sell Stock" problem.
 *
 * Problem Statement:
 *   You are given an array where each element represents the stock price on that day.
 *   You are allowed to make only one buy and one sell operation.
 *   Find the maximum profit that can be achieved.
 *
 * Example:
 *   Input: [7, 1, 5, 2, 6, 4]
 *   Output: 5 (Buy at 1, sell at 6)
 *
 * Approach:
 *   - Track the minimum stock price seen so far.
 *   - At each step, calculate the potential profit if we sell today.
 *   - Update the maximum profit if this profit is higher.
 *
 * Time Complexity: O(n), where n is the length of the array.
 *   - We iterate through the array once.
 *
 * Space Complexity: O(1)
 *   - We use only constant extra space.
 */
public class DPOnStockMaxProfit {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 2, 6, 4};

        int min = arr[0];        // Minimum price so far (assume buying on first day)
        int maxProfit = 0;       // Maximum profit initialized to 0

        // Iterate from the second day onward
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - min;              // Profit if we sell today
            maxProfit = Math.max(maxProfit, profit); // Update max profit if better
            min = Math.min(min, arr[i]);             // Update min price seen so far
        }

        System.out.println("maxProfit : " + maxProfit);
    }
}