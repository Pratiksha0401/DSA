package org.example.array;

public class MaximunmConsecutiveOnes {
    public static void main(String[] args) {
        int []arr={1,1,0,1,0,1,1,1,1,0,0,1,1};
        int max= 0;
        int cnt = 0;
        for(int i=0;i< arr.length;i++){
           if(arr[i]==1){
               cnt++;
           }else{
               max = Math.max(max,cnt);
               cnt=0;
           }
        }
        System.out.println(max);
    }
}
