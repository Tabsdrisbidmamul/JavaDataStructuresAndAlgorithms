package com.example;

public class Main {

    public static void main(String[] args) {
        /*
        * CHALLENGE 1
        * - implement the addBefore() method for the DoublyLinkedList
        * - It will take the new Node, and an existing Node within the List and it should add the new Node before the
        *   existing Node
        *
        * */
        DoubleLinkedList<Employee> doubleLinkedList = new DoubleLinkedList<>();

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Employee billEnd = new Employee("Bill", "End", 78);

        // CHALLENGE CODE
        System.out.println(doubleLinkedList.insertBefore(new Employee("James", "Bond", 007), billEnd));
        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());
        System.out.println("------------------------------------");

        doubleLinkedList.insertNodeAtHead(janeJones);
        doubleLinkedList.insertNodeAtHead(johnDoe);
        doubleLinkedList.insertNodeAtHead(marySmith);
        doubleLinkedList.insertNodeAtHead(mikeWilson);

        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());
        System.out.println("------------------------------------");

        doubleLinkedList.insertNodeAtTail(billEnd);

        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());
        System.out.println("------------------------------------");

        doubleLinkedList.deleteNodeFromHead();

        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());
        System.out.println("------------------------------------");

        doubleLinkedList.deleteNodeFromTail();

        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());
        System.out.println("------------------------------------");

        // CHALLENGE CODE
        System.out.println(doubleLinkedList.insertBefore(new Employee("James", "Bond", 007), johnDoe));
        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());
        System.out.println("------------------------------------");

    }
}
