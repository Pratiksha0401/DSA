package org.example.BinarySearchOn1DArray;

public class FirstAndLastOccurrenceInSortedArray {

    public static void main(String args[]) {
        int n = 7;
        int key = 13;
        int[] v = {3, 4, 13, 13, 13, 20, 40};

        final int[] ints = firstAndLastOccurrence(v, v.length, 13);
        for (int s : ints){
            System.out.print(s + ",");
        }
        System.out.println();
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
     * Time Complexity: O(n) - In the worst case, the loop scans the whole array once.
     * Space Complexity: O(1) - Only a constant amount of extra space is used.
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
     * Time Complexity: O(n) - In the worst case, the loop scans the whole array once.
     * Space Complexity: O(1) - Only a constant amount of extra space is used.
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
     * Time Complexity: O(log n) - Each iteration halves the search space.
     * Space Complexity: O(1) - Only a constant amount of extra space is used.
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
     * Time Complexity: O(log n) - Each iteration halves the search space.
     * Space Complexity: O(1) - Only a constant amount of extra space is used.
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

    /**
     * Returns the lower bound (first index where value >= target) in a sorted array.
     *
     * @param arr    the sorted input array
     * @param n      the size of the array
     * @param target the target element
     * @return index of the first element >= target, or -1 if not found
     *
     * Time Complexity: O(log n) - Standard binary search logic.
     * Space Complexity: O(1).
     */
    public static int lowerBound(int[] arr, int n , int target){
        int ans = -1;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Returns the upper bound (first index where value > target) in a sorted array.
     *
     * @param arr    the sorted input array
     * @param n      the size of the array
     * @param target the target element
     * @return index of the first element > target, or -1 if not found
     *
     * Time Complexity: O(log n) - Standard binary search logic.
     * Space Complexity: O(1).
     */
    public static int upperBound(int[] arr, int n , int target){
        int ans = -1;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                ans=mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Finds the first and last occurrence of the target in a sorted array.
     *
     * @param arr    the sorted input array
     * @param n      the size of the array
     * @param target the target element
     * @return array of two integers [firstIndex, lastIndex], or [-1, -1] if not found
     *
     * Time Complexity: O(log n) - Uses binary search for both lower and upper bounds.
     * Space Complexity: O(1).
     */
    public static int[] firstAndLastOccurrence(int[] arr, int n , int target){
        int lb = lowerBound(arr, n, target);
        if(lb == -1 || lb==n || arr[lb]!=target) return new int[]{-1, -1};
        return new int[]{lb, upperBound(arr, n, target) - 1};
    }
}
