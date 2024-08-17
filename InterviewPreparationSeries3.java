package com.ajay.concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPreparationSeries3 {
    public static void main(String[] args) {
        int[] intArray ={2,4,0,1,0,8,6,0,3,7};

        int[] results = moveZerosToEnd(intArray);
        System.out.println(" moving zeros at end final array is: "+Arrays.toString(results));

        // Check String is Palindrome
        String testString = "A man, a plan, a canal, Panama!";
        System.out.println("String is Palindrome or Not "+checkPalindrome(testString));

        // Remove even numbers
        int[] intArray1 = {2,4,1,8,6,3,7};
        int[] result = removeEvenNumbers(intArray1);

        System.out.println("Array after removing Even Numbers: "+Arrays.toString(result));

        // Convert A list of Integers to List of thier Squares
        List<Integer> numbers= Arrays.asList(1,2,3,4,5);
        List<Integer> squares = numbers.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println(squares);

        List<List<String>> listList =Arrays.asList(Arrays.asList("a","b"),Arrays.asList("c","d"),Arrays.asList("e","f"));
        List<String> stringList = listList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(stringList);

        // Map a String with its Starting Character
        List<String> names = Arrays.asList("Alice", "bob", "Charlie", "David", "Anna");
        Map<Character, List<String>> collect = names.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(collect);

        // Reverse a Word in the String
        String str = "Hello Ajay How are you";
        String strReversed = Arrays.stream(str.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(), list->{
            Collections.reverse(list);
            return list.stream();
        })).collect(Collectors.joining(" "));

        System.out.println(strReversed);

        String reverseByOrder = Arrays.stream(str.split(" "))
                .map(word-> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println(reverseByOrder);

        //
    }

    private static int[] removeEvenNumbers(int[] intArray) {
       return Arrays.stream(intArray).filter(i->i%2!=0).toArray();
    }

    private static boolean checkPalindrome(String testString) {
        testString=testString.toLowerCase();
        testString=testString.replaceAll("[^a-z0-9]","");

        int left =0;
        int right = testString.length()-1;

        while (left<right){
            if(testString.charAt(left)!=testString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static int[] moveZerosToEnd(int[] intArray) {
        int[] nonZeros = Arrays.stream(intArray).filter(i->i!=0).toArray();

        int[] zeros = Arrays.stream(intArray).filter(i->i==0).toArray();

        return IntStream.concat(IntStream.of(nonZeros),IntStream.of(zeros)).toArray();
    }
}
