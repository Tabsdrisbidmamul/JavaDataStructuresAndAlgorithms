package com.example;


import java.util.ArrayList;
import java.util.List;

public class IntegerLinkedList<E extends Integer> {
    private Node head;
    private int size;

    public IntegerLinkedList() { this.head = null; }

    public IntegerLinkedList(E data) {
        this.head = new Node(data);
        size++;
    }

    public void insertNode(E data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /*CHALLENGE CODE*/
    public boolean insertSorted(E data) {
        List<Node> nodeList = getNodeSorted(data);

        if (isEmpty() || data.intValue() <= head.data.intValue()) {
            insertNode(data);
            return true;
        } else if (nodeList != null) {
            Node newNode = new Node(data);
            Node before = nodeList.get(0);

            if(nodeList.size() > 1) {
                Node after = nodeList.get(1);

                before.next = newNode;
                newNode.next = after;
            } else {
                before.next = newNode;
                newNode.next = null;
            }
            size++;
        }
        return false;
    }

    public List<Node> getNodeSorted(E data) {
        if(!isEmpty()) {
            Node curr = head.next;
            Node before = head;
            List<Node> list = new ArrayList<>(2);

            while(curr != null) {
                if(data.intValue() <= curr.data.intValue()) {
                    list.add(before);
                    list.add(curr);
                }
                before = curr;
                curr = curr.next;
            }

            list.add(before);
            return list;
        }
        return null;
    }
    /*END OF CHALLENGE CODE*/

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
        System.out.print("HEAD -> ");
        while(curr != null) {
            System.out.printf("%s -> ", curr.data);
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
