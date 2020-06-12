package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};
        quickSort(intArray, 0, intArray.length);
    }

    private static void quickSort(int[] input, int start, int end) {
        if(end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        // By the time this call returns the left sub array - the left of 20 is entirely sorted
        quickSort(input, start, pivotIndex);         // quick sort the left sub array

        // By the time this call returns the right sub array - the right of 20 is entirely sorted
        quickSort(input, pivotIndex + 1, end);  // quick sort the right sub array

    }

    private static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot

        int pivot = input[start];
        System.out.printf("Pivot element: %s\n", pivot);
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: This is an empty loop body - we simply want to decrement j
            while (i < j && input[--j] >= pivot);
            if(i < j) {
                // Moving right to left
                System.out.printf("This is i (i < j) %d < %d placing array[%d] with element j %d\n", i, j, i, input[j]);
               input[i] = input[j];
            }

            // NOTE: This is an empty loop body - we simple want to increment i
            while(i < j && input[++i] <= pivot);
            if (i < j) {
                // Moving left to right
                System.out.printf("This is j (i < j) %d < %d placing array[%d] with element i %d\n", i, j, j, input[i]);
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        System.out.printf("Partitioned array is: %s\n", Arrays.toString(input));
        return j;
    }
}
