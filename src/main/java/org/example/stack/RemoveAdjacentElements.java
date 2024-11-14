package org.example.stack;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAdjacentElements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(removeAdjacentElements(str));
    }

    private static String removeAdjacentElements(String str) {
        Stack<Character> sc = new Stack<>();
        for (int i=0;i<str.length();i++){
            if(sc.size()==0){
                sc.push(str.charAt(i));
            }
            if(sc.peek()==str.charAt(i)){
                sc.pop();
            }else{
                sc.push(str.charAt(i));
            }
        }
        char [] arr = new char[sc.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i] = sc.pop();
        }
        System.out.println(arr.length);

        return String.valueOf(arr);
    }
}
