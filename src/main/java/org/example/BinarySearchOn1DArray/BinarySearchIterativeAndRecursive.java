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
        int mid = low + (high-low)/2;
        for(int i=low;i< high;i++){
            if(arr[i]==target){
                index=i;
            }else if (target<mid){
                high=mid-1;
                mid= low + (high-low)/2;
            }else {
                low=mid+1;
                mid =low + (high-low)/2;
            }
        }
        return index;
    }
}
