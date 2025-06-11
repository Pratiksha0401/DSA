package org.example.array;

public class FindTheNoThatApperasOnce {
    public static void main(String[] args) {
        int[]arr={1,1,2,3,3,4,4,8,8};
        int xor=0;
        for(int i=0;i< arr.length;i++){
            xor = xor ^ arr[i];
        }
        System.out.println(xor);
    }
}
