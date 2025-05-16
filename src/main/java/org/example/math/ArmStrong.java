package org.example.math;

public class ArmStrong {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(123));
    }

    /**
     * Checks if the given number n is an Armstrong number.
     * An Armstrong number is one that is equal to the sum of its own digits
     * each raised to the power of the number of digits.
     *
     * @param n the number to check
     * @return true if n is an Armstrong number, false otherwise
     *
     * Time Complexity: O(d), where d is the number of digits in n
     * Space Complexity: O(1)
     */
    public static boolean isArmstrong(int n) {
        int count = String.valueOf(n).length();
        int dup = n;
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += (int) Math.pow(lastDigit, count);
            n = n / 10;
        }
        return sum == dup;
    }
}
