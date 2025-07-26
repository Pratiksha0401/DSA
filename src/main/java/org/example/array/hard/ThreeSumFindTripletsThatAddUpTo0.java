package org.example.array.hard;

import java.util.*;

public class ThreeSumFindTripletsThatAddUpTo0 {

    public static void main(String[] args) {
        int arr[] = {-1,-2,-3,-1,0,-1,1,2,-1,0,0,2,3,1,-1,-2};

        final List<List<Integer>> lists = bruteForceApproach(arr);
        System.out.println("Brute Force: " + lists);

        final List<List<Integer>> list1 = betterApproach(arr);
        System.out.println("Better Approach: " + list1);

        final List<List<Integer>> list2 = optimalApproach(arr);
        System.out.println("Optimal Approach: " + list2);
    }

    /**
     * Brute-force approach to find all unique triplets that sum to 0.
     * Time Complexity: O(n³)
     * Space Complexity: O(k) for storing result in a Set, where k = number of unique triplets
     *
     * @param arr input array
     * @return list of unique triplets with sum = 0
     */
    public static List<List<Integer>> bruteForceApproach(int[] arr) {
        Set<List<Integer>> se = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp); // Ensure uniqueness
                        se.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(se);
    }

    /**
     * Better approach using hashing to reduce time complexity.
     * Fix one element, then use HashSet to find the required third number.
     * Time Complexity: O(n²)
     * Space Complexity: O(n) + O(k) for HashSet and result storage
     *
     * @param arr input array
     * @return list of unique triplets with sum = 0
     */
    public static List<List<Integer>> betterApproach(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int k = -(arr[i] + arr[j]);
                if (s.contains(k)) {
                    List<Integer> li = Arrays.asList(arr[i], arr[j], k);
                    Collections.sort(li);
                    set.add(li);
                }
                s.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * Optimal approach using sorting + two-pointer technique.
     * Sort array and move two pointers to find required triplets efficiently.
     * Time Complexity: O(n²)
     * Space Complexity: O(k) for result list
     *
     * @param arr input array
     * @return list of unique triplets with sum = 0
     */
    public static List<List<Integer>> optimalApproach(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicate i

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    list.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    // Skip duplicates for j
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    // Skip duplicates for k
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }
}
