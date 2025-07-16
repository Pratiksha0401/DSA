package org.example.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Set Matrix Zeroes
 *
 * Given a 2D matrix, if an element is 0, set its entire row and column to 0.
 * This class demonstrates:
 * 1. Brute-force approach (modifies the matrix in-place using marking technique)
 * 2. Better approach using extra space (row[] and col[] arrays)
 */
public class SetMatrixZero {

    /**
     * Main method to test both brute-force and better solutions.
     */
    public static void main(String[] args) {

        // ------------------- Input for Brute Force Approach -------------------
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        // Call brute-force solution
        setMatrixZeroBrute(matrix, n, m);
        System.out.println("Brute Force Output: " + matrix);

        // ------------------- Input for Better Approach -------------------
        List<ArrayList<Integer>> matrix1 = new ArrayList<>();
        matrix1.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix1.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix1.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int k = matrix1.size();
        int l = matrix1.get(0).size();

        // Call better solution
        setMatrixZeroBetter(matrix1, k, l);
        System.out.println("Better Approach Output: " + matrix1);
    }

    /**
     * Brute Force Approach:
     * Marks all elements in the row and column of a 0 cell as -1 first,
     * and then in a second pass converts all -1s to 0.
     *
     * Why this works: We use -1 as a marker to avoid converting the entire row/column
     * immediately and affecting the rest of the scan.
     *
     * Time Complexity: O(N * M)
     * Space Complexity: O(1) (in-place modification)
     */
    public static void setMatrixZeroBrute(List<ArrayList<Integer>> list, int n, int m) {
        // First pass: mark rows and cols with -1 where 0 is found
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list.get(i).get(j) == 0) {
                    markRow(list, n, m, i);
                    markCol(list, n, m, j);
                }
            }
        }

        // Second pass: convert marked -1 values to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list.get(i).get(j) == -1) {
                    list.get(i).set(j, 0);
                }
            }
        }
    }

    /**
     * Helper method to mark all non-zero elements of a row with -1.
     * @param matrix 2D matrix
     * @param n total rows
     * @param m total cols
     * @param i target row index
     */
    static void markRow(List<ArrayList<Integer>> matrix, int n, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    /**
     * Helper method to mark all non-zero elements of a column with -1.
     * @param matrix 2D matrix
     * @param n total rows
     * @param m total cols
     * @param j target column index
     */
    static void markCol(List<ArrayList<Integer>> matrix, int n, int m, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    /**
     * Better Approach:
     * Uses two auxiliary arrays (row[], col[]) to store which rows and columns
     * need to be set to 0.
     *
     * Time Complexity: O(N * M)
     * Space Complexity: O(N + M)
     */
    public static void setMatrixZeroBetter(List<ArrayList<Integer>> list, int n, int m) {
        int row[] = new int[n]; // stores rows that have 0
        int col[] = new int[m]; // stores cols that have 0

        // First pass: find all 0s and mark corresponding row and col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Second pass: update matrix with 0s where marked
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    list.get(i).set(j, 0);
                }
            }
        }
    }
}
