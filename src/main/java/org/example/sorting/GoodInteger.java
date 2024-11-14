package org.example.sorting;

import java.util.Arrays;

public class GoodInteger {
    public static void main(String[] args) {
        int arr[]={0,-4,-2,3,3,5,5};
        int ans = goodInteger(arr);
        System.out.println(" === "+ans);
    }

    private static int goodInteger(int[] arr) {
        int count =0;
        int lessCount=0;
        Arrays.sort(arr);
        if(arr[0]==0){
            count++;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                lessCount=i;
            }
            if(arr[i]==lessCount){
                count++;
            }
        }
        return count;
    }


    private static int goodIntegerDistinct(int[] arr) {
        int count =0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i){
                count++;
            }
        }
        return count;
    }
}
