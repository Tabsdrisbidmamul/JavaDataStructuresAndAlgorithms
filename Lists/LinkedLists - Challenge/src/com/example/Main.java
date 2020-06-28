package com.example;

public class Main {

    public static void main(String[] args) {
        /*
        * CHALLENGE 2
        * - Implement a method in the IntegerLinkedList class that insert a value in sorted order
        * - Lower values should appear first in the list
        * - If we insert 4, 2, 1, 5 the list should look like this HEAD -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        *
        * the method is called insertSorted()
        *
        * */

        IntegerLinkedList<Integer> list = new IntegerLinkedList<>();
//        list.insertNode(5);
//        list.insertNode(4);
//        list.insertNode(2);
//        list.insertNode(1);
//
//        list.printList();
//        System.out.println(list.getSize());

        list.insertSorted(4);
        list.insertSorted(2);
        list.insertSorted(1);
        list.insertSorted(5);
        list.insertSorted(6);
        list.insertSorted(3);
        list.insertSorted(1);
        list.insertSorted(5);

        list.printList();
        System.out.println(list.getSize());

	}
}
