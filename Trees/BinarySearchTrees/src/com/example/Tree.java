package com.example;

import javax.swing.tree.TreeNode;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        if(isEmpty()) {
            System.out.printf("Empty tree, inserting %d as the root node\n", value);
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    private class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        private TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void insert(int value) {
            // Duplicates are not added to the tree
            if(data == value) {
                System.out.printf("Duplicate Values (%d) are not allowed\n", value);
                return;
            }

            // check to see if the data is less than the parent node - if so traverse the left subtree
            if(value < data) {
                // found an empty spot! insert the value here
                if(leftChild == null) {
                    System.out.printf("Inserting node value %d at the left subtree\n", value);
                    leftChild = new TreeNode(value);
                // leftChild spot is full, call the insert method on that node till we hit an empty spot
                } else {
                    System.out.printf("Left child spot is full, calling insert on this the left child node for value " +
                            "%d" +
                            " %s\n", value, this);
                    leftChild.insert(value);
                }
            // traversing the right subtree because the value was greater than the parent node
            } else {
                // found an empty spot! insert the value here
                if(rightChild == null) {
                    System.out.printf("Inserting node value %d at the right subtree\n", value);
                    rightChild = new TreeNode(value);
                // rightChild spot is full, call the insert method on that node till we hit an empty spot
                } else {
                    System.out.printf("Right child spot is full, calling insert on this the right child node for " +
                            "value %d" +
                            " %s\n", value, this);
                    rightChild.insert(value);
                }
            }
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
