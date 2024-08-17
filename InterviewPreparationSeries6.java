package com.ajay.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewPreparationSeries6 {
    // Find a Ip which has Maximum number of counts
    public static void main(String[] args) {
        String[] logs = {
                "132.123.24.141 - - fvkjdfngkfd",
                "132.12.24.141 - - fvkjdfngkfd",
                "132.13.24.141 - - fvkjdfngkfd",
                "132.23.24.141 - - fvkjdfngkfd",
                "132.123.214.141 - - fvkjdfngkfd",
                "132.123.214.141 - - fvkjdfngkfd",
                "132.123.214.141 - - fvkjdfngkfd",
                "132.123.24.141 - - fvkjdfngkfd"
        };

        String maximumCount = findMaximumIP(logs);
        System.out.println("Ip with maximum count is: "+maximumCount);

        // Find Groups of Anagrams
        List<String> words = Arrays.asList("eat","tea","tan","ate","nat","bat");

        Map<String, List<String>> stringListMap = words.stream().collect(Collectors.groupingBy(word -> {
            char[] chArray = word.toCharArray();
            Arrays.sort(chArray);
            return new String(chArray);
        }));

        System.out.println(stringListMap);

        stringListMap.forEach((key,value)->{
            System.out.print(key+" : ");
            System.out.println(value);
        });
        
        // Count Number of Vowels in a Given String
        String input = "This is a sample string to count vowels";
        int vowelCount = countVowels(input);

        System.out.println("Total Vowel count is: "+vowelCount);

        //hello world
        // hello -> 5
        // world ->5

        String str1 = "Hello World";
        Map<String, Integer> collect = Arrays.stream(str1.split(" ")).collect(Collectors.toMap(word -> word, word -> word.length()));
        System.out.println(collect);

        // Compare Two String without using Built In Function
        System.out.println(compareTwoString("hello","hello"));
    }

    private static boolean compareTwoString(String str1, String str2) {
        if(str1 ==null && str2==null){
            return true;
        }
        if(str1 == null || str2 == null){
            return false;
        }

        if(str1.length() != str2.length()){
            return false;
        }
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!= str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private static int countVowels(String input) {
        Set<Character> hashSet=new HashSet<>(Arrays.asList('a','e','i','o','u'));

       return (int) input.chars().mapToObj(c->(char)c).filter(c->hashSet.contains(c))
                .count();
    }

    private static String findMaximumIP(String[] logs) {
        HashMap<String,Integer> map=new HashMap<>();

       for (String str:logs){
           String ip = str.split(" ")[0];
           map.put(ip,map.getOrDefault(ip,0)+1);
       }

        System.out.println(map);
        Map.Entry<String, Integer> stringIntegerEntry = map.entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue())).orElseGet(null);
        return stringIntegerEntry.getKey();
    }
}
