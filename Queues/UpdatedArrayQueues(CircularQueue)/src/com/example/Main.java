package com.example;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        ArrayQueue queue = new ArrayQueue(5);

        // WRAPPING THE QUEUE
        queue.enqueue(janeJones);
        queue.enqueue(johnDoe);

        queue.dequeue();

        queue.enqueue(marySmith);

        queue.dequeue();

        queue.enqueue(mikeWilson);

        queue.dequeue();

        queue.enqueue(billEnd);

        queue.dequeue();

        queue.enqueue(janeJones);


        // RESIZING THE QUEUE
//        queue.enqueue(janeJones);
//        queue.enqueue(johnDoe);
//        queue.enqueue(marySmith);
//        queue.enqueue(mikeWilson);
//        queue.enqueue(billEnd);
//
//        queue.printQueue();
//        System.out.println("----------------------------");
//
//        System.out.printf("Dequeue value: %s\n", queue.dequeue());
//        System.out.printf("Dequeue value: %s\n", queue.dequeue());
//        System.out.println("----------------------------");
//        queue.printQueue();
//        System.out.println("----------------------------");
//
//        System.out.printf("Peeked value: %s\n", queue.peek());
//        System.out.println("----------------------------");
//        queue.printQueue();
//        System.out.println("----------------------------");
//
//        System.out.printf("Dequeue value: %s\n", queue.dequeue());
//        System.out.printf("Dequeue value: %s\n", queue.dequeue());
//        System.out.printf("Dequeue value: %s\n", queue.dequeue());
////        System.out.printf("Dequeue value: %s\n", queue.dequeue());
//        queue.enqueue(mikeWilson);
//        System.out.println("----------------------------");
//        queue.printQueue();
//        System.out.println("----------------------------");


    }
}
