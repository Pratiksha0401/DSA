package org.example.hashmap;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class HashMapPrintFrequency
{
    // "static void main" must be defined in a public class.

        public static void main(String[] args) {
            int arr[] = {2,3,2,2,2,6,1,8,7,4,3};
            int quries[] = {2,4,7,9};
            //printfrequency(arr,quries);
            printfrequency2loops(arr,quries);
        }
        public static void printfrequency(int arr[], int quries[]){
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=0;i<arr.length;i++){
                if(hm.containsKey(arr[i])){
                    int temp = hm.get(arr[i]);
                    hm.put(arr[i],++temp);
                }else{
                    hm.put(arr[i],1);
                }
            }

            for(int j=0;j<quries.length;j++){
                int val = quries[j];
                if(hm.containsKey(quries[j])){
                    System.out.println(hm.get(quries[j]));
                }else{
                    System.out.println(0);
                }
            }
        }

        public static void printfrequency2loops(int arr[], int quries[]){
            for(int j=0;j<quries.length;j++){
                int val = quries[j];
                int count=0;
                for(int i=0;i<arr.length;i++){
                    if(val==arr[i]){
                        count = count+1;
                    }
                }
                System.out.println(count);
            }
        }

}
