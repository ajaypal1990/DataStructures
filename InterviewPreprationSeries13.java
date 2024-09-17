package com.ajay.concepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewPreprationSeries13 {
    public static void main(String[] args) {
        String str1 ="sandeep";
        String str2 ="sandeep";
        
        boolean compareString = compareString(str1,str2);
        System.out.println(compareString);

        int[] array = {1, 2, 3, 4, 5};
        int elementToRemove = 3;

        int[] newArray = removeElement(array, elementToRemove);
        System.out.println("new array is: "+Arrays.toString(newArray));

        //0 1 2 3 5 8 13 21
        int limit =10;
        List<Integer> intList = fibonacciSeries(limit);
        System.out.println(" Fibonacci Series is: "+intList);

        // First Non repeated character from string
        String string1 = "aabbdef";

        Character nonRepeatedCharacter = firstNonRepeatedCharacter(string1);
        System.out.println("First Non Repeated Character is : "+ nonRepeatedCharacter);

        // Wap to find the number of words in a sentence and the corresponding character
        // "Hello World"
        // Hello -> 5
        // World -> 5
        String string2 ="hello world";
        Map<String, Integer> map = Arrays.stream(string2.split(" "))
                .collect(Collectors.toMap(word -> word, word -> word.length()));

        System.out.println(map);

        int ascValue = findAscValue('a');
        System.out.println("Asc Value is : "+ascValue);

        // Find the missing number in the integer array of 1 to 100;
        int[] intArray={1,2,3,4,5,6,8};
        int findMissingNumber = findMissingNumber(intArray);
        System.out.println("Missing Number is : "+findMissingNumber);

        // Find the first non repeating element in array of integers
        int[] intArray1={1,2,3,1,5};
        int firstNonRepeatingElement = findFirstNonRepeatingElement(intArray1);
        System.out.println("First Non repeating element is: "+firstNonRepeatingElement);

        int[] intArr1={1,2,3,4,5};
        int[] intArr2={1,2,3,4,5};
        // compare two arrays
       boolean compareArrayResult =  compareTwoArray(intArr1,intArr2);
        System.out.println("Compare Two Array are Equals: "+compareArrayResult);

        int[] arrayDuplicate = {1, 2, 3, 4, 5, 2, 3, 6};

        Set<Integer> duplicates = findDuplicates(arrayDuplicate);
        System.out.println("Elements which are duplicate is Array are: "+duplicates);

        // Find the intersection of two Array
        int[] array11 = {1, 2, 3, 4, 5};
        int[] array22 = {3, 4, 5, 6, 7};

        List<Integer> intersectionArray = findIntersectionArray(array11,array22);
        System.out.println("Common elements are: "+intersectionArray);

        Object[] arr11 = {"Hello", 123, "World", 456.78, "Java", 999, 10};
        countStringsAndNumbers(arr11);

        // Merge Two Arrays
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        int[] mergedArray = mergeArray(arr1,arr2);
        System.out.println("Merged Array is: "+Arrays.toString(mergedArray));

        String[] arrStr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> stringListMap = Arrays.stream(arrStr).collect(Collectors.groupingBy(word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }));

        System.out.println(stringListMap);

        //Find the Third largest number in the Array
        int[] arr4 = {2, 4, 1, 5, 3, 6};
        int n = 3;
        int nthLargestNumber = findNthLargestNumber(arr4,n);
        System.out.println("Nth largest number is :"+nthLargestNumber);

        // Find the Largest number that does not have any duplicates in the array
        int[] arr5 = {4, 3, 2, 7, 11 , 11 ,8, 3, 4, 8};

        int largestAmongUniqueNumber = findLargestAmongUniqueNumber(arr5);
        System.out.println("Largest among unique Number is: "+largestAmongUniqueNumber);
    }

    private static int findLargestAmongUniqueNumber(int[] arr5) {
        return Arrays.stream(arr5).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow();

    }

    private static int findNthLargestNumber(int[] arr4, int n) {
       return Arrays.stream(arr4).boxed().sorted(Comparator.reverseOrder())
                .skip(n-1)
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).toArray();
    }

    private static void countStringsAndNumbers(Object[] array) {
        int stringCount = 0;
        int numberCount = 0;

        for (int i=0;i<array.length;i++){
            if(array[i] instanceof String){
                stringCount++;
            } else if (array[i] instanceof Number) {
                numberCount++;
            }
        }
        System.out.println("String count are: "+stringCount);
        System.out.println("Number count are: "+numberCount);

    }

    private static List<Integer> findIntersectionArray(int[] array11, int[] array22) {
        List<Integer> result=new ArrayList<>();
        int i=0;
        int j=0;
        while (i< array11.length && j < array22.length){
            if(array11[i]<array22[j]){
                i++;
            } else if (array11[i]>array22[j]) {
                j++;
            }else {
                result.add(array11[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    private static Set<Integer> findDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();

        return Arrays.stream(array)
                .filter(i->!set.add(i))
                .boxed().collect(Collectors.toSet());
    }

    private static boolean compareTwoArray(int[] intArr1, int[] intArr2) {
        if(intArr1.length!=intArr2.length){
            return false;
        }

        for (int i =0;i<intArr1.length;i++){
            if (intArr1[i]!=intArr2[i]){
                return false;
            }
        }
        return true;
    }

    private static int findFirstNonRepeatingElement(int[] intArray1) {
       return Arrays.stream(intArray1).boxed().collect(Collectors.groupingBy(i->i,Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    private static int findMissingNumber(int[] intArray) {
        int n = intArray.length+1;
        int expectedSum = n*(n+1)/2;

        int actualSum = Arrays.stream(intArray).sum();
        return expectedSum-actualSum;
    }

    private static int findAscValue(char a) {
        int ascValue = a;
        return ascValue;

    }

    private static Character firstNonRepeatedCharacter(String string1) {
        return string1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    private static List<Integer> fibonacciSeries(int limit) {
        int firstNumber = 0;
        int secondNumber =1 ;
        List<Integer> fibonacciList =new ArrayList<>();
        for (int i =1;i<limit;i++){
            System.out.println(firstNumber);
            fibonacciList.add(firstNumber);

            int next = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = next;
        }

        return fibonacciList;
    }

    private static int[] removeElement(int[] array, int elementToRemove) {
        return Arrays.stream(array).filter(i->i!=elementToRemove).toArray();
    }

    private static boolean compareString(String str1, String str2) {
        if(str1.isEmpty() || str2.isEmpty()){
            return false;
        }

        for (int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return false;
            }
        }
    return true;
    }
}
