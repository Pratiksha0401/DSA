package org.example.array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides multiple implementations to find the
 * length of the longest consecutive sequence in an unsorted array.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int arr[] = {103, 2, 4, 101, 1, 3, 102, 5, 104};
        int resL = longestConsecutiveSeqLengthBrute(arr);
        System.out.println(resL); // Output: 5 (1-2-3-4-5)

        int arr1[] = {103, 103, 103, 4, 4, 4, 102, 102, 102, 2, 2, 2, 4,
                101, 101, 101, 1, 1, 1, 1, 3, 3, 3, 3, 102, 5, 5, 5, 5, 104};
        int resLo = longestConsecutiveSeqLengthBetter(arr1);
        System.out.println(resLo); // Output: 5

        int arr2[] = {103, 103, 103, 4, 4, 4, 102, 102, 102, 2, 2, 2, 4,
                101, 101, 101, 1, 1, 1, 1, 3, 3, 3, 3, 102, 5, 5, 5, 5, 104};
        int resLongest = longestConsecutiveSeqLengthOptimal(arr2);
        System.out.println(resLongest); // Output: 5
    }

    /**
     * Performs linear search to find if a number exists in the array.
     *
     * @param arr the input array
     * @param num the number to find
     * @return true if num exists in arr, false otherwise
     *
     * ⏱ Time Complexity: O(n)
     */
    public static boolean linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Brute-force approach to find the longest consecutive sequence.
     * For every element, it tries to find the next consecutive numbers using linear search.
     *
     * @param arr the input array
     * @return the length of the longest consecutive sequence
     *
     * ⏱ Time Complexity: O(n^2)
     */
    public static int longestConsecutiveSeqLengthBrute(int[] arr) {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int count = 1;
            while (linearSearch(arr, tmp + 1)) {
                tmp += 1;
                count += 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    /**
     * Better approach using sorting.
     * After sorting, it traverses the array and counts consecutive increasing numbers,
     * skipping duplicates.
     *
     * @param arr the input array
     * @return the length of the longest consecutive sequence
     *
     * ⏱ Time Complexity: O(n log n) due to sorting
     */
    public static int longestConsecutiveSeqLengthBetter(int[] arr) {
        Arrays.sort(arr);
        int maxCount = 1;
        int count = 0;
        int longEle = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == longEle) {
                longEle = arr[i];
                count += 1;
            } else if (arr[i] != longEle) {
                count = 1;
                longEle = arr[i];
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    /**
     * Optimal approach using HashSet.
     * For each element, it checks if it is the start of a sequence
     * (i.e., num - 1 doesn't exist), and then counts the length of the sequence.
     *
     * @param arr the input array
     * @return the length of the longest consecutive sequence
     *
     * ⏱ Time Complexity: O(n)
     * ⏳ Space Complexity: O(n)
     */
    public static int longestConsecutiveSeqLengthOptimal(int[] arr) {
        if (arr.length == 0)
            return 0;

        int maxCount = 0;
        Set<Integer> set = new HashSet<>();

        // Add all elements to a set for O(1) lookups
        for (int value : arr) {
            set.add(value);
        }

        // Check for each number if it's the start of a sequence
        for (int num : set) {
            if (!set.contains(num - 1)) { // Start of a sequence
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
