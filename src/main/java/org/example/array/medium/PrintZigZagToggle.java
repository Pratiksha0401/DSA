package org.example.array.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintZigZagToggle {
    public static void main(String[] args) {
        int [][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        final List<Integer> list = printZigZag(arr);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Integer> printZigZag(int[][] arr){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                for(int j=0;j<arr[0].length;j++){
                    list.add(arr[i][j]);
                }
            }else{
                for (int j = arr[0].length-1; j >=0 ; j--) {
                    list.add(arr[i][j]);
                }
            }
        }
        return list;
    }
}
