package org.example.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr1 = {25, 48, 75, 2, 48, 15, 6, 7, 39, 54};
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr.length; i++) {
            int j = i ;
            while(j>0 && arr[j-1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    j--;
            }

            System.out.println("runs");
        }

        for (int n : arr) {
            System.out.println(n);
        }
    }
}
