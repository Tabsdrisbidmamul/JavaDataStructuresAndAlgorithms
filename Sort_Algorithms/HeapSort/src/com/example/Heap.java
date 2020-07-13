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

    public int delete(int index) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }


        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];
        heap[size - 1] = 0;

        if(index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;

    }

    public int peek() {
        if(!isEmpty()) {
            return heap[0];
        }
        throw new IndexOutOfBoundsException("Cannot peek at an Empty Heap");
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

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childSwap;

        while(index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            // left child exists
            if(leftChild <= lastHeapIndex) {
                // does not have a right child
                if(rightChild > lastHeapIndex) {
                    childSwap = leftChild;
                } else {
                    // choose the larger of the 2 children
                    childSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                }

                if(heap[index] < heap[childSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childSwap];
                    heap[childSwap] = temp;
                } else {
                    break;
                }

                index = childSwap;
            } else {
                break;
            }
        }
    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for(int i=0; i < lastHeapIndex; i++) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;

            // lastHeapIndex - i being the point in the iteration and the minus 1 is to make sure that it does not
            // include the sorted partition
            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    private int getChild(int parentIndex, boolean left) {
        return 2 * parentIndex + (left ? 1 : 2);
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private boolean isEmpty() {
        return size == 0;
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
