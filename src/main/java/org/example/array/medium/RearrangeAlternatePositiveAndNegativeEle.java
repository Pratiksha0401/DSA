package org.example.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeAlternatePositiveAndNegativeEle {
    public static void main(String[] args) {
        int [] arrBruteForce={3,1,-2,8,-4,-2,4,6,-1,-7};
        bruteForce(arrBruteForce);
        System.out.println(Arrays.toString(arrBruteForce));

        int [] arrBetterForce={3,1,-2,8,-4,-2,4,6,-1,-7};
        System.out.println(Arrays.toString(betterForce(arrBetterForce)));

//        int [] optimalForceArr={3,1,-2,8,-4,-2,4,6,-1,-7};
//        System.out.println(Arrays.toString(optimalForce(optimalForceArr)));

    }

    public static void bruteForce(int [] arr){
        List<Integer> pv = new ArrayList<>();
        List<Integer> nv =  new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            if(arr[i]>0){
                pv.add(arr[i]);
            }else{
                nv.add(arr[i]);
            }
        }

        for(int i=0;i< arr.length/2;i++){
            arr[(2*i)+1] = nv.get(i);
            arr[2*i] = pv.get(i);
        }
    }

    public static int[] betterForce(int [] arr){
        int resArr[]= new int[arr.length];
        int pp=0;
        int np=1;
        for(int i=0;i< arr.length;i++){
            if(arr[i]>0){
               resArr[pp]=arr[i];
               pp=pp+2;
            }else{
                resArr[np]=arr[i];
                np=np+2;
            }
        }
        return resArr;
    }


//    //optimal approach if +ve and _ves are different in lengths
//    public static ArrayList<Integer> optimalForce(ArrayList<Integer> A, int n) {
//        // Define 2 ArrayLists, one for storing positive
//        // and other for negative elements of the array.
//        ArrayList<Integer> pos = new ArrayList<>();
//        ArrayList<Integer> neg = new ArrayList<>();
//
//        // Segregate the array into positives and negatives.
//        for (int i = 0; i < n; i++) {
//            if (A.get(i) > 0)
//                pos.add(A.get(i));
//            else
//                neg.add(A.get(i));
//        }
//
//        // If positives are lesser than the negatives.
//        if (pos.size() < neg.size()) {
//
//            // First, fill array alternatively till the point
//            // where positives and negatives are equal in number.
//            for (int i = 0; i < pos.size(); i++) {
//                A.set(2 * i, pos.get(i));
//                A.set(2 * i + 1, neg.get(i));
//            }
//
//            // Fill the remaining negatives at the end of the array.
//            int index = pos.size() * 2;
//            for (int i = pos.size(); i < neg.size(); i++) {
//                A.set(index, neg.get(i));
//                index++;
//            }
//        }
//
//        // If negatives are lesser than the positives.
//        else {
//            // First, fill array alternatively till the point
//            // where positives and negatives are equal in number.
//            for (int i = 0; i < neg.size(); i++) {
//                A.set(2 * i, pos.get(i));
//                A.set(2 * i + 1, neg.get(i));
//            }
//
//            // Fill the remaining positives at the end of the array.
//            int index = neg.size() * 2;
//            for (int i = neg.size(); i < pos.size(); i++) {
//                A.set(index, pos.get(i));
//                index++;
//            }
//        }
//        return A;
//    }
}

