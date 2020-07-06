package com.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        bucketSort(new int[]{ 54, 46, 83, 66, 95, 92, 43 });
    }

    private static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        for(int i=0; i<buckets.length; i++) {
            // Using LinkedList for the buckets
//            buckets[i] = new LinkedList<>();

            // Using ArrayList for the buckets
            buckets[i] = new ArrayList<>();
        }

        for (int value : input) {
            buckets[hash(value)].add(value);
        }

        for (List<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        // Iterate over the List
        for (List<Integer> bucket : buckets) {
            // Iterate over the ArrayList
            for (int value : bucket) {
                input[j++] = value;
                System.out.printf("Inserting %d into input array\n", value);
            }
            System.out.printf("input array is: %s\n", Arrays.toString(input));
        }
    }

    private static int hash(int value) {
        return ( value / (int) 10 );
    }
}
