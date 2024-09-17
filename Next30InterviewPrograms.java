package com.ajay.concepts;

import com.udemy.designpatters.Adaptor.Rectangle;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Next30InterviewPrograms {
    public static void main(String[] args) {
        /**
         * 12345
         * 1234
         * 123
         * 12
         * 1
         */

        pyramidPattern(5);
        // Print number without any loop
        printNumberRecursively(1);
        System.out.println();
        // 1,20,5,6,16,10
        int[] arr = {1,20,5,6,16,18,16,18,10};
        int secondHighestNumber = secondHighestNumber(arr);
        System.out.println("Second Highest Number is: "+secondHighestNumber);
        
        // How to Find the SUm of elements in Array
        int sumofElements = sumArray(arr);
        System.out.println("Sum of Elements are: "+sumofElements);

        // Floyd Triangle
        int n=5;
        int c=1;
        int d=1;
        int num=1;

        printFloydTriangle(n,c,d,num);

        findFactorsUpto100(100);

        // count number of vowels in a STring
        String countVowelStr = "aeiouxyyyyz";
        String countVowels = countNumberOfVowels(countVowelStr);
        System.out.println("Total Number of Vowels are: "+countVowels);

        // print a prime number upto 20
        List<Integer> primeNumbers =printPrimeNumbers(20);
        System.out.println("Prime numbers upto 20 is: "+primeNumbers);
        
        // Find the smallest and Largest value in the array
        int[] intArray = {2,5,8,44,11,1,1111,101};
        findTheLargestAndSmallestValue(intArray);
        
    }

    private static void findTheLargestAndSmallestValue(int[] intArray) {
        int minimumValue = Integer.MAX_VALUE;
        int maximumValue = Integer.MIN_VALUE;

        for (int i=0;i<intArray.length;i++){
            if (intArray[i]>maximumValue){
                maximumValue=intArray[i];
            }
            if (intArray[i]<minimumValue){
                minimumValue=intArray[i];
            }
        }
        System.out.println("Maximum value of Array is: "+maximumValue);
        System.out.println("Minimum value of Array is: "+minimumValue);

        int[] unsortedArray = {5,10,24,1,7,4,2};
        System.out.println("Unsorted Array is:: "+Arrays.toString(unsortedArray));
        int[] sortedArray = sortTheArray(unsortedArray);
        System.out.println("Sorted Array is: "+Arrays.toString(sortedArray));

        List<Integer> fibonacciList = printFibonacciNumberTillLimit(50);
        System.out.println("Fibonacci Number till 20 are: "+fibonacciList);

        // Sort the Student by Name and ID
        Student[] students = {
                new Student(3, "John"),
                new Student(1, "Alice"),
                new Student(2, "Bob"),
                new Student(1, "Charlie")
        };

       Student[] sortStudentByID = sortStudentByID(students);
       System.out.println("Students Sorted By ID: "+Arrays.toString(sortStudentByID));


        Student[] sortStudentByName = sortStudentByName(students);
        System.out.println("Students Sorted By Name: "+Arrays.toString(sortStudentByName));

        Student[] sortStudentByID_Name = sortStudentByIDandName(students);
        System.out.println("Students Sorted By Id and Name: "+Arrays.toString(sortStudentByID_Name));

        // Sort the Student hashmap on the basis of student Id and then student name
        // Create a HashMap with student ID as key and Student object as value
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(3, new Student(3, "John"));
        studentMap.put(1, new Student(1, "Alice"));
        studentMap.put(2, new Student(2, "Bob"));
        studentMap.put(4, new Student(4, "Charlie"));
        studentMap.put(4, new Student(4, "Ajay"));
        studentMap.put(5, new Student(5, "Rashmi"));
        studentMap.put(1, new Student(1, "Jiya"));
        studentMap.put(6, new Student(6, "Aakash"));

        Map<Integer, Student> sortMapById =  sortMapByStudentId(studentMap);
        System.out.println("Student Map SOrt By ID");
        sortMapById.forEach((k,v)-> System.out.println(k+"::"+v));

        Map<Integer, Student> sortMapByName =  sortMapByStudentName(studentMap);
        System.out.println("Student Map SOrt By Name");
        sortMapByName.forEach((k,v)-> System.out.println(k+"::"+v));

        Map<Integer, Student> sortMapById_Name =  sortMapByStudentIdName(studentMap);
        System.out.println("Student Map SOrt By Name and then ID");
        sortMapById_Name.forEach((k,v)-> System.out.println(k+"::"+v));

        // FInd the Factorial using the Recusion
        int factorial = findFactorial1(5);
        System.out.println("Factrorial Of the nUmber is: "+factorial);

        // java program to find the Year is a Leap year or Not

        boolean isLeapYear = checkLeapYear1(2020);
        System.out.println("Given year is Leap or not:: "+isLeapYear);

        // reverse a String in java 8
        String string1 = "ajaypal";
        String reverseString = reverseStringinJava8(string1);
        System.out.println("Reverse String is: "+reverseString);

        // Find factors till Number 100

        findFactorOfEachNumber(5);
        // Write Java program to print duplicat elements in Array
        int[] arrayNew = {5,1,7,7,1,6,9,88,11,12,15,11,88,56,5,5,35};

        Set<Integer> duplicateElements = findDuplicateElements1(arrayNew);
        System.out.println("Duplicate Elements in the Array are: "+duplicateElements);

        // Check Whether Array Contains Duplciate or NOT
        List<Integer> list = Arrays.stream(arrayNew)
                .boxed().collect(Collectors.toList());
        Set<Integer> set=Arrays.stream(arrayNew).boxed().collect(Collectors.toSet());
        if(list.size()!=set.size()){
            System.out.println("Array Contain the duplicate");
        }

        int findGreatest = FindtheGreatestOfThree(10,200,30);
        System.out.println("Greatest among three is: "+findGreatest);

        // Reverse an integer number
        int num1=123;
        int reverseNumber = reverseNumber1(num1);
        System.out.println("reverse num is: "+reverseNumber);

        // Check Given Character is Alphabet or NNOT
        boolean checkAphabet = checkAlphabet('9');
        System.out.println("Is it Alphabet: "+checkAphabet);

        // Print A to z Character in a List
        List<Character> characters= listAlphabets();
        System.out.println(characters);

        // Remove Duplicate Characters
        String strDuplicate = removeDuplicateCharactersFromString("sandeep");
        System.out.println("duplicate characters are: "+strDuplicate);

        // Remove Duplicate Numbers in the Array and return the array size which contains the unique elements
        int[] arr2= {0,0,1,1,1,2,2,3,3,4};
        Integer[] arrSize = removeDuplicateFromArray(arr2);
        System.out.println("New Array Without Duplicate are: "+ Arrays.toString(arrSize));

        int arrSize1 = removeDuplicateFromArraySize(arr2);
        System.out.println("New Array Without Duplicate size are: "+ arrSize1);
    }

    private static int removeDuplicateFromArraySize(int[] arr2) {
        if(arr2.length == 0){
            return 0;
        }

        int start=0;
        for (int j=1;j<arr2.length;j++){
            if(arr2[j]!=arr2[start]){
                start++;
                arr2[start]=arr2[j];
            }
        }
        return start+1;
    }

    private static Integer[] removeDuplicateFromArray(int[] arr2) {
        return Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toSet())
                .stream()
                .toArray(Integer[]::new);
    }

    private static String removeDuplicateCharactersFromString(String str) {
        return str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static List<Character> listAlphabets() {
        List<Character> characterList=new ArrayList<>();
        for (char ch = 'a';ch<='z';ch++){
            characterList.add(ch);
        }
        return characterList;
    }

    private static boolean checkAlphabet(char ch) {
        if (ch>='a' && ch<='z' || ch>='A' && ch<='Z'){
            return true;
        }
        return false;
    }

    private static int reverseNumber1(int num1) {
       int reverseNumber=0;

       while (num1!=0){
           int digit = num1 % 10;
           reverseNumber = reverseNumber * 10 +digit;
           num1=num1/10;
       }
       return reverseNumber;
    }

    private static int FindtheGreatestOfThree(int x, int y, int z) {
        if (x>y && x>z){
            return x;
        } else if (y>z && y>x) {
            return y;
        } else if (z>x && z>y) {
            return z;
        }
        return -1;
    }

    private static Set<Integer> findDuplicateElements1(int[] arrayNew) {
        Set<Integer> integerSet=new HashSet<>();
        Set<Integer> duplicateElements = new LinkedHashSet<>();

        for (Integer num: arrayNew){
            if (!integerSet.contains(num)){
                integerSet.add(num);
            }else {
                duplicateElements.add(num);
            }
        }
        return duplicateElements;
    }

    private static void findFactorOfEachNumber(int limit) {
        for (int i =1;i<=limit;i++){
            System.out.print("Factor of "+i+" are: ");
            for (int j=1;j<=i;j++){
                if (i % j == 0 ){
                    System.out.print(","+j);
                }
            }
            System.out.println();
        }
    }

    private static String reverseStringinJava8(String string1) {
      return string1.chars().mapToObj(c->(char)c)
                .collect(Collectors.collectingAndThen(Collectors.toList(),list->{
                    Collections.reverse(list);
                    return list.stream();
                }))
                .map(String::valueOf)
                .collect(Collectors.joining());

    }

    // every 4th year is a leap year
    // every 100th year is not leap year
    // every 400th year is a leap year
    private static boolean checkLeapYear1(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int findFactorial1(int num) {
        if (num == 0){
            return 1;
        }

        return num * findFactorial1(num-1);
    }

    private static Map<Integer, Student> sortMapByStudentIdName(Map<Integer, Student> studentMap) {
        return studentMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Student::getName)
                        .thenComparingInt(Student::getId)))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
    }

    private static Map<Integer, Student> sortMapByStudentName(Map<Integer, Student> studentMap) {
        return studentMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Student::getName)))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
    }

    private static Map<Integer, Student> sortMapByStudentId(Map<Integer, Student> studentMap) {
       return studentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
    }

    private static Student[] sortStudentByIDandName(Student[] students) {
        return Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparingInt(Student::getId))
                .toArray(Student[]::new);
    }

    private static Student[] sortStudentByName(Student[] students) {
        return Arrays.stream(students)
                .sorted(Comparator.comparing(stu->stu.getName()))
                .toArray(Student[]::new);
    }

    private static Student[] sortStudentByID(Student[] students) {
      return  Arrays.stream(students)
                .sorted(Comparator.comparingInt(Student::getId))
                .toArray(Student[]::new);
    }

    // 0 1 1 2 3 5 8 12 20
    private static List<Integer> printFibonacciNumberTillLimit(int num) {
        List<Integer> resultList = new ArrayList<>();
        int firstNumber = 0 ;
        int secondNumber = 1;

        while (firstNumber<=num){
            System.out.println(firstNumber);
            resultList.add(firstNumber);
            int next = firstNumber+secondNumber;
            firstNumber = secondNumber;
            secondNumber = next;
        }

        return resultList;
    }

    private static int[] sortTheArray(int[] unsortedArray) {
        return Arrays.stream(unsortedArray).sorted().toArray();
    }

    // 1,2,3,5,7,11,
    private static List<Integer> printPrimeNumbers(int num) {
        List<Integer> integerList = new ArrayList<>();
        for (int i =1;i<=num;i++){
            if (checkPrime(i)){
                integerList.add(i);
            }
        }
        return integerList;
    }

    private static boolean checkPrime(int n) {
        if(n<=1){
            return false;
        }

        for (int j = 2;j<=n/2;j++){
            if (n % j ==0){
                return false;
            }
        }
        return true;
    }

    private static String countNumberOfVowels(String countVowelStr) {
        String vowels = "aeiou";
        Set<Character> vowelSet = vowels.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        return countVowelStr.chars().mapToObj(c->(char)c)
                .filter(c->!vowelSet.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static void findFactorsUpto100(int n) {
        for (int i = 1;i<=n;i++){
            System.out.print("Factor of "+i+" are:: ");
            for (int j = 1;j<=i;j++){
                if(i%j == 0){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }

    private static void printFloydTriangle(int n, int c, int d, int num) {
        for (c=1;c<=n;c++){
            for (d=1;d<=c;d++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println(" ");
        }
    }

    private static int sumArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    private static int secondHighestNumber(int[] arr) {
    return Arrays.stream(arr)
             .distinct().boxed()
             .sorted((a,b)->b-a)
             .skip(1)
             .findFirst().orElseThrow(()->new IllegalArgumentException("Array should have at least two distinct elements"));
    }

    private static void printNumberRecursively(int n) {
     if (n<=10){
         System.out.print(n+",");
         printNumberRecursively(n+1);
     }
    }

    private static void pyramidPattern(int n) {
        for (int i=n;i>0;i--){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
