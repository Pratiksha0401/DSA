package org.example.recurssion;

/**
 * A class that demonstrates reversing an array using recursion
 * with two different recursive strategies.
 */
public class RotateArray {

    /**
     * The main method demonstrates two different recursive reverse implementations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotate(0, arr.length - 1, arr);
        System.out.println("Reversed array using rotate():");
        for (int j : arr) {
            System.out.println(j);
        }

        int[] arr1 = {1, 2, 3, 4, 5};
        rotate1(0, arr1.length, arr1);
        System.out.println("Reversed array using rotate1():");
        for (int j : arr1) {
            System.out.println(j);
        }
    }

    /**
     * Recursively reverses the array by swapping elements from the start and end indices.
     *
     * @param sp  Start pointer.
     * @param ep  End pointer.
     * @param arr The array to be reversed.
     *
     * Time Complexity: O(n)
     * - Each recursive call processes one pair of elements.
     *
     * Space Complexity: O(n)
     * - Recursive stack space grows with each call until the midpoint.
     */
    public static void rotate(int sp, int ep, int[] arr) {
        if (sp >= ep) {
            return;
        }
        swap(sp, ep, arr);
        rotate(sp + 1, ep - 1, arr);
    }

    /**
     * Another recursive approach to reversing the array using a different boundary strategy.
     *
     * @param i   Current index from the start.
     * @param n   Total length of the array.
     * @param arr The array to be reversed.
     *
     * Time Complexity: O(n)
     * - One recursive call for each element until the midpoint.
     *
     * Space Complexity: O(n)
     * - Stack space used for each call until halfway through the array.
     */
    public static void rotate1(int i, int n, int[] arr) {
        if (i >= n / 2) {
            return;
        }
        swap(i, n - i - 1, arr);
        rotate1(i + 1, n, arr);
    }

    /**
     * Swaps two elements in the array.
     *
     * @param sp  Start pointer index.
     * @param ep  End pointer index.
     * @param arr The array.
     */
    public static void swap(int sp, int ep, int[] arr) {
        int tmp = arr[sp];
        arr[sp] = arr[ep];
        arr[ep] = tmp;
    }
}
