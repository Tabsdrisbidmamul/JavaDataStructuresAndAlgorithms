package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};
        insertionSort(intArray);
    }

    private static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int newElement = array[j];
            int i;

            for (i = j; i > 0 && array[i - 1] >= newElement; i --) {
                System.out.printf("i is %d Element at i: %d, going to i-1: %d shift element at i-1: %d to the right\n",
                        i, array[i], i-1, array[i-1]);
                array[i] = array[i - 1];
                System.out.println(Arrays.toString(array));
            }

            System.out.printf("New Element is %d, we have terminated out the of inner loop i is %d, so we are placing" +
                            " %d at array[%d]\n",
                    newElement, i, newElement, i);

            array[i] = newElement;

            System.out.println(Arrays.toString(array) + "\n");
        }
    }
}
