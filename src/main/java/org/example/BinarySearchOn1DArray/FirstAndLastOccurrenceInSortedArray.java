package org.example.BinarySearchOn1DArray;

public class FirstAndLastOccurrenceInSortedArray {

    public static void main(String args[]) {
        int n = 7;
        int key = 13;
        int[] v = {3,4,13,13,13,20,40};

        // returning the last occurrence index if the element is present otherwise -1
        System.out.println(last(n, key, v));
    }

    public static int last(int n, int key, int[] v) {
        int res = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (v[i] == key) {
                res = i;
                break;
            }
        }
        return res;
    }

}
