package com.ajay.concepts;

import java.util.Scanner;

public class Interviewpreprationseries11 {
    public static void main(String[] args) {
        double num1,num2;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter Numbers");
        num1 = scanner.nextDouble();
        num2 = scanner.nextDouble();
        System.out.println("Enter an Operator to perform the Operation(*,+,-,/)");
        char op =scanner.next().charAt(0);

        double o;

        switch (op){
            case '+' :
                o= num1+num2+0.0;
                break;
            case '-' :
                o= num1-num2;
                break;
            case '*' :
                o= num1*num2;
                break;
            case '/' :
                o= num1/num2;
                break;
            default :
                o= num1+num2;
                break;
        }
        System.out.println("Result is :"+o);
    }
}
