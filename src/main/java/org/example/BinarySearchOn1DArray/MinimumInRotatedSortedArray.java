package org.example.BinarySearchOn1DArray;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        final int min = findMin(arr, arr.length);
        System.out.println(min);

        int[] nums = {1,2,3,4,5};
        final int minOptimal = findMinOptimal(nums, nums.length);
        System.out.println(minOptimal);
    }

    public static int findMin(int[] arr, int n ){
        int min = Integer.MAX_VALUE , low = 0, high = n-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(arr[low]<=arr[mid]){
                min = Math.min(min,arr[low]);
                low = mid+1;
            }else{
                mid = Math.min(min,arr[mid]);
                high = mid -1;
            }
        }
        return min;
    }

    public static int findMinOptimal(int[] arr, int n ){
        int min = Integer.MAX_VALUE , low = 0, high = n-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(arr[low]<=arr[high]){
                min = Math.min(min, arr[low]);
                break;
            }
            if(arr[low]<=arr[mid]){
                min = Math.min(min,arr[low]);
                low = mid+1;
            }else{
                mid = Math.min(min,arr[mid]);
                high = mid -1;
            }
        }
        return min;
    }
}
