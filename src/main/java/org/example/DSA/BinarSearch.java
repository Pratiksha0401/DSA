package org.example.DSA;

public class BinarSearch {
    public static void main(String[] args) {
        int []nums={1,3,6,4,9,7,4};
        int target = 7;
        int result = binarySearchRecursion(nums,target,0,nums.length-1);
        if(result!=-1)
            System.out.println("Element Found at index : "+result);
        else
            System.out.println("Element Not Found");
    }

    private static int binarySearch(int[] nums, int target) {
        int sp = 0;
        int ep = nums.length-1;
        while (sp<=ep){
            int mid=sp+(ep-sp)/2;
            if(nums[mid]==target)
                return mid;
            else if(mid>target){
                ep=mid-1;
            }else {
                sp=mid+1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursion(int[] nums, int target, int sp, int ep) {
        if (sp<=ep){
            int mid=sp+(ep-sp)/2;
            if(nums[mid]==target)
                return mid;
            if(mid>target){
                return binarySearchRecursion(nums,target,sp,mid-1);
            }else {
                return binarySearchRecursion(nums,target,mid+1,ep);
            }

        }
        return -1;
    }
}
