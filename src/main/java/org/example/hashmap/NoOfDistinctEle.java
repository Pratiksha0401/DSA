package org.example.hashmap;

import java.util.HashSet;

public class NoOfDistinctEle {
    public static void main(String[] args) {
        int [] arr={2,3,4,5,2,3,6};
        int size = noOfDistinctEle(arr);
        System.out.println("No of n=distinct element = "+size);
    }

    private static int noOfDistinctEle(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        return hs.size();
    }
}
