package com.ajay.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewPreprationSeries14 {
    public static void main(String[] args) {
        String original = "HelloWorld";
        System.out.println("Original String: " + original);
        String reversed = reverseString(original);
        System.out.println("Reversed String: " + reversed);

        // reverse an Array
        int[] arr ={1,2,3,4,5,6};
        Integer[] reverseArray = reverseArray1(arr);
        System.out.println(Arrays.toString(reverseArray));

        // Sort Map By Value
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Apple", 50);
        unsortedMap.put("Banana", 30);
        unsortedMap.put("Mango", 70);
        unsortedMap.put("Orange", 20);

        Map<String, Integer> sortedMap =unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));
        System.out.println(sortedMap);
    }

    private static Integer[] reverseArray1(int[] arr) {

        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list->{
                    Collections.reverse(list);
                    return list.stream();
                })).toArray(Integer[]::new);
    }

    private static String reverseString(String str) {
        char[] chArray = str.toCharArray();
        int start =0;
        int end = chArray.length-1;

        while (start<end){
            char temp = chArray[start];
            chArray[start]=chArray[end];
            chArray[end]=temp;

            start++;
            end--;
        }
        return new String(chArray);

    }
}
