package org.example.BinarySearchOn1DArray;

public class LowerBound {

    public static void main(String[] args) {
        int [] arr={1,2,4,5,8,9,11,15,17,18};
        int target = 13;
        final int result = lowerBoundOptimal(arr, target);
        System.out.println(result);

        final int result1 = lowerBoundBruteForce(arr, target);
        System.out.println(result1);
    }

    public static int lowerBoundOptimal(int[] nums, int target) {
        int ans=nums.length;
        int low =0, high =nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int lowerBoundBruteForce(int[] nums, int target) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= target) {
                // lower bound found:
                return i;
            }
        }
        return n;
    }
}
