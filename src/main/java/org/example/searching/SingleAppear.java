package org.example.searching;

import java.util.Arrays;

//all twice only 1 single element
public class SingleAppear {
    public static void main(String[] args) {
                    int[] arr={1,1,2,2,5,5,1,1,2,2};
        int res = search(arr,5);
        System.out.println(res);
        String s;
        System.out.println();
    }

    private static int search(int[] arr, int k) {
        int n=arr.length;

        if(arr[0]!=arr[1]){
            return arr[0];
        }
        if(arr[n-1]!=arr[n-2]){
            return arr[n-1];
        }
        int hi = n-3;
        int li = 2;
        while(li<=hi){
            int mid = (hi+li)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]==arr[mid-1]){
                mid--;
            }
            if (mid%2==0){
                li = mid+2;
            }else if(mid%2==1) {
                hi = mid-1;
            }
        }
        return -1;
    }
}
