package org.example.BinarySearchAnswers;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArraysOfDifferentSizes {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays (Brute Force) is: " + medianBruteForce(a, b));
        System.out.println("The median of two sorted arrays (Better) is: " + medianBetter(a, b));
        System.out.println("The median of two sorted arrays (Optimal) is: " + medianOptimal(a, b));
    }

    /**
     * Brute Force Approach:
     * 1. Merge both sorted arrays into one.
     * 2. Find the median from the merged array.
     *
     * Time Complexity: O(n1 + n2) → merging requires traversing both arrays fully.
     * Space Complexity: O(n1 + n2) → extra space used for merged list.
     *
     * @param a First sorted array
     * @param b Second sorted array
     * @return Median of the two arrays
     */
    public static double medianBruteForce(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        List<Integer> arr3 = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) arr3.add(a[i++]);
            else arr3.add(b[j++]);
        }

        while (i < n1) arr3.add(a[i++]);
        while (j < n2) arr3.add(b[j++]);

        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) arr3.get(n / 2);
        }
        return ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
    }

    /**
     * Better Approach:
     * 1. Use the merge process but stop once we reach the median position.
     * 2. Track only the necessary elements instead of storing all.
     *
     * Time Complexity: O(n1 + n2) in the worst case (when median is at the end).
     * Space Complexity: O(1) → no extra array, only variables used.
     *
     * @param a First sorted array
     * @param b Second sorted array
     * @return Median of the two arrays
     */
    public static double medianBetter(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        int n = n1 + n2;
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            int val;
            if (a[i] < b[j]) val = a[i++];
            else val = b[j++];

            if (cnt == ind1) ind1el = val;
            if (cnt == ind2) ind2el = val;
            cnt++;
        }

        while (i < n1) {
            int val = a[i++];
            if (cnt == ind1) ind1el = val;
            if (cnt == ind2) ind2el = val;
            cnt++;
        }

        while (j < n2) {
            int val = b[j++];
            if (cnt == ind1) ind1el = val;
            if (cnt == ind2) ind2el = val;
            cnt++;
        }

        if (n % 2 == 1) return (double) ind2el;
        return (double) (ind1el + ind2el) / 2.0;
    }

    /**
     * Optimal Approach (Binary Search Partition Method):
     * 1. Always binary search on the smaller array to partition both arrays.
     * 2. Divide both arrays into left and right halves such that:
     *    - Left half contains the first half of the elements.
     *    - Right half contains the second half of the elements.
     * 3. Use partitioning logic to balance left and right.
     *
     * Time Complexity: O(log(min(n1, n2))) → binary search on the smaller array.
     * Space Complexity: O(1) → constant space.
     *
     * @param a First sorted array
     * @param b Second sorted array
     * @return Median of the two arrays
     */
    public static double medianOptimal(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        if (n1 > n2) return medianOptimal(b, a); // always binary search on smaller array

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; // dummy statement (should not reach here)
    }
}
