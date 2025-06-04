package org.example.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A class containing methods to remove duplicates from arrays.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 6, 8, 8, 7, 2, 9, 4, 5, 3, 7};
        System.out.println(removeDuplicates(arr));

        int[] arr1 = {2, 2, 4, 6, 8, 8, 7, 2, 9, 4, 5, 3, 7};
        System.out.println(removeDuplicatesWithoutSet(arr1));

        Arrays.sort(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    /**
     * Removes duplicates from an integer array using a HashSet.
     * The result is written back into the original array up to the returned length.
     *
     * @param arr the input array (can be unsorted)
     * @return the count of unique elements in the array
     *
     * Time Complexity: O(n), where n is the length of the array
     * Space Complexity: O(n), due to the use of a HashSet
     */
    public static int removeDuplicates(int[] arr) {
        Set<Integer> st = new HashSet<>();
        for (int j : arr) {
            st.add(j);
        }
        int index = 0;
        for (int n : st) {
            arr[index] = n;
            index++;
        }
        return index;
    }

    /**
     * Removes duplicates from a sorted array using the two-pointer technique.
     * The input array is sorted in-place before removing duplicates.
     *
     * @param arr the input array (can be unsorted initially)
     * @return the count of unique elements in the array
     *
     * Time Complexity: O(n log n) due to sorting + O(n) for scanning = O(n log n)
     * Space Complexity: O(1), in-place
     */
    public static int removeDuplicatesWithoutSet(int[] arr) {
        Arrays.sort(arr); // Required for two-pointer logic to work
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
