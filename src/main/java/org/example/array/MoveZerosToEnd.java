package org.example.array;

import java.util.*;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int []arr={1,2,0,5,3,7,0,9,0,0};
        movesZerosToEndOptimal(arr);
        for(int n:arr){
            System.out.print(n+",");
        }
        System.out.println();
        int []arr1={1,2,0,5,3,7,0,9,0,0};
        movesZerosToEndBruteForce(arr1);
        for(int n:arr1){
            System.out.print(n+",");
        }
    }

    public static void movesZerosToEndOptimal(int []arr){
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                int tmp = arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                j++;
            }
        }
    }

    public static void movesZerosToEndBruteForce(int []arr){
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                li.add(arr[i]);
            }
        }
        int d = li.size();
        Arrays.fill(arr,0);
        for(int i=0;i<d;i++){
            arr[i]=li.get(i);
        }

    }
}
