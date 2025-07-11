package org.example.DSA;

public class InsertionSort {
    public static void main(String [] args){
        int [] nums = {3,3,8,1,6,2,4};
        for(int i=1;i<nums.length;i++){
            int key = nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>key){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]= key;
        }
        for (int num: nums) {
            System.out.print(num+" ");
        }
    }
}
