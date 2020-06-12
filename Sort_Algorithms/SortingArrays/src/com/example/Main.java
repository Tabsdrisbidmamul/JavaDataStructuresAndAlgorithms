package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};

        Arrays.parallelSort(intArray);

        System.out.printf("Sorted Array: %s\n", Arrays.toString(intArray));
    }
}
