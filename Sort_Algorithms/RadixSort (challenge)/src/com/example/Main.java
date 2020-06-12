package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[] {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSort(strArray, 26, 5);
        System.out.printf("Sorted Array: %s\n", Arrays.toString(strArray));
    }

    private static void radixSort(String[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
            System.out.printf("Array Sorted at i(%d): %s\n\n", i, Arrays.toString(input));
        }
    }

    private static void radixSingleSort(String[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(String value: input) {
            countArray[getDigit(position, value)]++;
        }

        System.out.printf("CountArray: %s\n", Arrays.toString(countArray));

        // We then adjust the countArray to have a cumulative sum of all the values we counted from the previous loop
        for (int j=1; j< radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        System.out.printf("CountArray(adjusted): %s\n", Arrays.toString(countArray));

        // Copied the values into the temp array
        String[] temp = new String[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex])]] = input[tempIndex];
            System.out.printf("TempArray: %s\n", Arrays.toString(temp));
        }

        // copy the contents of temp Array to the input Array
        System.arraycopy(temp, 0, input, 0, numItems);
    }

    private static int getDigit(int position, String value) {
        return value.charAt(value.length() - position - 1) - 'a';
    }

}
