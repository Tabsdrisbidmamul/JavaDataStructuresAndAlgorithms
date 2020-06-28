package com.example;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    Employee janeJones = new Employee("Jane", "Jones", 123);
	    Employee johnDoe = new Employee("John", "Doe", 4567);
	    Employee marySmith = new Employee("Mary", "Smith", 22);
	    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
	    Employee billEnd = new Employee("Bill", "End", 78);

	    // Doubly Linked List in the JDK
        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        printList(list);

        /*
        * add() will always add to the end of the list
        * addLast() does the same as well
        * */
        list.add(billEnd);
//        list.addLast(billEnd);
        printList(list);

        /*
        * remove() will always remove from the front of the list
        * removeFirst() does the same as well
        * */
        list.removeFirst();
//        list.remove();
        printList(list);

        list.removeLast();
        printList(list);

    }

    private static void printList(LinkedList<?> list) {
//        Iterator<Object> iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }

        System.out.print("NULL -> HEAD <-> ");
        for(Object obj: list) {
            System.out.printf("%s <-> ", obj);
        }
        System.out.println("NULL");
    }
}
