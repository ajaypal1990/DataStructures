package com.ajay.concepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPreparationSeries2 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("ajay","vijay","ram","shyam");
        List<String> list2 = Arrays.asList("vijay","karan","arjun","krishna");

        List<String> result = findDuplicatesCharacters(list1,list2);
        System.out.println("Duplicates Are :"+result);

        // convert the given list into a Map
        List<String> list3 = Arrays.asList("a","bb","ccc","dddd");
        Map<String, Long> map = list3.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        Map<String, Long> sortedMap = map.entrySet().stream().sorted(Comparator.comparing(entry->entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));
        System.out.println(sortedMap);

        //Find the Frequency of Characters in the Map
        int[] intArray4 = {1,2,3,4,1,2,2,3,3,3,4,4,5,7,6,5};

        Map<Integer,Integer> frequencyMap = findFrequencyOfCharactersInMap(intArray4);
        System.out.println("Frequency of Characters are : "+frequencyMap);
        /*
        Anagram Groups: [listen,silent,enlist]
        Anagrams Groups: [hello]
        Anagrams Groups: [world, dolrw]
         */
        // hello: {hello}
        List<String> words = Arrays.asList("listen","silent","enlist","hello","world","dolrw");
        Map<String, List<String>> stringListMap = words.stream().collect(Collectors.groupingBy(word -> {
            char[] chArray = word.toCharArray();
            Arrays.sort(chArray);
            return new String(chArray);
        }));

        // Find All pairs in an Integer Array Whose sum is equal to a given number
        int[] numbers = {2,4,3,5,7,8,9};
        int targetSum = 7;

        Set<List<Integer>> set= pairsSum(numbers,targetSum);
        System.out.println("Pairs of sum are: "+set);

        // Reverse a String using Java 8
        String str = "ajaypal";
        String reverseStr = str.chars().mapToObj(c->(char)c).collect(Collectors.collectingAndThen(Collectors.toList(), list->{
            Collections.reverse(list);
            return list.stream();
        })).map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println("Reverse String is: "+reverseStr);

        String str2 = "hello ajay how are you";
        String reverseString = Arrays.stream(str2.split(" "))
                .map(word->new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(reverseString);

        // Find longest sub String without repetation of characters
        String str5 = "abcdabcde";
        findLongestSubString(str5);

        String compression = findCompression("aaabbbcc");
        System.out.println(compression);

        System.out.println(printFirstLetter("Learn With Ajay"));

        System.out.println(isrotatedVersion("abcd","bcda"));

        // Print SubString
        String str6 ="abcd";
        for(int i=0;i<str6.length();i++){
            for (int j=i+1;j<=str6.length();j++){
                System.out.println(str6.substring(i,j));
            }
        }
        //Square of numbers in Array
        int[] array2={-6,-1,2,4,5,7};
        Integer[] squarArray = Arrays.stream(array2)
                .boxed()
                .map(i -> i * i)
                .toArray(Integer[]::new);

        System.out.println("Square of Numbers in Array is "+ Arrays.toString(squarArray));

        // Write a Program in java to find next greater element in Array ?
        int[] arr5= {10,11,5,4,7};

        findNextGreaterElement(arr5);

        int[] arr6 = {1,2,3,4,5,6};

        Integer[] reverseArray = Arrays.stream(arr6)
                .boxed().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                })).toArray(Integer[]::new);

        System.out.println("Reverse Array is: "+Arrays.toString(reverseArray));

        String[] strArray = {"A", "B", "C", "D", "E"};

        String[] reverseArrayStr = Arrays.stream(strArray)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                })).toArray(String[]::new);

        System.out.println("Reverse Array is: "+Arrays.toString(reverseArrayStr));

        String[] reverseArray1 = IntStream.rangeClosed(1, strArray.length)
                .mapToObj(i -> strArray[strArray.length - i])
                .toArray(String[]::new);

        System.out.println(reverseArray1);

    }

    private static void findNextGreaterElement(int[] arr5) {
        int len= arr5.length;

        for (int i=0;i<len;i++){
            int next = -1;
            for (int j = i+1;j<len;j++){
                if(arr5[i]<arr5[j]){
                    next=arr5[j];
                    break;
                }
            }
            System.out.println(arr5[i]+":"+next);
        }
    }

    private static boolean isrotatedVersion(String str1, String str2) {
        if(str1 == null || str2 == null){
            return false;
        } else if (str1.length() != str2.length()) {
            return false;
        }else {
            String concatenated =str1+str1;
            return concatenated.contains(str2);

        }
    }

    private static String printFirstLetter(String str) {
        return Arrays.stream(str.split(" "))
                .map(word->String.valueOf(word.charAt(0)))
                .collect(Collectors.joining());
    }

    private static String findCompression(String str) {
        Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        return collect.entrySet().stream().map(entry->entry.getKey()+""+entry.getValue())
                .collect(Collectors.joining());
    }

    private static void findLongestSubString(String str5) {
        HashSet<Character> hashSet=new HashSet<>();
        StringBuilder longestTillNow =new StringBuilder();
        StringBuilder longestOverall =new StringBuilder();
        char[] chArray =str5.toCharArray();
        int len = chArray.length;//6
        for(int i=0;i<len;i++){
            if(hashSet.contains(chArray[i])){
                hashSet.clear();
                hashSet.add(chArray[i]);

                longestTillNow=new StringBuilder();
                longestTillNow.append(chArray[i]);
            }else {
                hashSet.add(chArray[i]);
                longestTillNow.append(chArray[i]);
            }
            if(longestTillNow.length()>longestOverall.length()){
                longestOverall=new StringBuilder(longestTillNow);
            }

        }
        System.out.println("Longest String is: "+longestOverall);
    }

    private static Set<List<Integer>> pairsSum(int[] numbers, int targetSum) {
        Set<List<Integer>> set=new HashSet<>();

        for(int i=0;i<numbers.length;i++){
            for (int j=i+1;j< numbers.length;j++){
                if(numbers[i]+numbers[j]==targetSum){
                    List<Integer> list=new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    set.add(list);
                }
            }
        }
        return set;
    }

    private static Map<Integer, Integer> findFrequencyOfCharactersInMap(int[] intArray4) {

        return Arrays.stream(intArray4).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
    }

    private static List<String> findDuplicatesCharacters(List<String> list1, List<String> list2) {

        Stream<Character> characterStream = Stream.concat(list1.stream(), list2.stream()).flatMap(s -> s.chars().mapToObj(c -> (char) c));

        return characterStream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1)
                .map(entry->String.valueOf(entry.getKey()))
                .collect(Collectors.toList());
    }
}
