package org.example.string;

public class StringAdvanced {

    public static void main(String[] args) {

        String s1 = new String("Java");

        String s2 = s1;
        System.out.println(s2 == s1); // true

        String s3 = "Java";

        System.out.println(s3 == s1); // false
        System.out.println(s3 == s2); // false

        String s4 = "Program";

        String s5 = s4;

        String s6 = new String(s5);

        System.out.println(s5 == s4); // true
        System.out.println(s6 == s5); // false

        s1 = "Python";
        System.out.println(s2 == s1); // false

        s5.concat("JavaScript");
        System.out.println(s6 == s5); // false

    }
}

