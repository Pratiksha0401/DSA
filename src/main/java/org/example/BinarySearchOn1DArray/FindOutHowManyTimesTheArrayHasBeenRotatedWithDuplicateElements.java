package org.example.BinarySearchOn1DArray;

public class FindOutHowManyTimesTheArrayHasBeenRotatedWithDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {4,5,5,1,1,2,3,3};
        final int rotationsWithDuplicateElements = findRotationsWithDuplicateElements(arr, arr.length);
        System.out.println(rotationsWithDuplicateElements);

        int[] arr1 = {2,2,2,0,1,2};
        System.out.println(findRotationsWithDuplicateElements(arr1, arr1.length));

        int[] arr2 = {5,6,7,8,0,0,1,2};
        System.out.println(findRotationsWithDuplicateElements(arr2, arr2.length));
    }

    public static int findRotationsWithDuplicateElements(int[] arr, int n){
        int index = -1, low = 0, high = n-1, min = Integer.MAX_VALUE;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(arr[low] < arr[high]){
                if(arr[low]< min){
                    min = arr[low];
                    index = low;
                }
                break;
            }

            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                if(arr[low]<min){
                    min = arr[low];
                    index = low;
                }
                low++;
                high--;
                continue;
            }

            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min = arr[low];
                    index = low;
                }
                low = mid+1;
            }else{
                if(arr[mid]<min){
                    min = arr[mid];
                    index = mid;
                }
                high = mid -1;
            }
        }
        return index;
    }
}
