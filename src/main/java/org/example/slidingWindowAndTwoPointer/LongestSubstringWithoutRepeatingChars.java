package org.example.slidingWindowAndTwoPointer;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String s = "abcdedabpiuyac";

        String result = longestUniqueSubstring(s);
        System.out.println("Longest substring (Brute Force): " + result);
        System.out.println("Length: " + result.length());

        String result1 = longestUniqueSubstringOptimal(s);
        System.out.println("Longest substring (Optimal): " + result1);
        System.out.println("Length: " + result1.length());
    }

    /**
     * Finds the longest substring without repeating characters using
     * a brute-force approach.
     *
     * <p>
     * For each starting index, this method checks subsequent characters
     * until a duplicate is found, using a frequency array to track
     * visited characters.
     * </p>
     *
     * <p>
     * This approach is simple but inefficient for large strings.
     * </p>
     *
     * <b>Time Complexity:</b> O(n²) <br>
     * <b>Space Complexity:</b> O(256)
     *
     * @param s the input string
     * @return the longest substring without repeating characters
     */
    public static String longestUniqueSubstring(String s) {

        int n = s.length();
        int maxLen = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];

            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) {
                    break;
                }

                hash[s.charAt(j)] = 1;

                int len = j - i + 1;
                if (len > maxLen) {
                    maxLen = len;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    /**
     * Finds the longest substring without repeating characters using
     * the sliding window (two-pointer) technique.
     *
     * <p>
     * This method maintains a window defined by two pointers (left and right).
     * A hash array stores the last seen index of each character.
     * When a duplicate character is encountered, the left pointer
     * is moved to one position after the last occurrence of that character.
     * </p>
     *
     * <p>
     * This ensures the window always contains unique characters.
     * </p>
     *
     * <b>Time Complexity:</b> O(n) <br>
     * <b>Space Complexity:</b> O(256)
     *
     * @param s the input string
     * @return the longest substring without repeating characters
     */
    public static String longestUniqueSubstringOptimal(String s) {

        int maxLen = 0;
        int startIndex = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int n = s.length();
        int l = 0;

        for (int r = 0; r < n; r++) {

            if (hash[s.charAt(r)] >= l) {
                l = hash[s.charAt(r)] + 1;
            }

            int len = r - l + 1;

            if (len > maxLen) {
                maxLen = len;
                startIndex = l;
            }

            hash[s.charAt(r)] = r;
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}
