package org.example.BinarySearchOn1DArray;

public class SearchSingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        final int singleElement = findSingleElementBruteForce(arr, arr.length);
        System.out.println(singleElement);

        int[] arr2 = {1, 1, 2, 2, 3, 3, 4,4, 5, 5, 6, 6};
        final int singleElement2 = findSingleElementBruteForce(arr2, arr2.length);
        System.out.println(singleElement2);

        int[] arr3 = {1, 1, 2, 2, 3, 3, 4,4, 5, 5, 6, 6,7};
        final int singleElement3 = findSingleElementBruteForce(arr3, arr3.length);
        System.out.println(singleElement3);

        int[] arr4 = {2, 3, 3, 4,4, 5, 5, 6, 6};
        final int singleElement4 = findSingleElementBruteForce(arr4, arr4.length);
        System.out.println(singleElement4);
    }

    public static int findSingleElementBruteForce(int[] arr, int n){
        int ele =  -1;
        for (int i = 0; i < n; i++) {
            if(n==1) return arr[0];
            if(i==0 && arr[i]!=arr[i+1]) return arr[0];
            else if(i==n-1 && arr[i]!=arr[i-1]) return arr[n-1];
            else{
                if(i>0 && i<n-1 && arr[i]!=arr[i+1] && arr[i]!=arr[i-1]){
                    return arr[i];
                }
            }
        }
        return ele;
    }
}
