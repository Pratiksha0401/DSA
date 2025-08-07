package org.example.array.hard;

/**
 * This class demonstrates merging two sorted arrays into sorted order
 * without using library utilities.
 * <p>
 * It uses a brute force approach where a temporary array is created to
 * merge both arrays and the result is copied back into the original arrays.
 */
public class MergeTwoSortedArraysWithoutExtraSpace {

    /**
     * Main method to test the mergeBruteForce function.
     * It prints the merged contents of the input arrays.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = arr1.length, m = arr2.length;

        // Merging using brute force method
        mergeBruteForce(arr1, arr2, n, m);

        // Display the merged result
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    /**
     * Merges two sorted arrays using brute force method.
     * <p>
     * The method creates a temporary array to hold the merged result,
     * sorts them into the new array, and then splits the merged values
     * back into arr1 and arr2 in order.
     *
     * <p><b>Steps:</b></p>
     * <ul>
     *     <li>Create a temporary array of size n + m.</li>
     *     <li>Use two pointers (left for arr1 and right for arr2) to merge values.</li>
     *     <li>Copy remaining elements (if any) from arr1 or arr2.</li>
     *     <li>Copy the merged result back to arr1 and arr2 respectively.</li>
     * </ul>
     *
     * @param arr1 The first sorted array
     * @param arr2 The second sorted array
     * @param n    The size of the first array
     * @param m    The size of the second array
     *
     * <p><b>Time Complexity:</b> O(n + m) — for merging and copying values</p>
     * <p><b>Space Complexity:</b> O(n + m) — due to extra temporary array</p>
     */
    public static void mergeBruteForce(int[] arr1, int[] arr2, int n, int m) {
        int[] arr = new int[n + m];
        int left = 0, right = 0, index = 0;

        // Merge both arrays into temp array
        while (left < n && right < m) {
            if (arr1[left] < arr2[right]) {
                arr[index++] = arr1[left++];
            } else {
                arr[index++] = arr2[right++];
            }
        }

        // Copy remaining elements from arr1
        while (left < n) {
            arr[index++] = arr1[left++];
        }

        // Copy remaining elements from arr2
        while (right < m) {
            arr[index++] = arr2[right++];
        }

        // Put first n elements back to arr1 and the rest to arr2
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr[i];
            } else {
                arr2[i - n] = arr[i];
            }
        }
    }
}
