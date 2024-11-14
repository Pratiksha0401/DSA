package org.example.searching;

import java.util.Arrays;

//find floor of the number means ele <= k
public class FloorNumber {
    public static void main(String[] args) {
        int[] arr={-1,4,2,8,5,0};
        Arrays.sort(arr);
        int res = search(arr,0);
        System.out.println(res);
    }

    private static int search(int[] arr, int k) {
        int n=arr.length;
        int hi = n-1;
        int li = 0;
        int ans = Integer.MIN_VALUE;
        while(li<=hi){
            int mid = (hi+li)/2;
            if(arr[mid]==k){
                System.out.println("index : "+mid);
                return arr[mid];
            }else if (arr[mid]<k){
                ans = arr[mid];
                li = mid+1;
            }else {
                hi = mid -1;
            }
        }
        return ans;
    }
}
