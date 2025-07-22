package org.example.array.easy;

public class LongestSubArraySumKPositive {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,4,2,1,1,2,1,3};
        int k = 7;
        int n = arr.length;
        int longestSubArrayLength = getLongestSubArrayLengthBruteForce(arr, k);
        System.out.println(longestSubArrayLength);



        int arr1[] = {1,2,3,1,4,2,1,1,2,1,3};
        int k1 = 7;
        int n1 = arr1.length;
        int longestSubArrayLength1 = getLongestSubArrayLengthBetter(arr1, k);
        System.out.println(longestSubArrayLength1);
    }

    public static int getLongestSubArrayLengthBruteForce(int [] arr,int k){
        int mLen = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum =0;
                for (int l = i; l < j; l++) {
                    sum +=arr[l];
                }
                if(sum==k){
                    mLen = Math.max(mLen,j-i);
                }
            }
        }
        return mLen;
    }

    public static int getLongestSubArrayLengthBetter(int [] arr,int k){
        int mLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum =0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==k){
                    mLen = Math.max(mLen,j-i+1);
                }
            }
        }
        return mLen;
    }
}