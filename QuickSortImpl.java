package com.ajay.concepts;

import java.util.Arrays;

public class QuickSortImpl {
    public static void main(String[] args) {
        int[] unsortedArray={6,3,9,5,2,8};
        System.out.println(Arrays.toString(unsortedArray));
        int n = unsortedArray.length;

        quickSort1(unsortedArray,0,n-1);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void quickSort1(int[] unsortedArray, int low, int high) {

        if (low<high){
            int piIndex = partition(unsortedArray,low,high);
            quickSort1(unsortedArray,low,piIndex-1);
            quickSort1(unsortedArray,piIndex+1,high);
        }
    }

    private static int partition(int[] unsortedArray, int low, int high) {
        int pivot = unsortedArray[high];
        int i=low-1;

        for (int j = low;j<high;j++){
            if (unsortedArray[j]<pivot){
                i++;
                int temp = unsortedArray[i];
                unsortedArray[i]=unsortedArray[j];
                unsortedArray[j]=temp;
            }
        }
        i++;
        int temp = unsortedArray[i];
        unsortedArray[i]=pivot;
        unsortedArray[high] = temp;
        return i;
    }
}
