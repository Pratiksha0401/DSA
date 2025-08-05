package org.example.array.hard;

import java.util.HashMap;

public class CountNumberOfSubarraysWithxorK {
    public static void main(String[] args) {
        int[] arr={4,2,2,6,4};
        int target =6;

        int resultCnt1 = bruteForce(arr, target);
        System.out.println(resultCnt1);

        int resultCnt3 = xorOptimal(arr, target);
        System.out.println(resultCnt3);

    }


    //bruteForce
    public static int bruteForce(int[] nums, int k){
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int xor =0;
                for (int l = i; l <= j; l++) {
                    xor = xor ^ nums[l];
                }
                if(xor==k){
                    count++;
                }
            }
        }
        return count;
    }

    //optimal with xor
    public static int xorOptimal(int[] nums, int k){
        int count =0;
        HashMap<Integer,Integer> frontxor = new HashMap<>();
        frontxor.put(0,1);
        int xor =0;
        for (int i = 0; i < nums.length; i++) {
            xor ^=nums[i];
            int tmp=xor^k;
            if(frontxor.containsKey(tmp)){
                count+= frontxor.get(tmp);
            }

            if(frontxor.containsKey(xor)){
                frontxor.put(xor,frontxor.get(xor)+1);
            }else{
                frontxor.put(xor,1);
            }

        }
        return count;
    }
}
