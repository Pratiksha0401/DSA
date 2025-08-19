package org.example.BinarySearchOn1DArray;

public class PeakElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        final int peakEle = peakEleBruteForce(arr, arr.length);
        System.out.println(arr[peakEle]);

        final int peakEleOp = peakEleOptimal(arr, arr.length);
        System.out.println(arr[peakEleOp]);
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


    public static int peakEleOptimal(int[] arr, int n){
        int index = -1;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>arr[mid+1] && arr[mid-1]<arr[mid]) return mid;

            if(arr[mid]<arr[mid+1] && arr[mid-1]<arr[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return index;
    }
}

