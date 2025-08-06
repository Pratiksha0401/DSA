package org.example.array.hard;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = arr1.length, m = arr2.length;
        mergeBruteForce(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    public static void mergeBruteForce(int [] arr1, int arr2[], int n , int m){
        int[] arr = new int[n+m];
        int left=0, right=0, index=0;
        while(left<n && right<m){
            if(arr1[left]<arr2[right]){
                arr[index]=arr1[left];
                left++;
                index++;
            }else{
                arr[index]=arr2[right];
                right++;
                index++;
            }
        }

        while(left<n){
            arr[index]=arr1[left];
            left++;
            index++;
        }

        while (right<m){
            arr[index]=arr2[right];
            right++;
            index++;
        }

        for (int i = 0; i < n+m; i++) {
            if(i<n){
                arr1[i]=arr[i];
            }else{
                arr2[i-n]=arr[i];
            }
        }
    }
}
