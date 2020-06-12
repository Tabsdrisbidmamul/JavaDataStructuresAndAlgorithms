package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*
        * Challenge 1
        * - Modify the merge sort algorithm so that it sorts integers in DESCENDING order
        * - Use the usual example array
        *
        * changes are noted with comments
        * */

        int[] intArray = new int[]{20, 35, -15, 7, 55, 1, -22};
        mergeSort(intArray, 0, intArray.length);
        System.out.printf("Sorted Array: %s", Arrays.toString(intArray));
    }

    private static void mergeSort(int[] inputArray, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        System.out.printf("Splitting array %s to get left array %s\n", Arrays.toString(inputArray),
                Arrays.toString(Arrays.copyOfRange(inputArray, start, end)));
        mergeSort(inputArray, start, mid);

        System.out.printf("Splitting array %s to get right array %s\n", Arrays.toString(inputArray),
                Arrays.toString(Arrays.copyOfRange(inputArray, mid, end)));
        mergeSort(inputArray, mid, end);


        merge(inputArray, start, mid, end);

    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        // change here from: inputArray[mid - 1] <= inputArray[mid] to
        if(inputArray[mid - 1] >= inputArray[mid]) {
            return;
        }

        int i = start, j = mid, tempIndex = 0;
        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            System.out.printf("Merging %s with elements %s\n", Arrays.toString(inputArray),
                    Arrays.toString(Arrays.copyOfRange(inputArray, i, j)));

            // change here from:
            // temp[tempIndex++] = inputArray[i] <= inputArray[j] ? inputArray[i++] : inputArray[j++] to
            temp[tempIndex++] = inputArray[i] >= inputArray[j] ? inputArray[i++] : inputArray[j++];
        }
        System.out.printf("Adding reaming elements into %s with elements %s\n",
                Arrays.toString(inputArray), Arrays.toString(Arrays.copyOfRange(inputArray, i, start + tempIndex)));
        System.arraycopy(inputArray, i, inputArray, start + tempIndex, mid - i);

        System.out.printf("Copying elements from temp array %s into original array %s\n",
                Arrays.toString(temp), Arrays.toString(Arrays.copyOfRange(inputArray, start, start + tempIndex)));
        System.arraycopy(temp, 0, inputArray, start, tempIndex);

    }
}
