package org.example.DSA;

public class LinearSearch {
    public static void main(String[] args) {
        int []nums={1,3,6,4,9,7,4};
        int target = 7;
        int result = linearSearch(nums,target);
        if(result!=-1)
            System.out.println("Element Found at index : "+result);
        else
            System.out.println("Element Not Found");
    }

    private static int linearSearch(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
        }
        return -1;
    }
}
