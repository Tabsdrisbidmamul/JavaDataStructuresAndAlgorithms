package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[] { -22, -15, 1, 7, 20, 35, 55 };

//        System.out.println(iterativeBinarySearch(arr, -15));
//        System.out.println(iterativeBinarySearch(arr, 35));
//        System.out.println(iterativeBinarySearch(arr, 8888));
//        System.out.println(iterativeBinarySearch(arr, 1));

        System.out.println(recursiveBinarySearch(arr, -15));
        System.out.println(recursiveBinarySearch(arr, 35));
        System.out.println(recursiveBinarySearch(arr, 8888));
        System.out.println(recursiveBinarySearch(arr, 1));
    }


    private static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while(start < end) {
            int midpoint = (start + end) / 2;
            System.out.printf("midpoint: %d\n", midpoint);

            if(input[midpoint] == value) {
                return midpoint;
            } else if(input[midpoint] < value) {    // right part of the array
                start = midpoint + 1;
            } else {    // left part of the array
                end = midpoint;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if(start >= end) {
            System.out.printf("start is less than end\n\tstart: %d, end: %d\n", start, end);
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.printf("midpoint: %d\n", midpoint);

        if(input[midpoint] == value) {
            System.out.printf("Found the value\n\tmidpoint is: %d\n", midpoint);
            return midpoint;
        } else if (input[midpoint] < value) {   // right part of array
            System.out.printf("Looking at the right part of array\n\t%s\n",
                    Arrays.toString(Arrays.copyOfRange(input, midpoint+1,
                    end)));
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        } else {    // left part of array
            System.out.printf("Looking at the left part of array\n\t%s\n", Arrays.toString(Arrays.copyOfRange(input, start,
                    midpoint)));
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
