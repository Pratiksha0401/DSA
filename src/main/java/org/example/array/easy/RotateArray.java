package org.example.array.easy;

/**
 * This class provides methods to rotate an array to the left by 'k' positions.
 * The optimal rotation uses the reversal algorithm for in-place rotation.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 24;

        // Calculate effective rotations in case k > arr.length
        int d = k % arr.length;

        // Rotate using the reversal algorithm
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);

        // Output rotated array
        for (int n : arr) {
            System.out.print(n + ",");
        }

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 24;

        // Calculate effective rotations in case k > arr.length
        int d1 = k1 % arr1.length;
        rotateArray(arr1,d1);
        // Output rotated array
        System.out.println();
        for (int n : arr) {
            System.out.print(n + ",");
        }

    }

    /**
     * Reverses a subarray of integers in place from index sp to ep.
     *
     * Time Complexity: O(n), where n = ep - sp + 1
     * Space Complexity: O(1), in-place
     *
     * @param arr The input array
     * @param sp  Start position (inclusive)
     * @param ep  End position (inclusive)
     */
    public static void reverseArray(int[] arr, int sp, int ep) {
        while (sp <= ep) {
            int tmp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = tmp;
            sp++;
            ep--;
        }
    }

    /**
     * Demonstrates an alternate (incomplete) method using extra space for left rotation.
     * To complete it, you would shift the remaining elements and copy the temp array to the end.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(d)
     *
     * @param arr The input array
     * @param d   Number of positions to rotate left
     */
    public static void rotateArray(int[] arr, int d) {
        int[] tmp = new int[d];
        for (int i = 0; i < d; i++) {
            tmp[i] = arr[i];
        }

         //This method is incomplete. Here is how you'd finish it:
         for (int i = d; i < arr.length; i++) {
             arr[i - d] = arr[i];
         }
         for (int i = 0; i < d; i++) {
             arr[arr.length - d + i] = tmp[i];
         }
    }
}
