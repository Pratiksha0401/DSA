package org.example.DSA;

public class BubbleSort {
    public static void main(String[] args) {
        int []nums={3,1,3,6,4,9,7,4};
        System.out.println("Before Sort");
        for(int n : nums){
            System.out.print(n+" ");
        }
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        System.out.println();
        System.out.println("After Sort");
        for(int n : nums){
            System.out.print(n+" ");
        }
    }
}
