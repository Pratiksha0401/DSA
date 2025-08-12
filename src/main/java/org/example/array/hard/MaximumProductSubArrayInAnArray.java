package org.example.array.hard;

public class MaximumProductSubArrayInAnArray {
    public static void main(String[] args) {
        int[] arr={2,3,-2,4};
        final int result = bruteForce(arr);
        System.out.println(result);

        final int resultBetter = better(arr);
        System.out.println(resultBetter);

        final int resultOptimal = optimal(arr);
        System.out.println(resultOptimal);

    }

    public static int bruteForce(int[] arr){
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int tmpProduct =1;
                for (int k = i; k < j; k++) {
                    tmpProduct = tmpProduct*arr[k];
                }
                maxProduct = Math.max(maxProduct,tmpProduct);
            }
        }
        return maxProduct;
    }

    public static int better(int[] arr){
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmpProduct =1;
            for (int j = i; j < arr.length; j++) {
                tmpProduct = tmpProduct*arr[j];
                maxProduct = Math.max(maxProduct,tmpProduct);
            }
        }
        return maxProduct;
    }

    public static int optimal(int[] arr){
        int maxProduct = Integer.MIN_VALUE;
        int prefix =1, suffix =1;
        for (int i = 0; i < arr.length; i++) {
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;

            prefix=prefix*arr[i];
            suffix=suffix*arr[arr.length-1-i];
            maxProduct =Math.max(maxProduct,prefix);
            maxProduct= Math.max(maxProduct,suffix);
        }
        return maxProduct;
    }
}
