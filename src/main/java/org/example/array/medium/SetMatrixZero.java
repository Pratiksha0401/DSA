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
        setMatrixZero(matrix);
        System.out.println(matrix);
    }

    public static void setMatrixZero(List<ArrayList<Integer>> list){
        list.add(new ArrayList<>(Arrays.asList(1,2,3)));
    }
}
