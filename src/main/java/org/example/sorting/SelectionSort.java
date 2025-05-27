package org.example.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {25,48,75,2,48,15,6,7,39,54};
        int [] arr1 = {1,2,3,4,5,6};
        for(int i=0;i<arr.length-1;i++){
            int min =i;
            for(int j =i+1;j< arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int tmp = arr[min];
            arr[min]=arr[i];
            arr[i]=tmp;
        }

        for(int n : arr){
            System.out.println(n);
        }
    }
}
