package org.example.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrint {
    public static void main(String[] args) {
        int [][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        final List<Integer> spiral = spiral(arr);

        for (int i = 0; i < spiral.size(); i++) {
            System.out.println(spiral.get(i));
        }
    }

    public static List<Integer> spiral(int[][] arr){
        List<Integer> list =  new ArrayList<>();
        int n= arr.length;
        int m = arr[0].length;

        int left = 0, right = m-1;
        int top = 0,  bottom = n-1;

        while(top<=bottom && left<=right){
            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(arr[i][right]);
            }
            right--;
            if(top<=bottom){
                for (int i = right; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
