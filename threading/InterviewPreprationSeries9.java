package com.ajay.concepts.threading;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPreprationSeries9 {
    public static void main(String[] args) {
        String str = "()[]{}";
        boolean result = checkValidparathesis(str);
        System.out.println("String is Valid or NOT ? :"+result);

        // Find the Number of Occurances of Character in Java
        char ch= 'd';
        String str1 ="hello world";

        int len = findNumberOccurances(str1,ch);
        System.out.println(ch+ " repeats "+len+" times ");

        // Stock buy and Sell
        int arr[] = {7, 1, 5, 3, 6, 4};
        int profit = stockBuySell(arr);

        System.out.println("Highest Profit for selling the stocks is: "+profit);

        // majority elements in the Array
       // {10,20,10,10,40}
        int arr1[] = {10,20,10,10,40};
        Map<Integer, Long> majorityElement = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Integer, Long> integerLongEntry1 = majorityElement.entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > arr1.length / 2)
                .findFirst().orElse(null);
        if (integerLongEntry1 != null) {
            System.out.println("Majority Element is: " + integerLongEntry1.getKey() +
                    " and it is repeating: " + integerLongEntry1.getValue() + " times");
        } else {
            System.out.println("No majority element found.");
        }

        // Find the repeating elements in java
        int[] arr3 = {4,2,3,5,1,2,4};

       List<Integer> repeatingList =  findRepeatingCharacter(arr3);
        System.out.println("repeating elements are: "+repeatingList);

        // Print Duplicate Elements in the Array
        int[] arr4 = {10,20,20,40,40};

        List<Integer> duplicateElementsList  = Arrays.stream(arr4).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateElementsList);

        // Binary Search Implementation
        int[] arr5 = {20,10,30,50,70,60};
        int searchValue = 200;
        int low =0;
        int high = arr5.length-1;
        int serachResult = findBinarySearch(arr5,low,high,searchValue);
        System.out.println("Value find at index "+serachResult);

        // Find the Maximum Difference between elements in ARray
        int[] arr6 = {10,20,2,90,40};
       int differenc =  findMaximumDifferenceInArray(arr6);
        System.out.println("Difference is: "+differenc);

        // Moves Zeros to end of the Array
        int[] arr7 = {10,0,0,20,40,50,60};
        System.out.println(Arrays.toString(moveZerosToEndOfArray(arr7)));

        // Moves all non negative elements to start of the array
        int[] arr8 = {-1,-20,-8,30,40,50,-10};

        System.out.println(Arrays.toString(moveNegativeStartofArray(arr8)));
        // Rotate the Array by One Position left
        int[] arr9 = {10, 20, 30, 40, 50};
        int[] rotatedArray = rotateArrayLeft(arr9);
        System.out.println("Rotated Array is: "+Arrays.toString(rotatedArray));

        //  insert the element at the specific position
        int[] arr10 = {10, 20, 30, 40, 50};
        int element = 25; // Element to insert
        int position = 2; // Position to insert (indexing starts from 0)
        int[] result1 = insertElement(arr10, element, position);
        System.out.println("Array of Insert Element is: "+Arrays.toString(result1));

        // Reverse a Array Elements
        int[] arr11 = {10,20,30,40};

        Integer[] reverseArray = reverseArrayElements(arr11);
        System.out.println("Reversed Array is: "+Arrays.toString(reverseArray));

        //Paranthesis Checker
        boolean checkStr = checkParanthesis("()");
        System.out.println("Parathensis check: "+checkStr);
    }

    private static boolean checkParanthesis(String str) {
        Stack<Character> stack=new Stack<>();
        char[] chArray = str.toCharArray();
        for (char c: chArray){
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }else {
                    if (str.isEmpty()){
                        return false;
                    }
                    char top = stack.peek();
                    if((c=='}' && top=='{')|| (c==']' && top=='[')||(c==')' && top=='(')){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
        }
        return stack.isEmpty();
    }

    private static Integer[] reverseArrayElements(int[] arr10) {
       return Arrays.stream(arr10).boxed().collect(Collectors.collectingAndThen(Collectors.toList(),list->{
            Collections.reverse(list);
            return list.stream();
        })).toArray(Integer[]::new);
    }

    private static int[] insertElement(int[] arr10, int element, int position) {
        if(position<0||position>arr10.length){

        }
        int[] newArr =new int[arr10.length+1];
        IntStream.range(0,position)
                .forEach(i->newArr[i]=arr10[i]);

        newArr[position]=element;

        IntStream.range(position,arr10.length)
                .forEach(i->newArr[i+1]=arr10[i]);
        return newArr;
    }

    private static int[] rotateArrayLeft(int[] arr9) {
        if(arr9.length==0){
            return arr9;
        }
        int[] rotatePart = IntStream.range(1,arr9.length)
                .map(i-> arr9[i])
                .toArray();
        return IntStream.concat(IntStream.of(rotatePart),IntStream.of(arr9[0])).toArray();
    }

    private static int[] moveNegativeStartofArray(int[] arr8) {
        int[] nonNegative = Arrays.stream(arr8).filter(i->i>=0).toArray();
        int[] negatives = Arrays.stream(arr8).filter(i->i<0).toArray();

       return IntStream.concat(IntStream.of(negatives),IntStream.of(nonNegative)).toArray();
    }

    private static int[] moveZerosToEndOfArray(int[] arr7) {
        int[] zeros = Arrays.stream(arr7).filter(i->i==0).toArray();
        int[] nonZeros = Arrays.stream(arr7).filter(i->i!=0).toArray();

       return IntStream.concat(IntStream.of(nonZeros),IntStream.of(zeros)).toArray();
    }

    private static int findMaximumDifferenceInArray(int[] arr6) {
        Integer min = Arrays.stream(arr6).min().getAsInt();
        Integer max = Arrays.stream(arr6).max().getAsInt();

        return max-min;
    }

    private static int findBinarySearch(int[] arr5, int low, int high, int searchValue) {
        Arrays.sort(arr5);
        while (low<=high){
            int mid = (low+high)/2;
            if(arr5[mid]==searchValue){
                return mid;
            } else if (searchValue<arr5[mid]) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
return -1;
    }

    private static List<Integer> findRepeatingCharacter(int[] arr3) {
        Map<Integer, Long> map = Arrays.stream(arr3).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return map.entrySet().stream().filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int stockBuySell(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i =0;i<arr.length;i++){
            int currentValue = arr[i];
            if(currentValue<min){
                min = currentValue;
            }
            int cc= currentValue-min;
            if(cc > max){
                max = cc;
            }
        }

        return max;
    }

    private static int findNumberOccurances(String str, char ch) {

        int count =0;
        for (int i =0;i<str.length();i++){
            if(str.charAt(i) == ch){
                count++;
            }
        }

        return count;
    }

    private static boolean checkValidparathesis(String str) {
        Stack<Character> stack=new Stack<>();

        char[] chArray = str.toCharArray();

        for(char c:chArray){
            if(c == '('|| c== '{'|| c=='['){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.peek();
                if((c == ')' && top == '(')||
                   (c == '}' && top == '{')||
                           (c == ']' && top == '[')){
                    stack.pop();

                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
