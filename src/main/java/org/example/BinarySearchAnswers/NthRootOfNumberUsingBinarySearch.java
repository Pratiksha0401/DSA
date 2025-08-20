package org.example.BinarySearchAnswers;

public class NthRootOfNumberUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println(bruteForce(3,27));

    }

    public static int bruteForce(int n, int m){
        int ans =  -1;
        for (int i = 1; i <= n; i++) {
            if(Math.pow(i,n)==m){
                ans = i;
            }else if(Math.pow(i,n)>m){
                break;
            }
        }
        return ans;
    }
}
