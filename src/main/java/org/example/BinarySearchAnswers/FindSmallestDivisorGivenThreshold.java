package org.example.BinarySearchAnswers;

/**
 * Problem:
 * Given an array arr[] and an integer limit,
 * find the smallest divisor such that the sum of (ceil(arr[i] / divisor)) for all i <= limit.
 *
 * Example:
 * arr = [1,2,3,4,5], limit = 8 → Output: 3
 *
 * Approaches:
 * 1. Brute Force → Try every divisor from 1 to max(arr).
 * 2. Optimal → Use Binary Search on the divisor range [1, max(arr)].
 */
public class FindSmallestDivisorGivenThreshold {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;

        int ans = smallestDivisorBruteForce(arr, limit);
        System.out.println("Brute Force → The minimum divisor is: " + ans);

        int res = smallestDivisorOptimal(arr, limit);
        System.out.println("Optimal (Binary Search) → The minimum divisor is: " + res);
    }

    /**
     * Brute Force approach:
     * Try every divisor d in [1, max(arr)], compute the sum of ceil(arr[i] / d).
     * Return the first divisor that satisfies sum <= limit.
     *
     * @param arr input array
     * @param limit threshold value
     * @return smallest divisor or -1 if not possible
     *
     * Time Complexity: O(max(arr) * n)
     * - For each divisor up to max(arr), we scan the array.
     * Space Complexity: O(1)
     */
    public static int smallestDivisorBruteForce(int[] arr, int limit) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        for (int d = 1; d <= maxi; d++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) arr[i] / (double) d);
            }
            if (sum <= limit) return d;
        }
        return -1;
    }

    /**
     * Helper function: compute sum of ceil(arr[i] / div).
     *
     * @param arr input array
     * @param div divisor
     * @return summation value
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumByD(int[] arr, int div) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }

    /**
     * Optimal Binary Search approach:
     * Search for the smallest divisor in range [1, max(arr)].
     * If sumByD(mid) <= limit, search left (high = mid-1).
     * Else search right (low = mid+1).
     *
     * @param arr input array
     * @param limit threshold value
     * @return smallest divisor or -1 if not possible
     *
     * Time Complexity: O(n * log(max(arr)))
     * - Binary search runs log(max(arr)) times.
     * - Each step calls sumByD (O(n)).
     * Space Complexity: O(1)
     */
    public static int smallestDivisorOptimal(int[] arr, int limit) {
        int n = arr.length;
        if (n > limit) return -1;

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1; // try smaller divisor
            } else {
                low = mid + 1; // need larger divisor
            }
        }
        return low;
    }
}
