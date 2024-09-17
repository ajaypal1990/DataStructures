package com.ajay.concepts;

import java.util.Scanner;

public class ReadandprintMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();

        System.out.println("Enter number of colmuns");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements in the Matrix");
        for (int i=0;i< rows;i++){
            for (int j=0;j< columns;j++){
                matrix[i][j]= scanner.nextInt();
            }
        }

        System.out.println("Print the Matrix");
        for (int i=0;i< rows;i++){
            for (int j=0;j< columns;j++){
                System.out.print
                        (matrix[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
