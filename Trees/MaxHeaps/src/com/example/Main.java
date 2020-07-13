package com.example;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printArrayTree();
        heap.delete(1);
        heap.printArrayTree();
        System.out.println(heap.peek());

    }
}
