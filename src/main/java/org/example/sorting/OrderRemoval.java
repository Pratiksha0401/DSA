package org.example.sorting;

import java.util.Arrays;

public class OrderRemoval {
    public static void main(String[] args) {
        int arr[]={4,6,2,7};
        int ans = order(arr);
        System.out.println(" === "+ans);
    }

    private static int order(int arr[]) {
        Arrays.sort(arr);
        int ans=0;
        for (int i = 0;i< arr.length;i++){
            int temp=arr[i] * (arr.length-i);
            ans += temp;
        }
        return ans;
    }
}
