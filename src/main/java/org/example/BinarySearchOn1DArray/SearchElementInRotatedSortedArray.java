package org.example.BinarySearchOn1DArray;

public class SearchElementInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {7,8,9,1,2,3,4,5,6};
        int target = 1;
        final int search = search(arr, arr.length, target);
        System.out.println(search);

    }

    public static int search(int[] arr, int n , int target){
        int low=0, high=n-1;
        while (low<=high){
            int mid = low+ (high-low)/2;
            if(arr[mid]==target) return mid;
            //left sorted array
            if(arr[low]<=arr[mid]){
                if(arr[low] <= target && target>=arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }else{
                if(arr[mid] <= target && target<=arr[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
