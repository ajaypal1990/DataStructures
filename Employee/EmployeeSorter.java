package com.ajay.concepts.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 30),
                new Employee("Bob", "Engineering", 25),
                new Employee("Charlie", "HR", 35),
                new Employee("Dave", "Engineering", 40),
                new Employee("Eve", "Sales", 28)
        );
        //sorting and grouping a list of Employee objects by their department and then printing the grouped employees,
        // sorted by age in descending order.

        Map<String, List<Employee>> empByDepartments = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));


        System.out.println(empByDepartments);

      Map<String, List<Employee>> sortedEmpByDepartments  =empByDepartments.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,entry->entry.getValue().stream()
              .sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList())
      ));

        sortedEmpByDepartments.forEach((department, empList)->{
            System.out.println("Department : "+department);
            empList.forEach(System.out::println);
        });
    }
}
