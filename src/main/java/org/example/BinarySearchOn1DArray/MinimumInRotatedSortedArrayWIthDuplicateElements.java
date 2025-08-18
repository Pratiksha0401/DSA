package org.example.BinarySearchOn1DArray;

public class MinimumInRotatedSortedArrayWIthDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 5, 0, 1, 0, 1, 2, 2};
        final int min = findMinWithDuplicateElements(arr, arr.length);
        System.out.println(min);
    }

    public static int findMinWithDuplicateElements(int[] arr , int n){
        int min = Integer.MAX_VALUE;
        int low =0, high = n-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
            if (arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            if(arr[low]<=arr[mid]){
                min = Math.min(min, arr[low]);
                low =  mid+1;
            }else{
                min = Math.min(min, arr[mid]);
                high =  mid -1;
            }
        }
        return min;
    }
}
