package org.example.BinarySearchOn1DArray;

public class BinarySearchIterativeAndRecursive {
    public static void main(String[] args) {
        // Array must be sorted
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        int resultIndex = iterativeApproach(arr, target);
        System.out.println(resultIndex);
    }

    public static int iterativeApproach(int[] arr, int target){
        int index=-1;
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                index=mid;
                break;
            }else if (target<arr[mid]){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return index;
    }
}
