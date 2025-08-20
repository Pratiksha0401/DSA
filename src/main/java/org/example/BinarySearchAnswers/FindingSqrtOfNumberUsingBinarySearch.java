package org.example.BinarySearchAnswers;

public class FindingSqrtOfNumberUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println(findSqrtBruteForce(28));
        System.out.println(findSqrtBruteForce(7));
        System.out.println(findSqrtOptimal(28));
        System.out.println(findSqrtOptimal(7));

    }

    public static int findSqrtBruteForce(int n ){
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if(i*i<=n){
                ans = i;
            }else{
                break;
            }
        }
        return ans;
    }

    public static int findSqrtOptimal(int n ){
        int ans = -1;
        int low = 1, high = n;
        while(low<=high){
            int mid = low + (high - low)/2;
            if((mid*mid) <= n){
                ans = mid;
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return ans;
    }
}
