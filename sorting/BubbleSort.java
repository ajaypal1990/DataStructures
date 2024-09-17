package com.ajay.concepts.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,5};
        int n =arr.length-1;
        System.out.println("Array Before sorting: "+ Arrays.toString(arr));
        quickSort(arr,0,n);
        System.out.println("Array After sorting: "+ Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = partitions(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    private static int partitions(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high;j++){
            if(arr[j]< pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
}
