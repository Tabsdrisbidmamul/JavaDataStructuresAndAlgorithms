package com.example;

public class Main {

    public static void main(String[] args) {
        int[] input = new int[] { 20, 35, -15, 7, 55, 1, -22 };
        System.out.println(linearSearch(input, -15));
        System.out.println(linearSearch(input, 1));
        System.out.println(linearSearch(input, 8888));
        System.out.println(linearSearch(input, -22));

    }

    private static int linearSearch(int[] input, int key) {
        for(int i = 0; i < input.length; i++) {
            if(input[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
