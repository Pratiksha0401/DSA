package org.example.string;

import java.util.Scanner;

public class InsertDifferenceBetw {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter string");
        String str = scn.nextLine();


        String ans = "";
        for(int i=0;i<str.length()-1;i++){
            char a = str.charAt(i);
            ans = ans+a;
            int temp = str.charAt(i+1) - str.charAt(i);
            ans = ans + temp;
        }

        ans = ans + str.charAt(str.length()-1);

        System.out.println(ans);
    }
}
