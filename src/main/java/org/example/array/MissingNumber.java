package org.example.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7};
        int N = 7;
        int n = missingNumberBruteForce2(arr, N);
        System.out.println("Missing Number : "+n);
    }

    public static int missingNumberBruteForce1(int [] arr, int n){
        for(int i=1;i<n;i++){
            int flag =0 ;
            for(int j=0;j<n-1;j++){
                if(arr[j]==i){
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumberBruteForce2(int [] arr, int n){
        int hash[] = new int[n+1];
        // storing the frequencies:
        for (int i = 0; i < n - 1; i++)
            hash[arr[i]]++;

        //checking the freqencies for numbers 1 to N:
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumberOptimal1(int [] arr, int n){
        int sum1 = 0;
        for(int i=0;i<n-1;i++){
            sum1 +=arr[i];
        }
        int sum2 = n*(n+1)/2;

        return sum2-sum1;
    }
    public static int missingNumberOptimal2(int [] arr, int n){
        int xor1=0,xor2=0;
        for(int i=0;i<n-1;i++){
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ n;
        return (xor1 ^ xor2);
    }
}
