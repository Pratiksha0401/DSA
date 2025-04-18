package org.example.string;
import  java.util.*;

public class Strings {

    public static void main(String[] args) {

        // Creating a new StringBuffer
        StringBuffer str
                = new StringBuffer();
        System.out.println(str.capacity());
        str.append("Hello");
        str.append(" World!");

        System.out.println(str);
        System.out.println(str.length());


        // Creating a new StringBuffer
        StringBuilder sb
                = new StringBuilder("Hey ");
        System.out.println(sb.capacity()); // 16 default + 3 of hey
        sb.append("Hello");
        sb.append(" World!");

        System.out.println(sb);
        System.out.println(sb.length());

        System.out.println("***********************************");

        // Example with Constructor 1
        System.out.println("Using StringTokenizer Constructor 1: ");

        // Using StringTokenizer to split the string into
        // tokens using space (" ") as the delimiter
        StringTokenizer st1 = new StringTokenizer(
                "Geeks fo Geeks", " ");

        // Iterate through tokens while
        // there are more tokens available
        while (st1.hasMoreTokens())

            // Getting and printing the next token
            System.out.println(st1.nextToken());

        // Example with Constructor 2
        System.out.println("Using StringTokenizer Constructor 2: ");

        // Using StringTokenizer to split the string
        // using ":" as the delimiter
        StringTokenizer st2 = new StringTokenizer(
                "java : Code : String : Tokenizer", " :");

        // Iterate through tokens and print them
        while (st2.hasMoreTokens())
            System.out.println(st2.nextToken());

        // Example with Constructor 3
        System.out.println("Using StringTokenizer Constructor 3: ");

        // Using StringTokenizer with returnDelims = true
        // to include delimiters as tokens
        StringTokenizer st3 = new StringTokenizer(
                "java : Code", " :", true);

        // Iterate through tokens (including delimiters)
        // and print them
        while (st3.hasMoreTokens())
            System.out.println(st3.nextToken());

    }
}

/* output
16
Hello World!
12
20
Hey Hello World!
16
***********************************
Using StringTokenizer Constructor 1:
Geeks
fo
Geeks
Using StringTokenizer Constructor 2:
java
Code
String
Tokenizer
Using StringTokenizer Constructor 3:
java

:

Code
*/


