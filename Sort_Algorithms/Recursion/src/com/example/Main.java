package com.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iterative Factorial");
        System.out.println(iterativeFactorial(5));
        System.out.println(iterativeFactorial(0));
        System.out.println("Recursive Factorial");
        System.out.println(recursiveFactorial(5));
        System.out.println(recursiveFactorial(0));
    }

    private static int iterativeFactorial(int num) {
        if(num == 0 || num == 1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int recursiveFactorial(int num) {
        return (num == 0 || num == 1) ? 1 : num * recursiveFactorial(num - 1);
    }
}
