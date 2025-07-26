package org.example.array.hard;

import java.util.*;

public class ThreeSumFindTripletsThatAddUpTo0 {
    public static void main(String[] args) {
        int arr[] = {-1,-2,-3,-1,0,-1,1,2,-1,0,0,2,3,1,-1,-2};
        final List<List<Integer>> lists = brutrForceApproach(arr);
        System.out.println(lists);

    }

    public  static List<List<Integer>> brutrForceApproach(int []arr){
        Set<List<Integer>> se = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        se.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(se);
    }
}
