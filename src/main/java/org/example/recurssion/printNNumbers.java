package org.example.recurssion;

import java.util.Scanner;

public class printNNumbers {
    static int cnt =0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        print(n);
    }

    public static void print(int n){
        if(cnt==n){
            return;
        }
        cnt++;
        System.out.println(cnt);
        print(n);
    }
}
