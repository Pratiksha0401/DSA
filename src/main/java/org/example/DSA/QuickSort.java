package org.example.DSA;

public class QuickSort {
    public static void main(String []args){
        int [] arr= {4,2,8,1,5,9,2};
        quickSort(arr,0,arr.length-1);
        for (int num: arr) {
            System.out.print(num+" ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pi= partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }


    public static int partition(int arr[],int low, int high){
        int pi=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pi){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    public static void swap(int []arr, int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
