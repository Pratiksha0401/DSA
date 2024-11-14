package org.example.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestEle {

    public static void main(String[] args) {
        int [] arr = {2,5,1,9,3,6,3,-6,10};
        kthSmallestElements(arr,4);
        kthlargestElements(arr,4);
    }

    private static void kthSmallestElements(int[] arr, int k) {
        PriorityQueue maxH = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            maxH.add(arr[i]);
        }
        for(int i=k;i< arr.length;i++){
            int tmp = (int) maxH.peek();
            if(tmp>arr[i]){
                maxH.remove();
                maxH.add(arr[i]);
            }
        }

        while (maxH.size()>0){
            System.out.println(maxH.remove());
        }
    }

    private static void kthlargestElements(int[] arr, int k) {
        System.out.print("*******************************************");
        PriorityQueue minH = new PriorityQueue<>();
        for(int i=0;i<k+1;i++){
            minH.add(arr[i]);
        }
        for(int i=k;i< arr.length;i++){
            int tmp = (int) minH.peek();
            if(tmp<arr[i]){
                minH.remove();
                minH.add(arr[i]);
            }
        }

        while (minH.size()>0){
            System.out.println(minH.remove());
        }
    }


}
