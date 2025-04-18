package org.example.string;

/**
 * This program counts the number of overlapping occurrences of a specific pattern
 * in a given string.
 *
 * Example: In the string "aaaa", the pattern "aa" occurs 3 times:
 * at indices 0, 1, and 2.
 */
class Overlapping_pattern {
    public static void main(String[] args) {
        // The input string to search within
        String s = "aabyaarcaayredaaaa";

        // The pattern we want to count
        String pattern = "aa";

        // Variable to store the number of pattern occurrences
        int count = 0;

        /**
         * Traverse every index where a full-length pattern can fit,
         * including overlapping positions.
         */
        for (int i = 0; i <= s.length() - pattern.length(); i++) {
            // Check if the substring starting at index i matches the pattern
            if (s.substring(i, i + pattern.length()).equals(pattern)) {
                count++; // Increment the count
            }
        }

        // Output the total count of overlapping pattern matches
        System.out.println(count); // Output should be 4 for this case
    }
}
