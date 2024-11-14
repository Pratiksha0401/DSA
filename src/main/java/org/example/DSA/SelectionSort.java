package org.example.DSA;

public class SelectionSort {
    public static void main(String[] args) {
        int []nums={3,1,3,6,4,9,7,4};
        System.out.println("Before Sort");
        for(int n : nums){
            System.out.print(n+" ");
        }
        int mid = -1;
        for(int i=0;i<nums.length-1;i++){
            mid=i;
            for (int j=i+1;j<nums.length;j++){
                if(nums[mid]>nums[j])
                    mid=j;
            }
            int tmp=nums[mid];
            nums[mid]=nums[i];
            nums[i]=tmp;
        }
        System.out.println();
        System.out.println("After Sort");
        for(int n : nums){
            System.out.print(n+" ");
        }
    }
}
