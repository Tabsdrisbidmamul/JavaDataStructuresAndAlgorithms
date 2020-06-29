package com.example;

import java.util.IllegalFormatCodePointException;
import java.util.NoSuchElementException;

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
        /*
        * 0: el_1  front
        * 1: el_2
        * 2: el_3
        * 4: el_4  back
        *
        * if we want to add another el here, we cannot wrap round the queue and bring back to the beginning of the
        * array - because well it is still full
        *
        * that is from the
        * size(): back - front (4 - 0) = 4
        * is 4 == queue.length - 1 (4)
        * yes
        *
        * so lets resize the array
        *
        * That is another reason why we check if the back is less than the length of the array - 1 so we can safely
        * increment the back to the next position
        *
        * if not, then we can wrap the back pointer round the array to the beginning to start using the empty space
        * at the beginning of the array
        *
        * Another problem is the wrapping of the queue - when we come to resize the array, we do so by starting from
        * the front pointer and go all the way to the back pointer
        *
        * With the back pointer wrapped, we need to sort out the resizing by copying the elements from the front to
        * the queue.length - 1
        *
        * then the start of the array to the back pointer into the new array, where we place front pointer to the
        * start of the array, and back pointer to the last element of the array - which we can get from newArray
        * .length - size() -> new back pointer position
        *
        *
        *
        *
        * */
        if(this.size() == this.queue.length - 1) {
            int numItems = this.size();
            Employee[] newArray = new Employee[2 * this.queue.length];

            /*
            * this.queue.length - this.front := here its the num of items to push onto the newArray
            *
            * */
            System.arraycopy(this.queue, this.front, newArray, 0, this.queue.length - this.front);

            /*
            * queue.length - this.front := index position of the next available spot in the array
            *
            * this.back := the number of items to append onto the array as this.back - 0 is the num of items left to
            * push
            * */
            System.arraycopy(this.queue, 0, newArray, queue.length - this.front, this.back);

            this.queue = newArray;
            this.front = 0;
            this.back = numItems;
        }
        this.queue[this.back] = employee;

        if(this.back < this.queue.length - 1) {
            this.back++;
        } else {
            this.back = 0;
        }
    }

    public Employee dequeue() {
        // check if the queue is empty
        if(this.size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = this.queue[this.front];
        this.queue[this.front] = null;
        this.front++;

        if(this.size() == 0){
            this.front = this.back = 0;
        } else if(this.front == this.queue.length) {
            this.front = 0;
        }

        return employee;
    }

    public Employee peek() {
        if(this.size() == 0) {
            throw new NoSuchElementException();
        }
        return this.queue[this.front];
    }

    public int size() {
        if(this.front <= this.back) {
            return this.back - this.front;
        } else {
            // adjust the negative value by adding the length of the backing array
            return this.back - this.front + this.queue.length;
        }

    }


    public void printQueue() {
        if(this.front <= this.back) {
            System.out.println("---QUEUE---");
            for(int i=this.front; i < this.back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            System.out.println("---QUEUE---");
            for(int i=this.front; i < this.queue.length; i++) {
                System.out.println(this.queue[i]);
            }

            for (int i=0; i<this.back; i++) {
                System.out.println(this.queue[i]);
            }
        }

    }



}
