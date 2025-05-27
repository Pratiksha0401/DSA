package org.example.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr1 = {25,48,75,2,48,15,6,7,39,54};
        int [] arr = {1,2,3,4,5,6};
        for(int i=0;i<arr.length;i++){
            int isSwap =0;
            for(int j =0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    isSwap=1;
                }
            }
            if(isSwap==0){
                break;
            }
            System.out.println("runs");
        }

        for(int n : arr){
            System.out.println(n);
        }
    }
}
