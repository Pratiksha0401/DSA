package org.example.array;

public class RotateArray {
    public static void main(String[] args) {
        int []arr ={1,2,3,4,5,6,7};
        int  k = 24;
        int d= k% arr.length;
        reverseArray(arr,0,d-1);
        reverseArray(arr,d, arr.length-1);
        reverseArray(arr,0, arr.length-1);
        for(int n : arr){
            System.out.print(n+",");
        }

    }

    public static void reverseArray(int []arr, int sp , int ep){
        while(sp<=ep){
            int tmp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = tmp;
            sp++;
            ep--;
        }
    }

    public static void rotateArray(int [] arr, int d){
        int [] tmp =  new int[d];
        for(int i=0;i<d;i++){
            tmp[i] = arr[i];
        }
    }

}
