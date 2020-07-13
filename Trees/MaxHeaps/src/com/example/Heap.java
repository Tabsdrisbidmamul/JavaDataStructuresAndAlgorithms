package com.example;

import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if(isFull()) {
            resize();
        }

        heap[size] = value;
        fixHeapAbove(size);
        size++;

    }

    private void fixHeapAbove(int index) {
        // store the inserted value in a temp variable
        int newValue = heap[index];

        // loop over the array making sure that we are comparing the inserted value with its parents, and we are
        // shifting the parents down the tree
        while(index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        // once we have broken out of the loop, then we assign the inserted value in its new position - its redundant
        // to keep swapping the parent and new element at each pass, because we are ultimately placing the new value
        // in its rightful place
        heap[index] = newValue;
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private void resize() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    public void printArrayTree() {
        System.out.println(Arrays.toString(heap));
    }


}
