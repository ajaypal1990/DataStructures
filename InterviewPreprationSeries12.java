package com.ajay.concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InterviewPreprationSeries12 {
    public static void main(String[] args) {
        // Reverse the words in the String
        String string1= "Welcome to Java World";
        String reverseByWord = reverseTheWord(string1);
        System.out.println("Reverse String is : "+reverseByWord);

        // Write a Java Program to print Multiplication Table of Given Number;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Number");
        int n = scanner.nextInt();

        printTable(n);


    }

    private static void printTable(int n) {
        if (n<=1){
            return;
        }
        for (int i =1;i<=10;i++){
            System.out.println(n+"*"+i+": "+(i*n));
        }
    }

    private static String reverseTheWord(String str) {
        return Arrays.stream(str.split(" "))
                .collect(Collectors.collectingAndThen(Collectors.toList(),list->{
                    Collections.reverse(list);
                    return list.stream();
                }))
                .collect(Collectors.joining(" "));
    }
}
