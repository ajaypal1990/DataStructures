package com.ajay.concepts.threading;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewPreprationSeries10 {
    public static void main(String[] args) {
        // Print only Even Length word
        String str = "Hell World ajay anshu rashmi jiya";
        printEvenLengthString(str);

        // Find the Differance between two dates
        LocalDate l1= LocalDate.of(1990,8,05);

        LocalDate l2 = LocalDate.of(2024,9,05);

        Period difference = Period.between(l1,l2);

        // Get the difference in years, months, and days
        int years = difference.getYears();
        int months = difference.getMonths();
        int days = difference.getDays();

        System.out.println("Difference: " + years + " years, " + months + " months, and " + days + " days.");

        // WAP to print the elemnts in even position
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};

        printAtEvenPositions(arr1);

        // Find the Sum of Digit of Number
        // 123 = 1+2+3; = 6
        // 1234 = 1+2+3+4 = 10

        int sumDigit = sumOfNumber(123);
        System.out.println(sumDigit);

       int sumofFirstlastDigit = sumofFirstandLastDigit(1234);
        System.out.println("Sum of First and Last Digit is : "+sumofFirstlastDigit);

        // Check Given number is Perfect square or Not
        boolean checkSquare = checkPerfectSquare(23);
        System.out.println("Given Number is Perfect Square or Not :: "+checkSquare);

         // Reverse a Digit
        int reversedigit = reverseDigit(12345);
        System.out.println("reverse digit is: "+reversedigit);

        // Check the given year is a Leap Year or NOT
        boolean checkLeapyear = checkLeapYear(2024);
        System.out.println("Given Year is Leap Year or NOT: "+checkLeapyear);

        // check Given Number is Prime or NOT
        int N = 20;  // Find all primes till this number
        List<Integer> primeNumbers = getPrimesUpToN(N);
        System.out.println("Prime numbers up to " + N + ": " + primeNumbers);

        //Return a List of Even Number upto N
        int number1 = 10;
        List<Integer> evenNumbers = abstractEvenNumber(number1);
        System.out.println("Even Numbers till "+number1+" are "+evenNumbers);

        List<Integer> naturalNumbers =  printNNaturalNumbers(number1);

        System.out.println("N Natural numbers upto "+number1+" are "+naturalNumbers);

        // Find the First Duplicate occurance number in the array
        int[] arr2={1,2,3,2,4,5,6,7};
       int firstDuplicateNumber =  firstDuplicateOccuranceInArray(arr2);

        System.out.println("First Duplicate Value is "+firstDuplicateNumber);
        // check elements are Present in atleast two array
        int[] arr4 = {1, 2, 3, 4, 5};
        int[] arr5 = {3, 4, 5, 6, 7};
        int[] arr6 = {5, 6, 7, 8, 9};

        List<Integer> finalList = checkElementAtleastTwoArray(arr4,arr5,arr6);
        System.out.println("Final List is :"+finalList);

        // Count Digits in the Number
        int number2 = 56782;
        long count = String.valueOf(number2).chars().count();

        System.out.println("Count is : "+count);
        int countIndex = 0;
        while (number2!=0){
            number2 = number2/10;
            countIndex++;
        }
        System.out.println("Total Counts are: "+countIndex);

        // Write a Java program to count number of even and odd digits in a number
        int num = 123456;
        findEvenAndOddNumbers(num);
        
        // Reverse a String recursively
        String string1 = "sandy";
        String reverseString = reverseStringRecursively(string1);
        System.out.println(reverseString);
    }

    private static String reverseStringRecursively(String string1) {
        if(string1==null || string1.isEmpty()){
            return string1;
        }

        return reverseStringRecursively(string1.substring(1))+string1.charAt(0);


    }

    private static void findEvenAndOddNumbers(int num) {

        int evenCount = 0;
        int oddCount = 0;

        while (num>0){
            int digit = num%10;
            if(digit % 2==0){
                evenCount++;
            }else {
                oddCount++;
            }
            num=num/10;
        }
        System.out.println("Even Count are: "+evenCount);
        System.out.println("Odd Count are: "+oddCount);
    }

    private static List<Integer> checkElementAtleastTwoArray(int[] arr4, int[] arr5, int[] arr6) {
        Set<Integer> hashSet = new HashSet<>();
        List<Integer> list1 = Arrays.stream(arr4).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr5).boxed().collect(Collectors.toList());
        List<Integer> list3 = Arrays.stream(arr6).boxed().collect(Collectors.toList());

        hashSet.addAll(list1);
        hashSet.addAll(list2);
        hashSet.addAll(list3);
        List<Integer> finalList =new ArrayList<>();

        for (Integer num : hashSet){
            if(
                    (list1.contains(num) && list2.contains(num))
                    || (list2.contains(num) && list3.contains(num))
                    || (list3.contains(num) && list1.contains(num))
            ){
                finalList.add(num);
            }
        }

        return finalList;
    }

    private static int firstDuplicateOccuranceInArray(int[] arr2) {
        Set<Integer> seen = new HashSet<>();

        return Arrays.stream(arr2).boxed()
                .filter(i->!seen.add(i))
                .findFirst()
                .orElse(null);
    }

    private static List<Integer> printNNaturalNumbers(int num) {
        return IntStream.rangeClosed(1,num)
                .boxed().collect(Collectors.toList());
    }

    private static List<Integer> abstractEvenNumber(int n) {
        return IntStream.rangeClosed(1,n).boxed().filter(i->i%2==0)
                .collect(Collectors.toList());
    }

    private static List<Integer> getPrimesUpToN(int n) {
        List<Integer> primes =new ArrayList<>();
        for (int i=2;i<=n;i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        if(n<=1){
            return false;
        }

        for (int i=2;i<=n/2;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }


    private static boolean checkLeapYear(int year) {
       if (year % 400 == 0){
           return true;
       } else if (year % 100 == 0) {
           return false;
       } else if (year % 4 == 0) {
           return true;
       }
       return false;
    }


    private static int reverseDigit(int num) {
        int reversed = 0;
        while (num!=0){
            int digit = num % 10;
            reversed = reversed*10 +digit;
            num = num/10;
        }
        return reversed;
    }

    private static boolean checkPerfectSquare(int num) {

        for (int i=1;i<=num;i++){
            if(i*i == num){
                return true;
            }
        }
        return false;
    }

    private static int sumofFirstandLastDigit(int num) {
        //1234
        int lastDigit = num % 10; //4
        int firstDigit =num;
        while (firstDigit>=10){
            firstDigit=firstDigit/10;
        }
        return firstDigit+lastDigit;
    }

    private static int sumOfNumber(int num) {
        int sum =0;
        int digit =0;
        while (num > 0){
            digit = num%10; // extrcting last digit
            sum=sum+digit;
            num = num /10;
        }

        System.out.println("Sum of digits of number is "+sum);
        return sum;
    }

    private static void printAtEvenPositions(int[] arr1) {

        for (int i=1;i< arr1.length;i+=2){
            System.out.println(arr1[i]);
        }
    }

    private static void printEvenLengthString(String str) {
        Arrays.stream(str.split(" ")).filter(s->s.length()%2==0)
                .collect(Collectors.toList())
                .stream().forEach(System.out::println);
    }
}
