package org.example.BinarySearchAnswers;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
        int ans = missingKBruteForce(vec, n, k);
        System.out.println("The missing number is: " + ans);
    }

    public static int missingKBruteForce(int[] vec, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (vec[i] <= k) k++; //shifting k
            else break;
        }
        return k;
    }

}
