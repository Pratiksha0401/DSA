package org.example.array.hard;

import java.util.*;

public class ThreeSumFindTripletsThatAddUpTo0 {
    public static void main(String[] args) {
        int arr[] = {-1,-2,-3,-1,0,-1,1,2,-1,0,0,2,3,1,-1,-2};
        final List<List<Integer>> lists = bruteForceApproach(arr);
        System.out.println(lists);

        final List<List<Integer>> list1 = betterApproach(arr);
        System.out.println(list1);

        final List<List<Integer>> list2 = optimalApproach(arr);
        System.out.println(list2);

    }

    public  static List<List<Integer>> bruteForceApproach(int []arr){
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

    public  static List<List<Integer>> betterApproach(int []arr){
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i+1; j < arr.length; j++) {
                int k = -(arr[i]+arr[j]);
                if(s.contains(k)){
                    List<Integer> li = Arrays.asList(arr[i],arr[j],k);
                    Collections.sort(li);
                    set.add(li);
                }
                s.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }

    public  static List<List<Integer>> optimalApproach(int []arr){
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k =arr.length-1;
            while(j<=k){
                if(arr[i]+arr[j]+arr[k]==0){
                    List<Integer> li = Arrays.asList(arr[i],arr[j],arr[k]);
                    list.add(li);
                    j++;k--;
                    while(j>0 && arr[j]==arr[j-1]) j++;
                    while(k>0 && arr[k]==arr[k-1]) k--;
                }else if(arr[i]+arr[j]+arr[k]<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return list;
    }
}
