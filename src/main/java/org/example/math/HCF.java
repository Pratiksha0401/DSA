package org.example.math;

import java.util.Scanner;

public class HCF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int HCF = 0;
        for(int i=1;i<=n1;i++){
            if(n1%i==0 && n2%i==0){
                HCF=i;
            }
        }
        System.out.println(HCF);
    }
}
