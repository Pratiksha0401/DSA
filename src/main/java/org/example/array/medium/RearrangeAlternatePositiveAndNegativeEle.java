package org.example.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeAlternatePositiveAndNegativeEle {
    public static void main(String[] args) {
//        int [] arrBruteForce={3,1,-2,8,-4,-2,4,6,-1,-7};
//        bruteForce(arrBruteForce);
//        System.out.println(Arrays.toString(arrBruteForce));
//
//        int [] arrBetterForce={3,1,-2,8,-4,-2,4,6,-1,-7};
//        System.out.println(Arrays.toString(betterForce(arrBetterForce)));

        int [] optimalArr={3,1,-2,8,-4,-2,4,6,-1,-7,4,-3,-7,-2};
        System.out.println(Arrays.toString(optimalForce(optimalArr)));

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


    //optimal approach if +ve and _ves are different in lengths
    public static int[] optimalForce(int[] arr) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int[] resultArr =  new int[arr.length];

        // Segregate the array into positives and negatives.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        System.out.println(pos);
        System.out.println(neg);
        if(pos.size()>neg.size()){
            for(int i =0;i<neg.size();i++){
                resultArr[2*i] = pos.get(i);
                resultArr[2*i+1] = neg.get(i);
            }
            int indices = neg.size()*2;
            for(int i=neg.size();i< pos.size();i++) {
                resultArr[indices] = pos.get(i);
                indices++;
            }
        }

        if(pos.size()<neg.size()){
            for(int i =0;i<pos.size();i++){
                resultArr[2*i] = pos.get(i);
                resultArr[2*i+1] = neg.get(i);
            }
            int indices = pos.size()*2;
            for(int i=pos.size();i< neg.size();i++) {
                resultArr[indices] = neg.get(i);
                indices++;
            }
        }
        System.out.println(Arrays.toString(resultArr));

        return resultArr;
    }
}

