package org.example.array.easy;

public class Array1 {
    public static void main(String[] args) {
        int arr[] = {-9, 2, -1, 5, 3,2,};
         igg(arr);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }

    public static void igg(int[] arr) {
        int n = arr.length;
        for (int i=0;i<n-1;i++)  {
            for (int j=0;j<n-1-i;j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

