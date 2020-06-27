package com.example;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<Employee> doubleLinkedList = new DoubleLinkedList<>();

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Employee billEnd = new Employee("Bill", "End", 78);

        doubleLinkedList.insertNodeAtHead(janeJones);
        doubleLinkedList.insertNodeAtHead(johnDoe);
        doubleLinkedList.insertNodeAtHead(marySmith);
        doubleLinkedList.insertNodeAtHead(mikeWilson);
        doubleLinkedList.insertNodeAtTail(billEnd);
        doubleLinkedList.deleteNodeFromHead();
        doubleLinkedList.deleteNodeFromTail();

        doubleLinkedList.printList();
        System.out.println(doubleLinkedList.getSize());



    }
}
