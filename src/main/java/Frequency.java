import java.util.*;
import java.util.stream.Collectors;

public class Frequency {

    public static void main(String[] args) {
//        System.out.println("Try programiz.pro");
//        // write a java program to count the occurrences of each character in string
//        String str = "Hello";
//        char [] arr = str.toCharArray();
//        Map<Character, Integer> hm = new HashMap<>();
//
//        for(int i=0;i<arr.length;i++){
//            if(hm.containsKey(arr[i])){
//                int count = hm.get(arr[i]);
//                hm.put(arr[i],++count);
//            }else{
//                hm.put(arr[i],1);
//            }
//        }
//
//        System.out.println(hm);

        List<Integer> li = Arrays.asList(1,2,3,1,2,4,5);
        Set<Integer> s = li.stream().distinct().collect(Collectors.toSet());
        System.out.println(s);
    }
}
