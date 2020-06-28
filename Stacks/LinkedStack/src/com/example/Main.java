package com.example;

public class Main {

    public static void main(String[] args) {
	    Employee janeJones = new Employee("Jane", "Jones", 123);
	    Employee johnDoe = new Employee("John", "Doe", 4567);
	    Employee marySmith = new Employee("Mary", "Smith", 22);
	    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
	    Employee billEnd = new Employee("Bill", "End", 78);

        LinkedStack stack = new LinkedStack();

        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

        stack.printStack();
        System.out.printf("Size of the Stack: %d\n", stack.getSize());
        System.out.println("---------------");


        System.out.printf("Popped value: %s\n", stack.pop());
        stack.printStack();
        System.out.printf("Size of the Stack: %d\n", stack.getSize());
        System.out.println("---------------");


        System.out.printf("Peeked value: %s\n", stack.peek());
        stack.printStack();
        System.out.printf("Size of the Stack: %d\n", stack.getSize());
        System.out.println("---------------");
    }
}
