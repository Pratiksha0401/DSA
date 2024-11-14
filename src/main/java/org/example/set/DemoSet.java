package org.example.set;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DemoSet  {
    public static void main(String[] args) {
//        List<Integer> sc = Arrays.asList(2,3,4,1,6,3,8);
//
//        List<Integer> l1 = sc.stream().map(n-> n%2).collect(Collectors.toList());
//        l1.forEach(n-> System.out.println(n));

        List<String> names = Arrays.asList("Reflection","Collection","Stream");
        var result = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result);


        List<Integer> sc = Arrays.asList(2,3,4,1,6,3,8);
        Consumer<Integer> con = n -> System.out.println(n);
        sc.forEach(con);
    }


}
