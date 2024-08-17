package com.ajay.concepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewPreprationSeries1 {

    public static void main(String[] args) {
        // Find the minimum value
        int[] intArray1={5,9,3,15,1,2,0,-8};

        Optional<Integer> minimumValue = Arrays.stream(intArray1).boxed().sorted().findFirst();
        minimumValue.ifPresent(System.out::println);

        // Find the Missing Number
        int[] intArray2 = {2,4,1,8,6,3,7};
        System.out.println("Missing Number is:"+findMissingNumber(intArray2));

        // Find the second max number in the Array
        int[] intArray3={13,34,2,34,33,1};
        Optional<Integer> first = Arrays.stream(intArray3).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Second max number is : "+first.get());

        //Convert List into String Ajay,Vijay
        List<String> list=Arrays.asList("Ajay","Vijay");
        String strJoin = list.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(strJoin);
    }

    private static int findMissingNumber(int[] intArray2) {
        int n = intArray2.length+1;
        int expectedSum = n*(n+1)/2;
        int actualSum = IntStream.of(intArray2).sum();
        return expectedSum-actualSum;
    }

}
