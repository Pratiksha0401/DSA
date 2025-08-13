package org.example.BinarySearchOn1DArray;

public class FloorAndCeil {

    public static void main(String[] args) {
        int [] arr={1,2,4,5,8,9,11,11,15,15,17,18};
        int target = 13;
        final int result = findFloor(arr, target);
        System.out.println(result);

        final int result1 = findCeil(arr, target);
        System.out.println(result1);
    }

    public static int findFloor(int[] nums, int target) {
        int ans=-1;
        int low =0, high =nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                ans=nums[mid];
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public static int findCeil(int[] nums, int target) {
        int ans=-1;
        int low =0, high =nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=target){
                ans=nums[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

}

