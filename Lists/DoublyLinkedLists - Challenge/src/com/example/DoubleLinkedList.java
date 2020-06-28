package com.example;


public class DoubleLinkedList<E extends Employee> {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() { this.head = this.tail = null; }

    public DoubleLinkedList(E data) {
        this.head = new Node(data);
        size++;
    }

    public void insertNodeAtHead(E data) {
        Node newNode = new Node(data);

        // check if the list is empty, if so make the tail point to newNode
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
        size++;
    }

    public void insertNodeAtTail(E data) {
        Node newNode = new Node(data);

        // check if the list is empty, if so make the head point to newNode
        if(isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
        size++;
    }

    public boolean insertBefore(E newData, E oldData) {
        Node beforeNode = getNode(oldData);

        if(isEmpty()) {
            return false;

        } else if (head == beforeNode) {
            insertNodeAtHead(newData);
            return true;

        } else if (beforeNode != null) {
            Node newNode = new Node(newData);

            newNode.next = beforeNode;
            beforeNode.prev.next = newNode;
            newNode.prev = beforeNode.prev;
            beforeNode.prev = newNode;
            size++;
            return true;

        } else {
            System.out.println("Node not in the list");
            return false;
        }
    }

    private Node getNode(E data) {
        Node curr = head;
        while(curr != null) {
            if(curr.data.equals(data)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public E deleteNodeFromHead() {
        if(!isEmpty()) {
            Node removedNode = head;

            if (head.next == null) {
                tail = null;
            } else {
                head.next.prev = null;
            }

            head = head.next;
            size--;

            removedNode.next = null;
            removedNode.prev = null;
            return removedNode.data;
        }
        System.out.println("List is empty");
        return null;
    }

    public E deleteNodeFromTail() {
        if(!isEmpty()) {
            Node removedNode = tail;

            if(tail.prev == null) {
                head = null;
            } else {
                tail.prev.next = null;
            }

            tail = tail.prev;
            size--;

            removedNode.next = null;
            removedNode.prev = null;

            return removedNode.data;
        }
        System.out.println("List is empty");
        return null;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return head == null && tail == null; }

    public void printList() {
        Node curr = head;
        System.out.print("NULL <- HEAD -> ");
        while(curr != null) {
            System.out.printf(" %s <-> ", curr.data);
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    private class Node {
        private E data;
        private Node next;
        private Node prev;

        private Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
}
