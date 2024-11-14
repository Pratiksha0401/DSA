package org.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Practicse {
    public static void main(String[] args) {
        int [] arr={2,3,2,4,5,3,6,7,4,8,9};
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i< arr.length;i++){
            if(hm.containsKey(arr[i])){
                int temp = hm.get(arr[i]);
                hm.put(arr[i],++temp);
            }else{
                hm.put(arr[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> me : hm.entrySet()){
            System.out.println(me.getKey() +" : "+me.getValue());
        }
    }
}
