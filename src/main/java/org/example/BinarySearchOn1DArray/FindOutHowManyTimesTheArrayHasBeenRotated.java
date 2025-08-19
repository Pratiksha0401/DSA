package org.example.BinarySearchOn1DArray;

public class FindOutHowManyTimesTheArrayHasBeenRotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        final int rotations = findRotations(arr, arr.length);
        System.out.println(rotations);

        int[] arr1 = {1,2,3,4,5};
        final int rotations1 = findRotations(arr1, arr1.length);
        System.out.println(rotations1);

        int[] arr2 = {1,1,1,1,1};
        final int rotations2 = findRotations(arr2, arr2.length);
        System.out.println(rotations2);
    }

    public static int findRotations(int[] arr, int n){
        int index = -1, min=Integer.MAX_VALUE, low =0 , high = n-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(arr[low]<=arr[high]){
                if(arr[low]<min){
                    index = low;
                    min = arr[low];
                }
                break;
            }

            if(arr[low]<=arr[mid]){
                if(arr[low]<arr[mid]){
                    min = arr[low];
                    index = low;
                }
                low = mid+1;
            }else {
                if(arr[mid]<min){
                    min = arr[low];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
