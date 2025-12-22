package org.example.garbageCollector;

import java.util.*;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

class Test{
    final int n;

    Test(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }


}

public class TestingFinal {
    public static void main(String[] args) {
        Test t = new Test(4);
        System.out.println(t.getN());


        List<String> list = Arrays.asList("add", "data", "domains", "insect", "ant");

        List<String> sortedList = list.stream()
                .sorted(
                        Comparator.comparingInt(String::length).reversed() // sort by length DESC
                                .thenComparing(Comparator.reverseOrder()) // then alphabetically DESC
                )
                .collect(Collectors.toList());

        System.out.println(sortedList);



        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // First: sort by length descending
                int lenCompare = Integer.compare(s2.length(), s1.length());
                if (lenCompare != 0) {
                    return lenCompare;
                }
                // Then: sort reverse alphabetically
                return s2.compareTo(s1);
            }
        });

        System.out.println(list);


    }
}
