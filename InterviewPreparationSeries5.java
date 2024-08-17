package com.ajay.concepts;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InterviewPreparationSeries5 {
    public static void main(String[] args) {
        // Counts Words in String
        String str = "Hello Ajay Pal";
        long count = Arrays.stream(str.split(" "))
                .filter(word->!word.isEmpty()).count();

        System.out.println("Count is: "+count);
        // Print Alternate Elements in java
        int[] intArray = {1,2,3,4,5,6,7,8,9,10};

        IntStream.range(0, intArray.length).filter(n->n%2==0)
                .mapToObj(n-> intArray[n])
                .forEach(System.out::println);
    }
}
