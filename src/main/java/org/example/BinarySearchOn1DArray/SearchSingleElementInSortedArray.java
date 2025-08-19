package org.example.BinarySearchOn1DArray;

/**
 * This class provides methods to find the single non-duplicate element
 * in a sorted array where every other element appears exactly twice.
 * <p>
 * Example:
 * arr = {1, 1, 2, 2, 3, 3, 4, 5, 5}
 * Output = 4
 * </p>
 */
public class SearchSingleElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        final int singleElement = findSingleElementBruteForce(arr, arr.length);
        System.out.println("Single element in arr = " + singleElement);

        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        final int singleElement2 = findSingleElementBruteForce(arr2, arr2.length);
        System.out.println("Single element in arr2 = " + singleElement2);

        int[] arr3 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        final int singleElement3 = findSingleElementBruteForce(arr3, arr3.length);
        System.out.println("Single element in arr3 = " + singleElement3);

        int[] arr4 = {2, 3, 3, 4, 4, 5, 5, 6, 6};
        final int singleElement4 = findSingleElementBruteForce(arr4, arr4.length);
        System.out.println("Single element in arr4 = " + singleElement4);
    }

    /**
     * Finds the single non-duplicate element in a sorted array where
     * every other element appears exactly twice.
     *
     * @param arr Sorted integer array
     * @param n   Length of the array
     * @return The single element if found, otherwise -1
     *
     * Time Complexity: O(n) - we scan the array once
     * Space Complexity: O(1) - no extra space used
     */
    public static int findSingleElementBruteForce(int[] arr, int n) {
        int ele = -1;
        for (int i = 0; i < n; i++) {
            if (n == 1) return arr[0];
            if (i == 0 && arr[i] != arr[i + 1]) return arr[0]; // First element unique
            else if (i == n - 1 && arr[i] != arr[i - 1]) return arr[n - 1]; // Last element unique
            else {
                if (i > 0 && i < n - 1 && arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
                    return arr[i]; // Middle element unique
                }
            }
        }
        return ele; // If no single element found
    }
}
