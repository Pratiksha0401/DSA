package org.example.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * MergeOverlappingSubIntervals demonstrates two ways to merge overlapping intervals:
 * 1. Returning a List of Lists (mergeOverlappingIntervals).
 * 2. Returning a 2D array (merge).
 *
 * <p><b>Problem Statement:</b>
 * Given a collection of intervals, merge all overlapping intervals and return the merged ones.
 *
 * <p><b>Example:</b>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 */
public class MergeOverlappingSubIntervals {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

        // Using List<List<Integer>> version
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are (List<List<Integer>>): \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();

        // Using int[][] version
        int[][] merge = merge(arr);
        System.out.println("The merged intervals are (int[][]): ");
        for (int[] interval : merge) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    /**
     * Merges overlapping intervals and returns a List of Lists.
     *
     * Steps:
     * 1. Sort intervals based on their starting time.
     * 2. Traverse each interval and merge it with subsequent intervals if overlapping.
     * 3. Skip intervals that are already covered by the last merged interval.
     *
     * @param arr input 2D array of intervals
     * @return list of merged intervals
     *
     * <p><b>Time Complexity:</b> O(n log n) for sorting + O(n^2) in worst case (nested loop).
     * <br><b>Space Complexity:</b> O(n) for storing merged intervals.
     */
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length;

        // Step 1: Sort intervals by start time
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        // Step 2: Traverse and merge intervals
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // Skip if interval is already covered
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // Merge with following overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }

            // Add merged interval
            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }

    /**
     * Merges overlapping intervals and returns result as a 2D array.
     *
     * Steps:
     * 1. Sort intervals based on start.
     * 2. For each interval:
     *      - If overlapping with current interval, extend the end.
     *      - Else, add the completed interval to the result.
     * 3. Convert List<int[]> to int[][] for the final result.
     *
     * @param a input 2D array of intervals
     * @return merged intervals as int[][]
     *
     * <p><b>Time Complexity:</b> O(n log n) for sorting + O(n) for merging → O(n log n).
     * <br><b>Space Complexity:</b> O(n) for storing merged intervals.
     */
    public static int[][] merge(int[][] a) {
        int n = a.length;

        // Step 1: Sort intervals by start time
        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        List<int[]> ans = new ArrayList<>();

        // Step 2: Traverse and merge
        for (int i = 0; i < n; i++) {
            int start = a[i][0];
            int end = a[i][1];

            // Skip if already covered
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            // Merge with overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (a[j][0] <= end) {
                    end = Math.max(end, a[j][1]);
                } else {
                    break;
                }
            }

            // Add merged interval
            ans.add(new int[]{start, end});
        }

        // Step 3: Convert to int[][]
        return ans.toArray(new int[ans.size()][]);
    }
}
