package org.example.searching;

import java.util.Arrays;

public class BinarySearchSorted {
    public static void main(String[] args) {
        int[] arr={-1,4,2,8,5,0};
        Arrays.sort(arr);
        boolean res = search(arr,5);
        System.out.println(res);
    }

    private static boolean search(int[] arr, int k) {
        int n=arr.length;
        int hi = n-1;
        int li = 0;
        while(li<=hi){
            int mid = (hi+li)/2;
            if(arr[mid]==k){
                System.out.println("index : "+mid);
                return true;
            }else if (arr[mid]<k){
                li = mid+1;
            }else {
                hi = mid -1;
            }
        }
        return false;
    }
}
