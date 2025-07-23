package org.example.array.easy;

import java.util.HashMap;
import java.util.Map;

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
        int longestSubArrayLength1 = getLongestSubArrayLengthBetter(arr1, k1);
        System.out.println(longestSubArrayLength1);

        int arr2[] = {1,2,3,1,4,2,1,1,2,1,3};
        int k2 = 7;
        int n2 = arr2.length;
        int longestSubArrayLength2 = getLongestSubArrayLengthPrefixSum(arr2, k2);
        System.out.println(longestSubArrayLength2);


        int arr3[] = {1,2,3,1,4,2,1,1,2,1,3};
        int k3 = 7;
        int n3 = arr2.length;
        int longestSubArrayLength3 = getLongestSubArrayLengthTwoPointer(arr3, k3);
        System.out.println(longestSubArrayLength3);
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

    public static int getLongestSubArrayLengthPrefixSum(int [] arr,int k){
        int mLen = 0;
        int sum =0;
        Map<Integer, Integer> hm= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
            if(sum==k){
                mLen = Math.max(mLen,i+1);
            }
            int rem = sum -k;
            if(hm.containsKey(rem)){
                int len = i - hm.get(rem);
                mLen = Math.max(mLen,len);
            }

            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
        }
        return mLen;
    }


    public static int getLongestSubArrayLengthTwoPointer(int [] arr,int k){
        int mLen = 0;
        int sum =0;
        int left =0;
        int right = 0;
        int n = arr.length;
        while (right<n){
            if(left<=right && sum > k){
                sum -=arr[left];
                left++;
            }
            if(sum==k){
                mLen = Math.max(mLen, right-left+1);
            }
            right++;
            if(right<n){
                sum +=arr[right];
            }

        }
        return mLen;
    }
}