package org.example.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZero {
    public static void main(String[] args) {
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        int n = matrix.size();
        int m = matrix.get(0).size();
        setMatrixZeroBrute(matrix,n,m);
        System.out.println(matrix);


        List<ArrayList<Integer>> matrix1 = new ArrayList<>();
        matrix1.add(new ArrayList<>(Arrays.asList(1,1,1)));
        matrix1.add(new ArrayList<>(Arrays.asList(1,0,1)));
        matrix1.add(new ArrayList<>(Arrays.asList(1,1,1)));
        int k = matrix1.size();
        int l = matrix1.get(0).size();
        setMatrixZeroBetter(matrix1,k,l);
        System.out.println(matrix1);
    }

    public static void setMatrixZeroBrute(List<ArrayList<Integer>> list, int n ,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(list.get(i).get(j)==0){
                    markRow(list,n,m,i);
                    markCol(list,n,m,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(list.get(i).get(j)==-1){
                    list.get(i).set(j, 0);
                }
            }
        }
    }

    static void markRow(List<ArrayList<Integer>> matrix, int n, int m, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static void markCol(List<ArrayList<Integer>> matrix, int n, int m, int j) {
        // set all non-zero elements as -1 in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    public static void setMatrixZeroBetter(List<ArrayList<Integer>> list, int n ,int m){
        int row[] = new int[n];
        int col[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(list.get(i).get(j)==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i]==1 || col[j]==1){
                    list.get(i).set(j,0);
                }
            }
        }


    }
}
