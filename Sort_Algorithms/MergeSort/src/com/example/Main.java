package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[]{20, 35, -15, 7, 55, 1, -22};
        mergeSort(intArray, 0, intArray.length);
        System.out.printf("Sorted Array: %s", Arrays.toString(intArray));
    }

    // {20, 35, -15, 7, 55, 1, -22}
    private static void mergeSort(int[] inputArray, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        /*
        * We split on this array {20, 35, -15, 7, 55, 1, -22}
        *
        * Left              Right
        * {20, 35, -15}     {7, 55, 1, -22}
        *
        * {20, 35, -15}
        * That comes from calling mergeSort(inputArray, start, mid);
        * This line is called and pushes the array splice onto the stack
        *
        * {7, 55, 1, -22}
        * mergeSort(inputArray, mid, end);
        * Then this line is ran once the left partition has been pushed onto the stack
        *
        * This process is repeated until we get a single element arrays
        * */
        System.out.printf("Splitting array %s to get left array %s\n", Arrays.toString(inputArray),
                Arrays.toString(Arrays.copyOfRange(inputArray, start, end)));
        mergeSort(inputArray, start, mid);

        System.out.printf("Splitting array %s to get right array %s\n", Arrays.toString(inputArray),
                Arrays.toString(Arrays.copyOfRange(inputArray, mid, end)));
        mergeSort(inputArray, mid, end);


        merge(inputArray, start, mid, end);

    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        /*
        * What does this mean?
        * the index mid when used like this is pointing to both the left and the right partitions of the spliced
        * arrays
        * [mid - 1] := the last element in the left partition
        * [mid] := is the first element in the right partition
        *
        * if the last element of the left partition is smaller the first element in the right partition, we are done
        * the left partition and the right partition are actually sorted
        *
        * left              right
        * {1, 5, 8, 9}      {15, 48, 78}
        *
        * 9 is less than 15 and you can see this as almost saying that we have got the perfect scenario where we come
        * to merging the partition arrays, that are in sorted order and we don't need to process them anymore
        * so we can bunch them together pretty much and return
        *
        * */
        if(inputArray[mid - 1] <= inputArray[mid]) {
            return;
        }

        int i = start, j = mid, tempIndex = 0;  // keep track of the temp array index
        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            // post-increment, will update the counter after the line has executed
            System.out.printf("Merging %s with elements %s\n", Arrays.toString(inputArray),
                    Arrays.toString(Arrays.copyOfRange(inputArray, i, j)));
            temp[tempIndex++] = inputArray[i] <= inputArray[j] ? inputArray[i++] : inputArray[j++];
        }

        /*
        * What does this do?
        * The optimisation trick here is this
        * Lets say we have 2 arrays partitions
        *
        * {32, 34}, {33, 36}
        * - We compare 32 with 33 -> 32 < 33, so we copy 32 into temp and i++
        * - We compare 34 with 33 -> 33 < 34, so we copy 33 into temp and j++
        * - We compare 34 with 36 -> 34 < 36, so we copy 34 into temp and i++
        *
        * i == mid and so we break out of the merge loop, but we have 36 left over
        * If we were to write 36 into the temp array, then copy the temp array over the original array, what is
        * happening is that we are actually overwriting over 36 twice, because the positions of the elements in the
        * original array have not changed, and when split to get the partitions, so again it is needless work to do
        *
        * So instead we simply write the positions of the temp array and leave the right partition, as 36 in the
        * original array is in the correct position
        *
        * {32, 33, 34, }
        *
        * The left array is where you need to do the processing!
        *
        * */

        // handles the notes above
        System.out.printf("Adding reaming elements into %s with elements %s\n",
                Arrays.toString(inputArray), Arrays.toString(Arrays.copyOfRange(inputArray, i, start + tempIndex)));
        System.arraycopy(inputArray, i, inputArray, start + tempIndex, mid - i);

        // copy the elements in the temp array, only the ones that are placed in it
        System.out.printf("Copying elements from temp array %s into original array %s\n",
                Arrays.toString(temp), Arrays.toString(Arrays.copyOfRange(inputArray, start, start + tempIndex)));
        System.arraycopy(temp, 0, inputArray, start, tempIndex);

    }
}
