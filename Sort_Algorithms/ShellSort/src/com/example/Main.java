package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22};
        shellSort(intArray);
    }

    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            System.out.printf("gap is %d\n", gap);

            for (int i = gap; i < array.length; i++) {
                System.out.printf("i is %d\n", i);

                int newElement = array[i];
                System.out.printf("New Element is %d\n", newElement);

                int j = i;
                System.out.printf("j is %d\n", j);

                while (j >= gap && array[j - gap] > newElement) {
                    System.out.printf("Swapping value at array[%d]: %d, with value at array[%d]: %d\n",
                            j-gap, array[j-gap], j, array[j]);
                    array[j] = array[j - gap];
                    System.out.println(Arrays.toString(array));

                    j -= gap;
                    System.out.printf("j - gap is now %d\n", j);
                }

                System.out.printf("Reached termination point of the while loop so we are inserting newElement: %d at " +
                        "position j: %d\n", newElement, j);
                array[j] = newElement;
                System.out.println(Arrays.toString(array));
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
