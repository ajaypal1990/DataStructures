package com.ajay.concepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
