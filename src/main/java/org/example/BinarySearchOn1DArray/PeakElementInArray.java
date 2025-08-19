package org.example.BinarySearchOn1DArray;

public class PeakElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        final int peakEle = peakEleBruteForce(arr, arr.length);
        System.out.println(arr[peakEle]);
    }

    public static int peakEleBruteForce(int[] arr, int n){
        int index = -1;
        for (int i = 0; i < n; i++) {
            if((i==0 || arr[i-1]<arr[i]) && (i==n-1 || arr[i]>arr[i+1])){
                index = i;
            }
        }
        return index;
    }
}
