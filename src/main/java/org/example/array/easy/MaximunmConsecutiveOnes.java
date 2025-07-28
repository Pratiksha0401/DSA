package org.example.array.easy;

/**
 * This class demonstrates how to find the maximum number of consecutive 1s in a binary array.
 * <p>
 * The algorithm uses a single pass through the array, maintaining a counter for the current
 * sequence of 1s and updating the maximum when a 0 is encountered.
 *
 * Example:
 * <pre>
 * Input:  [1,1,0,1,0,1,1,1,1,0,0,1,1]
 * Output: 4  // longest run of 1s is [1,1,1,1]
 * </pre>
 */
public class MaximunmConsecutiveOnes {

    /**
     * The main method to execute the program. It initializes an array of 0s and 1s,
     * then finds and prints the maximum number of consecutive 1s.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1};

        int max = 0; // Stores the maximum number of consecutive 1s
        int cnt = 0; // Temporary counter for current sequence of 1s

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++; // Increase count if 1 is found
            } else {
                max = Math.max(max, cnt); // Update max if needed
                cnt = 0; // Reset counter when 0 is found
            }
        }

        // Edge case: if the array ends with 1s
        max = Math.max(max, cnt);

        System.out.println("Maximum number of consecutive 1s: " + max);
    }
}