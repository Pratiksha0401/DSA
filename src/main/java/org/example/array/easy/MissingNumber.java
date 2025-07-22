package org.example.array.easy;

/**
 * This class provides different methods to find the missing number
 * from an array containing numbers from 1 to N with exactly one missing.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7};
        int N = 7;
        int n = missingNumberBruteForce2(arr, N);
        System.out.println("Missing Number : " + n);
    }

    /**
     * Brute force method using nested loops.
     * For each number from 1 to N, it checks if it exists in the array.
     *
     * @param arr input array of size N-1
     * @param n the expected number of elements (including the missing one)
     * @return the missing number
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int missingNumberBruteForce1(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Brute force method using hashing (frequency array).
     * Uses an extra array to count frequencies and identify the missing one.
     *
     * @param arr input array of size N-1
     * @param n the expected number of elements (including the missing one)
     * @return the missing number
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int missingNumberBruteForce2(int[] arr, int n) {
        int hash[] = new int[n + 1]; // index 1 to n
        // storing the frequencies:
        for (int i = 0; i < n - 1; i++)
            hash[arr[i]]++;

        // checking the frequencies for numbers 1 to N:
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Optimal method using sum formula: sum of 1 to N - sum of array elements.
     *
     * @param arr input array of size N-1
     * @param n the expected number of elements (including the missing one)
     * @return the missing number
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int missingNumberOptimal1(int[] arr, int n) {
        int sum1 = 0;
        for (int i = 0; i < n - 1; i++) {
            sum1 += arr[i];
        }
        int sum2 = n * (n + 1) / 2;
        return sum2 - sum1;
    }

    /**
     * Optimal method using XOR approach:
     * XOR of 1 to N XOR XOR of array elements will give the missing number.
     *
     * @param arr input array of size N-1
     * @param n the expected number of elements (including the missing one)
     * @return the missing number
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int missingNumberOptimal2(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ n;
        return (xor1 ^ xor2);
    }
}
