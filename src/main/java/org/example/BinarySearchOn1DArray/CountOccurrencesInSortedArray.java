package org.example.BinarySearchOn1DArray;

public class CountOccurrencesInSortedArray {

    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
        int ans = count(arr, n, x);
        System.out.println("The number of occurrences is: " + ans);
    }

    public static int count(int arr[], int n, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {

            // counting the occurrences:
            if (arr[i] == x) cnt++;
        }
        return cnt;
    }
}
