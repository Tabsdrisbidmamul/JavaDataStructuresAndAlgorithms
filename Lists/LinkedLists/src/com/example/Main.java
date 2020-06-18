package com.example;

public class Main {

    public static void main(String[] args) {
    	SingleLinkedList<Employee> employeeSingleLinkedList = new SingleLinkedList<>();

	    Employee janeJones = new Employee("Jane", "Jones", 123);
	    Employee johnDoe = new Employee("John", "Doe", 4567);
	    Employee marySmith = new Employee("Mary", "Smith", 22);
	    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		System.out.println(employeeSingleLinkedList.isEmpty());

	    employeeSingleLinkedList.insertNode(janeJones);
	    employeeSingleLinkedList.insertNode(johnDoe);
	    employeeSingleLinkedList.insertNode(marySmith);
	    employeeSingleLinkedList.insertNode(mikeWilson);

	    employeeSingleLinkedList.printList();
		System.out.println(employeeSingleLinkedList.getSize());
		System.out.println(employeeSingleLinkedList.isEmpty());


		System.out.println();
		System.out.println(employeeSingleLinkedList.deleteNode());
		System.out.println(employeeSingleLinkedList.getSize());

		System.out.println();
		System.out.println(employeeSingleLinkedList.deleteNode());
		System.out.println(employeeSingleLinkedList.getSize());

		System.out.println();
		System.out.println(employeeSingleLinkedList.deleteNode());
		System.out.println(employeeSingleLinkedList.getSize());

		System.out.println();
		System.out.println(employeeSingleLinkedList.deleteNode());
		System.out.println(employeeSingleLinkedList.getSize());

		System.out.println(employeeSingleLinkedList.isEmpty());


	}
}
