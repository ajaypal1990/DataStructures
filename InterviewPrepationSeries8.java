package com.ajay.concepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewPrepationSeries8 {
    public static void main(String[] args) {
        // WAP to count the occurance of each Character in a String
        String str1 = "ajayPal";

        str1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "::" + v));

        //Second Way
        Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "::" + v));

        // Find all duplicate elements in a String
        String str2 = "ilovejavatechie";

        LinkedHashMap<Character, Long> duplicateElements = str2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(duplicateElements);

        // Find the first non repeated element from the given string
        String str3 = "ilovejavatechie";
        Character c1 = str3.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst().get();

        System.out.println("First Non repeated Character is: " + c1);

        // Second Highest Number in the Given Array
        int[] numbers = {5, 9, 11, 2, 8, 21, 1};

        Integer i = Arrays.stream(numbers).boxed().sorted(Collections.reverseOrder()).skip(1).findFirst().get();

        System.out.println("Second Highest Number is: " + i);

        // Find longest String from a Given Array
        String[] strArray = {"java", "techie", "springboot", "microservices"};
        String longestString = Arrays.stream(strArray).max((word1, word2) -> Integer.compare(word1.length(), word2.length())).orElse(null);
        System.out.println("Longest String: " + longestString);

        String longestString1 =Arrays.stream(strArray).sorted((word2,word1)->Integer.compare(word1.length(),word2.length())).findFirst().orElse(null);
        System.out.println("Longest String: " + longestString1);

        int[] numbers1 = {5, 9, 11, 2, 8, 21, 1};
        Integer[] ArrayWithOne = Arrays.stream(numbers1).boxed().map(n->String.valueOf(n)).filter(num->num.startsWith("1"))
                .map(Integer::valueOf).toArray(Integer[]::new);

        System.out.println(Arrays.toString(ArrayWithOne));

        Map<String, Integer> employeeSalaries = new HashMap<>();

        // Adding names and salaries (with some duplicate salary values)
        employeeSalaries.put("John", 50000);
        employeeSalaries.put("Emma", 60000);
        employeeSalaries.put("Ava", 75000);
        employeeSalaries.put("Oliver", 50000); // Duplicate salary
        employeeSalaries.put("Sophia", 60000); // Duplicate salary
        employeeSalaries.put("Mason", 85000);
        employeeSalaries.put("Lucas", 75000); // Duplicate salary

        int n = 3; // We want to find the 2nd highest salary

        // Call the dynamic method to get the grouped map with the Nth highest salary
        Map<Integer, List<String>> nthSalaryGroup = groupEmployeesBySalary(employeeSalaries, n);

        // Print the result
        nthSalaryGroup.forEach((salary, employees) ->
                System.out.println("Nth Highest Salary: " + salary + " -> Employees: " + employees));

        }


    public static Map<Integer, List<String>> groupEmployeesBySalary(Map<String, Integer> employeeSalaries, int n) {
        // Step 1: Group employees by salary
        Map<Integer, List<String>> salaryToEmployeeMap = employeeSalaries.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue, // Use salary as the key
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList()) // Use employee names as the values
                ));

        System.out.println(salaryToEmployeeMap);

        // Step 2: Get distinct salaries in descending order
        List<Integer> sortedSalaries = salaryToEmployeeMap.keySet().stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedSalaries);
        // Step 3: Find the Nth highest salary and return the map with that salary as the key
        if (n <= sortedSalaries.size()) {
            int nthHighestSalary = sortedSalaries.get(n-1);
            Map<Integer, List<String>> result = new HashMap<>();
            result.put(nthHighestSalary, salaryToEmployeeMap.get(nthHighestSalary));
            return result;
        } else {
            System.out.println("The given value of N is out of range.");
            return Collections.emptyMap();
        }
    }
}