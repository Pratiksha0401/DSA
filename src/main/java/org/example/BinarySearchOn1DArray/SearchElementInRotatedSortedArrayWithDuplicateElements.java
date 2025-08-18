package org.example.BinarySearchOn1DArray;

public class SearchElementInRotatedSortedArrayWithDuplicateElements {
    public static void main(String[] args) {
        int [] arr = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(searchWithDuplicates(arr, arr.length, target));

    }

    public static boolean searchWithDuplicates(int[] arr, int n , int target){
        int low=0,high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return true;
            if(arr[low] == arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }

            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(target<=arr[high] && arr[mid]<=target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}

