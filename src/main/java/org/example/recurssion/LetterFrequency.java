package org.example.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterFrequency {
    public static void main(String[] args) {
        String s = "Hello World";
        char [] arr = s.trim().toCharArray();
        List<Character> li= s.chars().mapToObj(c->(char)c).collect(Collectors.toList());
        Map<Character,Long>  hm = li.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        System.out.println(hm);
    }
}
