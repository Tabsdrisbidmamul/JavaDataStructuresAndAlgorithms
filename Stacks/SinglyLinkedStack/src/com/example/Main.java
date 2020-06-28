package com.example;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.printStack();
        System.out.printf("Size of Stack: %d\n", stack.getSize());
        System.out.println("--------------------------");

        System.out.printf("Popped value: %d\n", stack.pop());
        stack.printStack();
        System.out.printf("Size of Stack: %d\n", stack.getSize());
        System.out.println("--------------------------");

        System.out.printf("Peeked value: %d\n", stack.peek());
        stack.printStack();
        System.out.printf("Size of Stack: %d\n", stack.getSize());
        System.out.println("--------------------------");



    }
}
