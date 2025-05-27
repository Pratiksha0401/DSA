package org.example.sorting;

public class Test {
    public static void main(String[] args) {
        int []arr ={11,2,23,7,75,6};
        int n = arr.length;
        for(int i=0;i<n;i++){
            int j = i;
            while( j>0 && arr[j-1] > arr[j]){
                int tmp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1] = tmp;
                j--;
            }

        }

        for(int x : arr){
            System.out.println(x);
        }
    }
}
