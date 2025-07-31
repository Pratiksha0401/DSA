package org.example.array.hard;

import java.util.*;

/**
 * This class provides three approaches to solve the 4Sum problem,
 * where the task is to find all unique quadruplets in an array that sum up to zero.
 * <p>
 * Approaches:
 * 1. Brute Force (O(n^4) time)
 * 2. Better (HashSet-based) (O(n^3) time)
 * 3. Optimal (Sorting + Two Pointers) (O(n^3) time with better constant factor)
 */
public class FourSum {
    public static void main(String[] args) {
        int arr[] = {-1, -2, -3, -1, 0, -1, 1, 2, -1, 0, 0, 2, 3, 1, -1, -2};
        int target = 0;

        List<List<Integer>> lists = bruteForce(arr);
        System.out.println("Brute Force Output:");
        System.out.println(lists);

        List<List<Integer>> list1 = betterForce(arr);
        System.out.println("Better Approach Output:");
        System.out.println(list1);

        List<List<Integer>> list2 = optimalApproach(arr);
        System.out.println("Optimal Approach Output:");
        System.out.println(list2);

        int nums[] = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> list3 = fourSum(nums, 0);
        System.out.println("Optimal Approach Output:");
        System.out.println(list3);

        int nums1[] = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> list4 = fourSumMy(nums1, 0);
        System.out.println("Optimal Approach Output mmy:");
        System.out.println(list4);
    }

    /**
     * Brute Force approach to find all unique quadruplets that sum to 0.
     * Time Complexity: O(n^4)
     * Space Complexity: O(n) for storing results in a set.
     *
     * @param nums the input array
     * @return list of unique quadruplets
     */
    public static List<List<Integer>> bruteForce(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == 0) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp); // sort to avoid duplicate permutations
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * Better approach using HashSet to reduce time complexity to O(n^3).
     * Time Complexity: O(n^3)
     * Space Complexity: O(n) for HashSet
     *
     * @param nums the input array
     * @return list of unique quadruplets
     */
    public static List<List<Integer>> betterForce(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> seen = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int l = -(nums[i] + nums[j] + nums[k]);
                    if (seen.contains(l)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], l);
                        Collections.sort(temp); // sort to avoid duplicate permutations
                        set.add(temp);
                    }
                    seen.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    /**
     * Optimal approach using Sorting + Two Pointers technique.
     * Time Complexity: O(n^3)
     * Space Complexity: O(1) + O(n) for output list
     *
     * @param nums the input array
     * @return list of unique quadruplets
     */
    public static List<List<Integer>> optimalApproach(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // sort to enable two-pointer logic
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates for j

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        lists.add(tmp);
                        k++;
                        l--;

                        // Skip duplicate values for k
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicate values for l
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum > 0) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> fourSumMy(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = (long)(nums[i]+nums[j]+nums[k]+nums[l]);
                    if(sum==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;l--;

                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return list;
    }
}