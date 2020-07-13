package com.example;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(2);
        heap.insert(22);
        heap.insert(20);
        heap.printArrayTree();
        heap.insert(18);
        heap.insert(19);
        heap.printArrayTree();

    }
}
