package com.example;


public class SingleLinkedList <E extends Employee> {
    private Node head;
    private int size;

    public SingleLinkedList() { this.head = null; }

    public SingleLinkedList(E data) {
        this.head = new Node(data);
        size++;
    }

    public void insertNode(E data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E deleteNode() {
        if(!isEmpty()) {
            Node removedNode = head;
            head = head.next;
            removedNode.next = null;
            size--;
            return removedNode.data;
        }
        System.out.println("List is empty");
        return null;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return head == null; }

    public void printList() {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
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
