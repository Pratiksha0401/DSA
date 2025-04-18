package org.example.string;

public class StringBasic {


    public static void main(String[] args) {

        // creates string object in string Pool
        String s1 = "Arpan";

        // Does not create a new string object in string pool as "Arpan"
        // is already present there
        String s2 = "Arpan";

        // s3 and s1 are pointing to same string literal "Java"
        String s3 = s1;

        // Creates new object in heap and does not create new object
        // in string pool as it already present there
        String st4 = new String("Arpan");

        // Creates 2 objects: one in the heap memory and
        // the other in the string pool.
        String st5 = new String("Banerjee");

        System.out.println(s1 == s2); // prints true
        System.out.println(s1 == s3); // prints true
        System.out.println(s2 == s3); // prints true

        System.out.println(s1 == st4); // prints false
        System.out.println(st4 == st5); // prints false

    }
}


