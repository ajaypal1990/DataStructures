package com.ajay.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class Thirty_30_JavaInterviewPrograms {
    public static void main(String[] args) {
        // Java program to print the fibonacci series
        // 0 1 1 2 3 5 8 11 19
        List<Integer> fibonacciSeries = fibonacciSeries1(20);
        System.out.println("Fibonacci series is: "+fibonacciSeries);

        // Print prime number till 10;
        List<Integer> primeNumbers = printPrimes(20);
        System.out.println("Prime numbers till 20 are: "+primeNumbers);

        // Swap Numbers without using temp variable;
        int a =10;
        int b = 20;
        swapTwoNumbers(a, b);

        // reverse a String without using API
        String str = "hello world";
        String reverseString = reverseString1(str);
        System.out.println("Reverse String is: "+reverseString);

        // Java program to reverse a number
        int number = 12345;
        int reverseNumber = reverseNumber1(number);
        System.out.println("Reverse Number is: "+reverseNumber);

        // Write a program to find factorial recursively
        List<Integer> factorial = findFactorial(10);
        System.out.println("Factorial till 10 are "+factorial);

        // Write a Java program to find the Perfect Number or Not
        List<Integer> listOfPerfectNumbersTill20 = findPerfectNumber(200);
        System.out.println("List of Perfect Number till 20 "+listOfPerfectNumbersTill20);

        // check given number is binary of not
        boolean res = checkGivenNumberIsBinary(10101);
        System.out.println("Given is Binary or Not: "+res);

        // Find Given Number is ArmsStrong Number or Not
        boolean checkArsStrongNumber = checkArmSTronNumber(153);
        System.out.println("153 is ArmsStrong Number : Yes or No=> "+checkArsStrongNumber);

        // Write a Java program to find common elements between two arrays
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};
        List<Integer> commonElements = findCommonElements(array1, array2);
        System.out.println("Common elements: " + commonElements);

        // Write a Program to check two Strings Are Anagram or NOT
        String str1 ="silent";
        String str2 = "listen";
        boolean checkAnagrams = areAnagrams(str1, str2);
        System.out.println("Anagram String:: "+checkAnagrams);

        // Find factors of the Number till 100
        findFactorsOfNumbers(10);

        int[] array = {5, 12, 3, 19, 45, 33, 2};
        OptionalInt thirdLargest = findSecondLargest(array);
        if (thirdLargest.isPresent()) {
            System.out.println("The third largest number is: " + thirdLargest.getAsInt());
        } else {
            System.out.println("Array doesn't have enough elements.");
        }

        //Print a number from 1 to 100 without using Loop
        int n=100;
        primeNumbers(0,n);
        System.out.println();
        // Find the Missing Number in the Array
        int[] arr2 = {1, 2, 4, 5, 6};
        int len = arr2.length+1;
        int missingNumber = findMissingNumber1(arr2,len);
        System.out.println("Missing Number is:: "+missingNumber);

        // FInd the Duplicate Numbers in Array
        int[] arr3 = {2,3,4,5,2,3,4,7,8};
        //{2,3,4}
        int duplicateArray[] = findDuplicateNumbersInArray(arr3);
        System.out.println("Duplicate Array is: "+Arrays.toString(duplicateArray));

        // Java Program to find Duplicate from String in java
        String string1 = "programming";
        Map<Character,Long> duplicateCharacters =findDuplicateCharacters1(string1);

        System.out.println(duplicateCharacters);

        // Java Program to remove duplicates from String in java
        String string2 = "programming";
        String result = removeDuplicates(string2);
        System.out.println("String after removing duplicates: " + result);
        
        // java program to find Number is Even or ODD
        List<Integer> numbers11 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partitionedMap =  findNumberEvenOrOdd(numbers11);
        List<Integer> evenList = partitionedMap.get(true);
        List<Integer> oddList = partitionedMap.get(false);
        System.out.println("Even Numbers: " + evenList);
        System.out.println("Odd Numbers: " + oddList);

        // Count the numbers of Vowels in String in java
        String vowelString = "abcdefgujkl";
        Long vowelCharactersList = countVowelString(vowelString);
        System.out.println("Total Vowels are: "+vowelCharactersList);
        
        // Implement Binary Search
        int searchElement = 25;
        int[] binaryArray = {20,10,14,35,25,86,74,14,26};
        int low =0;
        int high= binaryArray.length-1;
        
        int indexValue = binarySearch1(binaryArray,low,high,searchElement);
        if (indexValue == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + indexValue);
        }
    }

    private static int binarySearch1(int[] binaryArray, int low, int high, int searchElement) {
        Arrays.sort(binaryArray);
        System.out.println("Sorted Array is: "+Arrays.toString(binaryArray));
        while (low<high){
            int mid = low +(high - low)/2;
            if(binaryArray[mid] == searchElement){
                return mid;
            } else if (binaryArray[mid]<searchElement) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    private static Long countVowelString(String vowelString) {
        String vowel= "aeiou";
        Set<Character> characterSet = vowel.chars().mapToObj(c->(char)c)
                .collect(Collectors.toSet());

       return vowelString.chars().mapToObj(c->(char)c)
                .filter(c->characterSet.contains(c))
                .count();

    }

    private static Map<Boolean, List<Integer>> findNumberEvenOrOdd(List<Integer> number1) {

        return number1.stream().collect(Collectors.partitioningBy(i->i%2==0));
    }

    private static String removeDuplicates(String str) {
        return str.chars().mapToObj(c->(char)c)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .map(entry->String.valueOf(entry.charValue()))
                .collect(Collectors.joining());
    }

    private static Map<Character, Long> findDuplicateCharacters1(String str) {
       return str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .collect(Collectors.toMap(entry->entry.getKey(),entry->entry.getValue(),(e1,e2)->e1,LinkedHashMap::new));
    }

    private static int[] findDuplicateNumbersInArray(int[] arr3) {
        Set<Integer> duplicates=new HashSet<>();

        return Arrays.stream(arr3).filter(num->!duplicates.add(num))
                .distinct()
                .toArray();
    }

    private static int findMissingNumber1(int[] arr2, int len) {
        int expectedSum = len*(len+1)/2;

        int actualSum = Arrays.stream(arr2).sum();

        return expectedSum-actualSum;
    }

    private static void primeNumbers(int start, int end) {
        if (start > end){
            return;
        }
        System.out.print(start+" ");

        primeNumbers(start+1,end);
    }

    private static OptionalInt findSecondLargest(int[] array) {
       return Arrays.stream(array)
                .distinct()
                .sorted()
                .skip(array.length-3)
                .findFirst();
    }

    private static void findFactorsOfNumbers(int num) {
        for (int i=1;i<=num;i++){
            findfactors(i);
            System.out.println();
        }
    }

    private static void findfactors(int num) {
        for (int i=1;i<=num;i++){
            if (num%i==0){
                System.out.print(i+" ");
            }
        }
    }

    private static boolean areAnagrams(String str1, String str2) {
        str1 = str1.replace("\\s","").toLowerCase();
        str2 = str2.replace("\\s","").toLowerCase();

        if (str1.length()!=str2.length()){
            return false;
        }
        char[] chArray1 = str1.toCharArray();
        char[] chArray2 = str2.toCharArray();

        Arrays.sort(chArray1);
        Arrays.sort(chArray2);

        return Arrays.equals(chArray1,chArray2);
    }

    private static List<Integer> findCommonElements(int[] array1, int[] array2) {
        Set<Integer> integerSet=new HashSet<>();
        for (int num: array1){
            integerSet.add(num);
        }

        List<Integer> commonList=new ArrayList<>();

        for (int num: array2){
            if(integerSet.contains(num)){
                commonList.add(num);
            }
        }
        return commonList;
    }

    private static boolean checkArmSTronNumber(int number) {
        int sum=0;
        int originalNumber = number;
        int numOfDigit = String.valueOf(number).length();

        while (number>0){
            int digit = number%10;
            sum+= Math.pow(digit,numOfDigit);
            number/=10;
        }
        return sum == originalNumber;
    }

    private static boolean checkGivenNumberIsBinary(int number) {
        while (number!=0){
            int lastDigit = number%10;
            if(lastDigit!=0 && lastDigit!=1){
                return false;
            }
            number = number/10;
        }
        return true;
    }

    private static List<Integer> findPerfectNumber(int n) {

        List<Integer> perfectNumbers=new ArrayList<>();
        for (int i=1;i<=n;i++){
            if (checkPerfectNumber(i)){
                perfectNumbers.add(i);
            }
        }
        return perfectNumbers;
    }

    private static boolean checkPerfectNumber(int n) {
        int sumofDivisors=0;
        for (int i=1;i<=n/2;i++){
            if(n %i ==0){
                sumofDivisors+=i;
            }
        }
        return sumofDivisors == n;
    }

    private static List<Integer> findFactorial(int num) {
        List<Integer> list=new ArrayList<>();
        for (int i=1;i<=num;i++){
            int factorial = checkFactorial(i);
            list.add(factorial);
        }
        return list;
    }

    private static int checkFactorial(int n) {
        int fact=1;
        for (int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }

    private static int reverseNumber1(int number) {
        int revNum=0;
        int lastDigit =0;
        while (number!=0){
            lastDigit = number%10;//5
            revNum = revNum*10+lastDigit;
            number=number/10;
        }
        return revNum;
    }

    private static String reverseString1(String str) {
        return str.chars().mapToObj(c->(char)c).collect(Collectors.collectingAndThen(Collectors.toList(),list->{
            Collections.reverse(list);
            return list.stream();
        })).map(String::valueOf).collect(Collectors.joining());
    }

    private static void swapTwoNumbers(int i1, int i2) {
        System.out.println("Before Swapping A and B are: "+i1+ "::"+i2);
        i1 = i1+i2;
        i2 = i1-i2;
        i1 = i1-i2;
        System.out.println("After Swapping A and B are: "+i1+ "::"+i2);
    }

    private static List<Integer> printPrimes(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i =0 ;i<=n;i++){
            if (checkprime(i)){
                result.add(i);
            }
        }
        return result;
    }

    private static boolean checkprime(int n) {
        if(n<=1){
            return false;
        }

        for (int i =2;i<=n/2;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    private static List<Integer> fibonacciSeries1(int limit) {
        int firstNumber =0;
        int secondNumber = 1;
        List<Integer> list=new ArrayList<>();
        for (int i =0;i<=limit;i++){
            list.add(firstNumber);
            int next = firstNumber+secondNumber;
            firstNumber = secondNumber;
            secondNumber=next;
        }
        return list;
    }
}
