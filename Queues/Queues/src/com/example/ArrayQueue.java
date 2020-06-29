package com.example;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.DoubleAccumulator;

public class ArrayQueue {
    private Employee[] queue;
    // front and back when initialised are equal to zero
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        this.queue = new Employee[capacity];
    }

    public void enqueue(Employee employee) {
        // back always points to the next available position
        if(this.size() == this.queue.length) {
            Employee[] newArray = new Employee[2 * this.queue.length];
            System.arraycopy(this.queue, 0, newArray, 0, this.queue.length);
            this.queue = newArray;
        }
        queue[back++] = employee;
    }

    public Employee dequeue() {
        // check if the queue is empty
        if(this.size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = this.queue[this.front];
        this.queue[this.front] = null;
        this.front++;

        if(this.size() == 0) this.front = this.back = 0;

        return employee;
    }

    public Employee peek() {
        if(this.size() == 0) {
            throw new NoSuchElementException();
        }
        return this.queue[this.front];
    }

    public int size() {
        return this.back - this.front;
    }


    public void printQueue() {
        System.out.println("---QUEUE---");
        for(int i=this.front; i < this.back; i++) {
            System.out.println(queue[i]);
        }
    }



}
