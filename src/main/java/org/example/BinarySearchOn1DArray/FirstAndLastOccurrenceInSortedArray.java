package org.example.BinarySearchOn1DArray;

public class FirstAndLastOccurrenceInSortedArray {

    public static void main(String args[]) {
        int n = 7;
        int key = 13;
        int[] v = {3, 4, 13, 13, 13, 20, 40};

        // returning the first and last occurrence index if the element is present otherwise -1
        System.out.println("First occurrence of " + key + " = " + first(n, key, v));
        System.out.println("Last occurrence of " + key + " = " + last(n, key, v));

        final int solve = lastOptimal(n, key, v);
        System.out.println("Last occurrence (optimal) of " + key + " = " + solve);

        final int i = firstOptimal(n, key, v);
        System.out.println("First occurrence (optimal) of " + key + " = " + i);
    }

    /**
     * Finds the first occurrence index of the given key in the array.
     *
     * @param n   the size of the array
     * @param key the target element to search
     * @param v   the input array
     * @return index of the first occurrence of key, or -1 if not found
     *
     * Time Complexity: O(n)
     *   - In the worst case, the loop scans the whole array once.
     * Space Complexity: O(1)
     *   - Only a constant amount of extra space is used.
     */
    public static int first(int n, int key, int[] v) {
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (v[i] == key) {
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * Finds the last occurrence index of the given key in the array.
     *
     * @param n   the size of the array
     * @param key the target element to search
     * @param v   the input array
     * @return index of the last occurrence of key, or -1 if not found
     *
     * Time Complexity: O(n)
     *   - In the worst case, the loop scans the whole array once.
     * Space Complexity: O(1)
     *   - Only a constant amount of extra space is used.
     */
    public static int last(int n, int key, int[] v) {
        int res = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (v[i] == key) {
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * Finds the last occurrence index of the given key in a sorted array using binary search.
     *
     * @param n   the size of the array
     * @param key the target element to search
     * @param v   the sorted input array
     * @return index of the last occurrence of key, or -1 if not found
     *
     * Time Complexity: O(log n)
     *   - Each iteration halves the search space.
     * Space Complexity: O(1)
     *   - Only a constant amount of extra space is used.
     */
    public static int lastOptimal(int n, int key, int[] v) {
        int start = 0;
        int end = n - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                start = mid + 1;  // move right to find later occurrence
            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    /**
     * Finds the first occurrence index of the given key in a sorted array using binary search.
     *
     * @param n   the size of the array
     * @param key the target element to search
     * @param v   the sorted input array
     * @return index of the first occurrence of key, or -1 if not found
     *
     * Time Complexity: O(log n)
     *   - Each iteration halves the search space.
     * Space Complexity: O(1)
     *   - Only a constant amount of extra space is used.
     */
    public static int firstOptimal(int n, int key, int[] v) {
        int start = 0;
        int end = n - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                end = mid - 1;  // move left to find earlier occurrence
            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
