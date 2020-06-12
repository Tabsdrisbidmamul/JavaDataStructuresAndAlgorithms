package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[]{2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        countingSort(intArray, 1, 10);

    }

    private static void countingSort(int[] input, int min, int max) {
        /*
        * Lets say we have a maximum range of 10, and minimum as 1
        * We want it to be inclusive so we subtract min from max and plus 1 to the result of it
        * */
        int[] countArray = new int[(max- min) + 1];

        for (int i=0; i< input.length; i++) {
            // We are translating the positional point from the input array value to the index based in the countArray
            /*
            * If we counted 2 in the original array
            * We want to increment the value 2 in the count array to do this we get the value at the index in the
            * original array input[i] and we subtract the minimum value from it, to get its index in the counting array
            *
            * e.g.
            * input[i] = 2
            * min = 1
            * input[i] (2) - min (1) = 1 // This is the positional index to increment the value 2 in the count array
            *
            * */
            countArray[input[i] - min]++;
            System.out.printf("Count Array %s\n", Arrays.toString(countArray));
        }

        int j = 0;  // pointer to write back into the input array

        // we traverse over the countArray
        for (int i = min; i <= max; i++) {
            // while the entry in the countArray has an element greater than 0 lets start writing values

            while (countArray[i - min] > 0) {
                // write the value of i (as we use min, we can simply write the value into the input array)
                input[j++] = i;
                System.out.printf("Original Array: %s\n", Arrays.toString(input));

                // decrement the entry for the number of occurrences for that value so the loop will eventually exit
                // out of it
                countArray[i - min]--;
            }
        }
    }
}
