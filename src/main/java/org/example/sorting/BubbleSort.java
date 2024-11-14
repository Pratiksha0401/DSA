package org.example.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {-1,-123,2,0,2,4,1};
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int a : arr){
            System.out.println(a+" ");
        }
    }
}
