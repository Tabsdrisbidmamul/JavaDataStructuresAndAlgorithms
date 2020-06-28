package com.example;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Employee> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Employee> iterator = stack.listIterator();
        System.out.println("---TOP---");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("NULL");
    }
}
