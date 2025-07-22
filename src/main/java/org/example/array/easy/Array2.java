package org.example.array.easy;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        int arr[] = {-9,2,-1,3,3};
        int n =igg(arr);
        System.out.println(n);
    }

    public static int igg(int [] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int ans =0;
        int lesscount = 0;

        if(arr[0] == 0){
            ans++;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                lesscount = i;
            }

            if(arr[i] == lesscount){
                ans++;
            }
        }

        return ans;
    }
}

