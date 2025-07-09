package org.example.array.medium;

public class KadanesAlgorithmMaximumSubarraySuminanArray {

    public static void main(String[] args) {
        int[] arr =  {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Ma subarray sum :"+maxSubArrayOptimal(arr));

    }
    //brute force
    public static int maxSubArrayBruteForce(int[] nums) {
        int sum = nums[0];
        int ma = nums[0];
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for(int j=0;j< nums.length;j++){
                for(int k=i;k<j;k++){


                }
            }
        }
        return ma;
    }
    //optimal
    public static int maxSubArrayOptimal(int[] nums) {
        int sum = nums[0];
        int ma = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ma = Math.max(ma, sum);
        }
        return ma;
    }
}
