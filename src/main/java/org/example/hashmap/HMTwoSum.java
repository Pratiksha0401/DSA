package org.example.hashmap;

import java.util.HashMap;

public class HMTwoSum {
    public static void main(String[] args) {
        int [] arr={2,3,4,-5,2,3,4,5,2,-3,4,9};
        int k=-1;
        boolean isTwoSumExist = isTwoSumExist(arr,k);
        System.out.println(isTwoSumExist);
    }

    private static boolean isTwoSumExist(int[] arr, int k) {
        HashMap<Integer, Integer> hs =  new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(hs.containsKey(arr[i])){
                int temp = hs.get(arr[i]);
                hs.put(arr[i],temp+1);

            }else {
                hs.put(arr[i],1);
            }
        }

        for (int i=0;i<arr.length;i++){
            int a=arr[i];;
            int b= k-a;
            if(a!=b && hs.containsKey(b)){
                return true;
            }else if(a==b && hs.containsKey(b) && hs.get(b) >1){
                return true;
            }
        }
        return false;
    }
}
