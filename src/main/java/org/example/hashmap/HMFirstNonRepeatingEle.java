package org.example.hashmap;

import java.util.HashMap;

public class HMFirstNonRepeatingEle {
    public static void main(String[] args) {
        int arr[] = {2,4,6,9,2,3,4,3,4};
        printfrquency(arr);

    }

    private static void printfrquency(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int temp=hm.get(arr[i]);
                hm.put(arr[i],temp+1);
            }else {
                hm.put(arr[i],1);
            }
        }

        for (int i=0;i<arr.length;i++){
            if(hm.get(arr[i])==1){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
