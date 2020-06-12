package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};
        selectionSort(intArray);
    }

    private static void selectionSort(int[] array) {
        for (int j = array.length - 1; j > 0; j--) {
            int largest = 0;
            for (int i = 1; i <= j; i++) {
                if(array[i] > array[largest]) {
                    largest = i;
                }
            }

            int temp = array[j];
            array[j] = array[largest];
            array[largest] = temp;

            System.out.println(Arrays.toString(array));
        }
    }

}
