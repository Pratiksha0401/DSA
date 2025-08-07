package org.example.array.hard;

import java.util.Arrays;

/**
 * This class demonstrates merging two sorted arrays into sorted order.
 *
 * <p>It includes two approaches:</p>
 * <ul>
 *   <li><b>Brute Force:</b> Uses extra space to merge the arrays.</li>
 *   <li><b>Optimal (No Extra Space):</b> Uses in-place logic with minimal swaps.</li>
 * </ul>
 *
 * <p>After merging, both arrays remain sorted and all elements are preserved.</p>
 */
public class MergeTwoSortedArraysWithoutExtraSpace {

    /**
     * Main method to test both brute force and optimal merge functions.
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
        System.out.println("The merged arrays using brute force are:");
        System.out.print("arr1[] = ");
        for (int k : arr1) {
            System.out.print(k + " ");
        }

        System.out.print("\narr2[] = ");
        for (int j : arr2) {
            System.out.print(j + " ");
        }
        System.out.println();

        int[] arr3 = {1, 4, 8, 10};
        int[] arr4 = {2, 3, 9};

        // Merging using optimal method
        mergeOptimal(arr3, arr4, arr3.length, arr4.length);

        // Display the merged result
        System.out.println("The merged arrays using optimal approach are:");
        System.out.print("arr3[] = ");
        for (int j : arr3) {
            System.out.print(j + " ");
        }

        System.out.print("\narr4[] = ");
        for (int j : arr4) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * Merges two sorted arrays using brute force method.
     *
     * <p><b>Steps:</b></p>
     * <ul>
     *     <li>Create a temporary array of size n + m.</li>
     *     <li>Use two pointers to merge the arrays.</li>
     *     <li>Copy the sorted results back into the original arrays.</li>
     * </ul>
     *
     * @param arr1 The first sorted array
     * @param arr2 The second sorted array
     * @param n    The number of valid elements in arr1
     * @param m    The number of elements in arr2
     *
     * <p><b>Time Complexity:</b> O(n + m)</p>
     * <p><b>Space Complexity:</b> O(n + m)</p>
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

    /**
     * Merges two sorted arrays in-place using an optimal approach without extra space.
     *
     * <p><b>Steps:</b></p>
     * <ul>
     *     <li>Start comparing the largest element in arr1 with the smallest in arr2.</li>
     *     <li>Swap if arr1's element is greater, then sort both arrays individually.</li>
     * </ul>
     *
     * @param arr1 The first sorted array
     * @param arr2 The second sorted array
     * @param n    The number of valid elements in arr1
     * @param m    The number of elements in arr2
     *
     * <p><b>Time Complexity:</b> O((n + m) * log(n + m)) due to sorting at the end</p>
     * <p><b>Space Complexity:</b> O(1) — no extra space used</p>
     */
    public static void mergeOptimal(int[] arr1, int[] arr2, int n, int m) {
        int left = n - 1, right = 0;

        // Swap elements if arr1[left] > arr2[right]
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int tmp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = tmp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort both arrays individually
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}