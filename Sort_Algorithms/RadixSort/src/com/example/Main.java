package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[] {4725, 4586, 1330, 8792, 1594, 5729};
        radixSort(intArray, 10, 4);
        System.out.printf("Sorted Array: %s\n", Arrays.toString(intArray));
    }

    private static void radixSort(int[] input, int radix, int width) {
        for(int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
            System.out.printf("Array sorted at i(%d): %s\n\n", i, Arrays.toString(input));
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(int value: input) {
            /*
            * Conventional countArray where we are counting the number of values in the specific position (1's, 10's,
            * 100's etc..)
            * */
            countArray[getDigit(position, value, radix)]++;
        }

        System.out.printf("CountArray: %s\n", Arrays.toString(countArray));

        // We then adjust the countArray to have a cumulative sum of all the values we counted from the previous loop
        for (int j=1; j< radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        System.out.printf("CountArray(adjusted): %s\n", Arrays.toString(countArray));

        // Copied the values into the temp array
        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[(getDigit(position, input[tempIndex], radix))]] = input[tempIndex];
            System.out.printf("TempArray: %s\n", Arrays.toString(temp));
        }

        // copy the contents of temp Array to the input Array
        System.arraycopy(temp, 0, input, 0, numItems);

    }

    private static int getDigit(int position, int value, int radix) {
        /*
        * Order of precedence
        * ()
        * ^
        * /
        * *
        * %
        * +
        * -
        *
        * We will do 10 to the power of the position at the point in the loop for radixSort we are extracting the 1's
        * positions so we are passing it a position value of 0
        * so 10^0 = 1
        *
        * we then do the value / by the result above
        *
        * 4725 / 1 = 4725
        *
        * and then we mod the dividend by the radix (which is 10)
        *
        * so 4725 % 10 is 5
        *
        * this extract the 1's position from the value
        *
        * */
        return value / (int) Math.pow(radix, position) % radix;
    }

}
