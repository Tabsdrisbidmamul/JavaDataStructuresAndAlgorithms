package com.example;

import java.util.EmptyStackException;

public class Stack<E> {
    SinglyLinkedList<E> stack = new SinglyLinkedList<>();

    public void push(E data) {
        stack.push(data);
    }

    public E pop() {
        return stack.pop();
    }

    public E peek() {
        return stack.peek();
    }

    public int getSize() {
        return stack.getSize();
    }

    public void printStack() {
        stack.printStack();
    }


    private class SinglyLinkedList<T> {
        private Node top;
        private int size;

        public SinglyLinkedList() { this.top = null; }

        public void push(E data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;

            size++;
        }

        public E pop() {
            if(isEmpty()) {
                throw new EmptyStackException();
            }

            Node toRemove = top;
            top = top.next;
            toRemove.next = null;
            size--;

            return toRemove.data;
        }

        public E peek() {
            return top.data;
        }


        public boolean isEmpty() {
            return top == null;
        }

        public int getSize() {
            return size;
        }

        public void printStack() {
            Node curr = top;
            System.out.println("---TOP---");
            while (curr != null) {
                System.out.println(curr.data);
                curr = curr.next;
            }
            System.out.println("NULL");
        }

        private class Node {
            private E data;
            private Node next;

            private Node(E data) {
                this.data = data;
                this.next = null;
            }
        }

    }
}
