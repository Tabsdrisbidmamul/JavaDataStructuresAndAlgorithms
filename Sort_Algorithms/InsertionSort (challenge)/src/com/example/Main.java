package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*
        * Challenge 2
        * - Change Insertion Sort so that it uses recursion
        * - Sort the usual example array
        * */

        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};
        insertionSort(intArray, intArray.length);
    }

    private static void insertionSort(int[] array, int numItems) {
        if(numItems < 2) {
            return;
        }

        insertionSort(array, numItems - 1);

        int newElement = array[numItems - 1];
        int i;

        for (i = numItems - 1; i > 0 && array[i - 1] >= newElement; i --) {
            System.out.printf("i is %d Element at i: %d, going to i-1: %d shift element at i-1: %d to the right\n",
                    i, array[i], i-1, array[i-1]);
            array[i] = array[i - 1];
            System.out.println(Arrays.toString(array));
        }

        System.out.printf("New Element is %d, we have terminated out the of inner loop i is %d, so we are placing" +
                        " %d at array[%d]\n",
                newElement, i, newElement, i);

        System.out.printf("Result of call when numItems: %d\n", numItems);

        array[i] = newElement;

        System.out.println(Arrays.toString(array) + "\n");

    }
}
