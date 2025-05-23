package org.example.recurssion;

/**
 * A class to check if a given string is a palindrome using recursion.
 */
public class StringPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // Clean the string: remove non-alphanumeric characters and convert to lowercase
        // The ^ inside the brackets [] means "not these"
        // Since a space is not a letter (A-Z or a-z) and not a digit (0-9),
        // it is included in the characters that match this pattern. As a result, all spaces will be removed.
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(cleaned);
        System.out.println("Is palindrome: " + palindrome(0, cleaned));
    }

    /**
     * Recursively checks if the given string is a palindrome.
     *
     * @param i Current index from the start.
     * @param s The cleaned string to check.
     * @return true if the string is a palindrome, false otherwise.
     *
     * Time Complexity: O(n)
     * - Each character is compared once up to n/2 times.
     *
     * Space Complexity: O(n)
     * - Recursive calls go up to depth n/2.
     */
    public static boolean palindrome(int i, String s) {
        if (i >= s.length() / 2) {
            return true; // base case: fully checked
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
        return palindrome(i + 1, s);
    }
}
