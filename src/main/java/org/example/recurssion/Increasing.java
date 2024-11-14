package org.example.recurssion;

import java.util.Scanner;

public class Increasing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        inc(n);
    }

    public static void inc(int n){
        if(n==1){
            System.out.println(1);
            return;
        }
        inc(n-1);
        System.out.println(n);
    }
}
