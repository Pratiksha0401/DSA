package org.example.BinarySearchOn1DArray;

public class CountOccurrencesInSortedArray {

    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
        int ans = count1(arr, n, x);
        System.out.println("The number of occurrences is: " + ans);

        int ans1 = count(arr, n, x);
        System.out.println("The number of occurrences is: " + ans1);
    }

    /**
     * Counts the number of occurrences of x in the array using linear scan.
     *
     * @param arr the input array
     * @param n   the size of the array
     * @param x   the element to count
     * @return the number of times x appears in arr
     *
     * Time Complexity: O(n)
     *   - Scans the entire array once in the worst case.
     * Space Complexity: O(1)
     *   - Uses only a counter variable.
     */
    public static int count1(int arr[], int n, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // counting the occurrences
            if (arr[i] == x) cnt++;
        }
        return cnt;
    }

    /**
     * Finds the first occurrence index of k in a sorted array using binary search.
     *
     * @param arr the sorted array
     * @param n   the size of the array
     * @param k   the target element
     * @return index of the first occurrence of k, or -1 if not found
     *
     * Time Complexity: O(log n)
     *   - Binary search reduces the search space by half each iteration.
     * Space Complexity: O(1)
     *   - No extra space used except variables.
     */
    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1; // continue searching on the left
            } else if (arr[mid] < k) {
                low = mid + 1; // search right side
            } else {
                high = mid - 1; // search left side
            }
        }
        return first;
    }

    /**
     * Finds the last occurrence index of k in a sorted array using binary search.
     *
     * @param arr the sorted array
     * @param n   the size of the array
     * @param k   the target element
     * @return index of the last occurrence of k, or -1 if not found
     *
     * Time Complexity: O(log n)
     *   - Binary search reduces the search space by half each iteration.
     * Space Complexity: O(1)
     *   - No extra space used except variables.
     */
    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1; // continue searching on the right
            } else if (arr[mid] < k) {
                low = mid + 1; // search right side
            } else {
                high = mid - 1; // search left side
            }
        }
        return last;
    }

    /**
     * Finds both the first and last occurrence of k in a sorted array.
     *
     * @param arr the sorted array
     * @param n   the size of the array
     * @param k   the target element
     * @return an array containing [firstIndex, lastIndex], or [-1, -1] if not found
     *
     * Time Complexity: O(log n)
     *   - Two binary searches are performed (for first and last).
     * Space Complexity: O(1)
     *   - Only uses a fixed-size array for result.
     */
    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = lastOccurrence(arr, n, k);
        return new int[] {first, last};
    }


    /**
     * Counts the total occurrences of x in a sorted array using binary search.
     *
     * @param arr the sorted array
     * @param n   the size of the array
     * @param x   the target element
     * @return number of occurrences of x in the array
     *
     * Time Complexity: O(log n)
     *   - Uses firstAndLastPosition, which itself runs two binary searches.
     * Space Complexity: O(1)
     *   - Only uses a fixed amount of extra space.
     */
    public static int count(int arr[], int n, int x) {
        int[] ans = firstAndLastPosition(arr, n, x);
        if (ans[0] == -1)
            return 0;
        return (ans[1] - ans[0] + 1);
    }

}
