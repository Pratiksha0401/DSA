package org.example.slidingWindowAndTwoPointer;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String s = "abcdedabpiuyac";
        String result = longestUniqueSubstring(s);
        System.out.println("Longest substring: " + result);
        System.out.println("Length: " + result.length());
    }

    /**
     * Finds the longest substring without repeating characters.
     * <p>
     * This method uses a brute-force approach combined with a
     * frequency array to track visited characters.
     * </p>
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(256)
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
}