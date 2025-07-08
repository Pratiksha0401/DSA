package org.example.array.medium;

public class DPOnStockMaxProfit {
    public static void main(String[] args) {
        int arr[] = {7,1,5,2,6,4};
        int min=arr[0];
        int maxProfit=0;
        for(int i=1;i< arr.length;i++){
            int profit = arr[i]-min;
            maxProfit = Math.max(maxProfit,profit);
            min = Math.min(min,arr[i]);
        }

        System.out.println("maxProfit : "+maxProfit);
    }
}
