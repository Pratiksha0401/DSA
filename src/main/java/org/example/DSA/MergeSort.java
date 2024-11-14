package org.example.DSA;

public class MergeSort {
    public static void main(String[] args) {
        int [] nums = {3,3,8,1,6,2,4};

        for (int num: nums) {
            System.out.print(num+" ");
        }

        mergeSort(nums,0,nums.length-1);

        System.out.println();
        System.out.println("After sort");
        for (int num: nums) {
            System.out.print(num+" ");
        }
    }

    public static void mergeSort(int arr[],int sp, int ep){
        if(sp<ep){
            int mid=sp+(ep-sp)/2;
            mergeSort(arr,sp,mid);
            mergeSort(arr,mid+1,ep);
            merge(arr,sp,mid,ep);
        }
    }

    private static void merge(int[] arr, int sp, int mid, int ep) {
        int n1=mid-sp+1;
        int n2=ep-mid;
        int sarr[] = new int[n1];
        int earr[] = new int[n2];
        for(int q=0;q<n1;q++){
            sarr[q] =arr[sp+q];
        }
        for(int q=0;q<n2;q++){
            earr[q] =arr[mid+1+q];
        }

        int i=0;
        int j=0;
        int k=sp;
        while(i<n1 && j<n2){
            if (sarr[i]<=earr[j]){
                arr[k]=sarr[i];
                i++;
            }
            else{
                arr[k]=earr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=sarr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=earr[j];
            j++;
            k++;
        }

    }
}
