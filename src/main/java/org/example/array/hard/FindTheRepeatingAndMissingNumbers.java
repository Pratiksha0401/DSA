package org.example.array.hard;

public class FindTheRepeatingAndMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,1,1};
        final int[] ints = bruteForce(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        int[] arr1 = {2,4,3,5,2,1};
        final int[] int1 = better(arr1);
        for (int anInt : int1) {
            System.out.println(anInt);
        }


    }

    public static int[] bruteForce(int[] arr){
        int repeating = -1, missing=-1;
        for (int i = 1; i <= arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==i)
                    count++;
            }
            if(count==2) repeating=i;
            else if(count==0) missing=i;

            if(repeating!=-1 && missing!=-1) break;;
        }
        return new int[]{repeating,missing};
    }

    public static int[] better(int[] arr){
        int repeating = -1, missing=-1;
        int[] hash = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        int count = 0;
        for (int j = 1; j < hash.length; j++) {
            if(hash[j]==2) repeating=j;
            else if (hash[j]==0) missing=j;
            if(repeating!=-1 && missing!=-1) break;;
        }
        return new int[]{repeating,missing};
    }
}
