package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
	    bubbleSort(arr);

    }

    private static void bubbleSort(int[] array) {
        for(int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if(array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
