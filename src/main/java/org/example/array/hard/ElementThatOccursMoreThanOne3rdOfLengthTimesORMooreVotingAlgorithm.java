package org.example.array.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementThatOccursMoreThanOne3rdOfLengthTimesORMooreVotingAlgorithm {
    public static void main(String[] args) {
        int []arr = {2,3,4,2,3,4,2,2,3,3};
        List<Integer> list = bruteForceApproach(arr);
        System.out.println(list);

        List<Integer> list1 = bruteForceApproach(arr);
        System.out.println(list1);

        List<Integer> list2 = optimalApproach(arr);
        System.out.println(list2);
    }

    public static List<Integer> bruteForceApproach(int []arr){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if(ele==arr[j]){
                    cnt++;
                }
            }
            int t = arr.length/3;
            if(cnt> arr.length/3){
                if(ele==4) {
                    int tmp = arr.length / 3;
                }
                list.add(ele);
            }
            if(list.size()==2){
                break;
            }
        }
        return list;
    }

    public static List<Integer> betterApproach(int []arr){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            int ele =arr[i];
            if(hm.get(ele) > arr.length/3){
                list.add(ele);
            }
            if (list.size()==2){
                break;
            }
        }
        return list;
    }

    public static List<Integer> optimalApproach(int []arr){
        List<Integer> list = new ArrayList<>();
        int cnt1=0,cnt2=0;
        int ele1=0,ele2=0;
        for (int i = 0; i < arr.length; i++) {
            if(cnt1==0 && ele2!=arr[i]){
                ele1=arr[i];
                cnt1++;
            }else if(cnt2==0 && ele1!=arr[i]){
                ele2=arr[i];
                cnt2++;
            }else if(ele1==arr[i]){
                cnt2++;
            }else if(ele2==arr[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for (int i = 0; i < arr.length; i++) {
            if(ele1==arr[i]) cnt1++;
            if(ele2==arr[i]) cnt2++;
        }

        if(cnt1 > arr.length/3) list.add(ele1);
        if(cnt2 > arr.length/3) list.add(ele2);

        return list;
    }
}
