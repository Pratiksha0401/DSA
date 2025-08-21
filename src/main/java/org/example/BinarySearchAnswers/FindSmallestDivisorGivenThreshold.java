package org.example.BinarySearchAnswers;

public class FindSmallestDivisorGivenThreshold {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisorBruteForce(arr, limit);
        System.out.println("The minimum divisor is: " + ans);

        int res = smallestDivisorOptimal(arr, limit);
        System.out.println("The minimum divisor is: " + res);
    }

    public static int smallestDivisorBruteForce(int[] arr, int limit) {
        int n = arr.length; //size of array.
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        //Find the smallest divisor:
        for (int d = 1; d <= maxi; d++) {
            //Find the summation result:
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double)(arr[i]) / (double)(d));
            }
            if (sum <= limit)
                return d;
        }
        return -1;
    }

    public static int sumByD(int[] arr, int div) {
        int n = arr.length; //size of array
        //Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }
    public static int smallestDivisorOptimal(int[] arr, int limit) {
        int n = arr.length; //size of array.
        if(n > limit) return -1;
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1, high = maxi;

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
