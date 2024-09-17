package com.ajay.concepts.Employee;

class Employee {
    private String name;
    private String department;
    private int age;

    // Constructor
    public Employee(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "', age=" + age + "}";
    }
}

