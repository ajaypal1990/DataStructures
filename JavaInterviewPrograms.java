package com.ajay.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaInterviewPrograms {
    public static void main(String[] args) {
        // print the fibonnaci of Numbers in a List
        List<Integer> result = fibonnaci(10);
        System.out.println(result);
        System.out.println();
        // Fibonacci Series Using Java 8
      Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
              .limit(10)
              .map(t->t[0])
              .forEach(t-> System.out.print(t+" "));
        System.out.println();
      // Counts Word in Java 8
        String str1= "Hello Ajay How are you";
        int count = Arrays.stream(str1.split(" "))
                .toArray().length;
        System.out.println("Total words count are: "+count);

        // Calculate the Median of the Array in Java
        int[] intArray={10,20,30,40,50,60};
        double medianValue =  findMedian(intArray);
        System.out.println("The median is: " + medianValue);

        // Print Alternate Number in the Array

        int[] intArray1={1,2,3,4,5,6,7,8,9,10};
        IntStream.range(0,intArray1.length).filter(i->i%2==0)
                .map(i->intArray1[i])
                .forEach(num-> System.out.print(num+" "));

        // Check Number is Palindrome or NOT
        int number = 12321;

        System.out.println("Check Palindrome: "+isPalindrome(number));

        boolean checkAnagram = isAnagram("silent","listen");

        System.out.println("String are: Anagram True or False: "+ checkAnagram);

    }

    private static boolean isAnagram(String str1, String str2) {
        if(str1.length() !=str2.length()){
            return false;
        }

        str1= str1.toLowerCase();
        str2=str2.toLowerCase();

        char[] ch1Array = str1.toCharArray();
        char[] ch2Array = str2.toCharArray();
        Arrays.sort(ch1Array);
        Arrays.sort(ch2Array);

        return Arrays.equals(ch1Array,ch2Array);
    }

    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        String reverse = IntStream.range(0,str.length())
                .mapToObj(i->str.charAt(str.length()-1-i))
                .collect(StringBuilder::new,StringBuilder::append,StringBuilder::append)
                .toString();
        return reverse.equalsIgnoreCase(str);

    }

    private static double findMedian(int[] intArray) {
        Arrays.sort(intArray);
        int len = intArray.length;
        if(len %2==1){
           return intArray[len/2];
        }else {
            return (intArray[len/2-1]+intArray[len/2])/2.0;
        }
    }

    private static List<Integer> fibonnaci(int n) {
        List<Integer> list=new ArrayList<>();
        int firstNumber =0;
        int secondNumber =1;

        for(int i=0;i<=n;i++){
           // System.out.print(firstNumber+" ");
            list.add(firstNumber);
            int nextNumber = firstNumber+secondNumber;
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }

        return list;
    }
}
