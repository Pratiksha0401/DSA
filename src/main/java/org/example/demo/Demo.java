package org.example.demo;

import java.sql.Array;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Calculator c = new Laptop();
        System.out.println("add  "+c);
        c.show1();

        Laptop l = new Laptop();

    }
}

class Calculator{
    private int a;
    private String s;

    public void show1(){
        System.out.println("In a -----------"+s+"---------");
    }
}

class  Laptop extends Calculator{
    public void show2(){
        System.out.println("In b ");
    }
}
