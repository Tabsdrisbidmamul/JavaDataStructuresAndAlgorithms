package com.example;

import java.util.EmptyStackException;

public class Stack{
    SinglyLinkedList stack = new SinglyLinkedList();

    public void push(String data) {
        stack.push(data);
    }

    public String pop() {
        return stack.pop();
    }

    public String peek() {
        return stack.peek();
    }

    public int getSize() {
        return stack.getSize();
    }

    public void printStack() {
        stack.printStack();
    }


    private class SinglyLinkedList {
        private Node top;
        private int size;

        public SinglyLinkedList() { this.top = null; }

        public void push(String data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;

            size++;
        }

        public String pop() {
            if(isEmpty()) {
                throw new EmptyStackException();
            }

            Node toRemove = top;
            top = top.next;
            toRemove.next = null;
            size--;

            return toRemove.data;
        }

        public String peek() {
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
            private String data;
            private Node next;

            private Node(String data) {
                this.data = data.replaceAll("[ .!?,;()'\\\\-]", "");
                this.next = null;
            }
        }

    }
}
